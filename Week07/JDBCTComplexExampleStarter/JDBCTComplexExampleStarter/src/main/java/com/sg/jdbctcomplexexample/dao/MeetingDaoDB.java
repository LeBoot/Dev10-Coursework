/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.dao.EmployeeDaoDB.EmployeeMapper;
import com.sg.jdbctcomplexexample.dao.RoomDaoDB.RoomMapper;
import com.sg.jdbctcomplexexample.entity.Employee;
import com.sg.jdbctcomplexexample.entity.Meeting;
import com.sg.jdbctcomplexexample.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Boone
 */
@Repository
public class MeetingDaoDB implements MeetingDao {

    @Autowired
    JdbcTemplate jdbc;
    
    //Create meetingMapper
    //This method could be private, but keep it public for consistency
    public static final class MeetingMapper implements RowMapper<Meeting> {
        @Override
        public Meeting mapRow(ResultSet rs, int index) throws SQLException {
            Meeting meet = new Meeting();
            meet.setId(rs.getInt("id"));
            meet.setName(rs.getString("name"));
            
            //Bring in a timeStamp and then convert it to LocalDate time;
                //the same thing should be done with DATE and localDate
            meet.setTime(rs.getTimestamp("time").toLocalDateTime());
            return meet;
        }
    }
    
    //CRUD methods -------------------------------------------------------------
    @Override
    public List<Meeting> getAllMeetings() {
        //query for a list of the meetings, and retrieve them in a list
        final String SELECT_ALL_MEETINGS = "SELECT * FROM meeting";
        List<Meeting> meetings = jdbc.query(SELECT_ALL_MEETINGS, new MeetingMapper());
        
        //flesh out the meeting by using this helper method to add employees and rooms
        addRoomAndEmployeesToMeetings(meetings);
        
        //return the full-fleshed meeting
        return meetings;
    }

    @Override
    public Meeting getMeetingByid(int id) {
        try { //Try-catch for in case the object is not found and an exception is thrown
            //Create the query string and call it with "queryForObject"
            //Save the Meeting as a variable so that it can be added to other objects
            final String SELECT_MEETING_BY_ID = "SELECT * FROM meeting WHERE id = ?";
            Meeting meeting = jdbc.queryForObject(SELECT_MEETING_BY_ID, 
                    new MeetingMapper(), id);
            
            //get the room for the meeting, using private method below
            meeting.setRoom(getRoomForMeeting(meeting));
            
            //get the attendees for the meeting, using private method below
            meeting.setAttendees(getEmployeesForMeeting(meeting));
            
            //return the meeting
            return meeting;
        } catch(DataAccessException ex) {
            //if no meeting was found from the database, retun null
            return null;
        }
    }
    
    @Override
    @Transactional //To guarantee we get the correct ID out of the database.
    public Meeting addMeeting(Meeting meeting) {
        //Create anINSERT String and enter it into an "update" method (with the appropriate data).
        final String INSERT_MEETING = "INSERT INTO meeting(name, time, roomId) VALUES(?,?,?)";
        jdbc.update(INSERT_MEETING,
                meeting.getName(),
                Timestamp.valueOf(meeting.getTime()),
                meeting.getRoom().getId());
        
        //We query LAST_INSERT_ID() to find the ID for the Meeting and put it into the Meeting itself.
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        //assign that ID to the meeting
        meeting.setId(newId);
        
        //call a helper method to add the meeting to the meeting-employee bridge table
        insertMeetingEmployee(meeting);
        
        //return the meeting
        return meeting;
    }
    
    @Override
    @Transactional //because we are making multiple calls to the database that will modify it.
    public void updateMeeting(Meeting meeting) {
        //create an update string and put the appropriate information
        final String UPDATE_MEETING = "UPDATE meeting "
                + "SET name = ?, time = ?, roomId = ? WHERE id = ?";
        jdbc.update(UPDATE_MEETING,
                meeting.getName(),
                
                //same as in ADD method
                Timestamp.valueOf(meeting.getTime()),
                meeting.getRoom().getId(),
                meeting.getId());
        
        //delete the places in the meeting-employee bridge table where that meeting was
            //referenced, but then re-create the necessary data in the bridge by calling
            //the helper method
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                + "WHERE meetingId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, meeting.getId());
        insertMeetingEmployee(meeting);
    }

    @Override
    public void deleteMeetingById(int id) {
        //delete meeting from bridge table
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                + "WHERE meetingId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, id);
        
        //delete bridge itself
        final String DELETE_MEETING = "DELETE FROM meeting WHERE id = ?";
        jdbc.update(DELETE_MEETING, id);
    }

    @Override
    public List<Meeting> getMeetingsForRoom(Room room) {
        //make a query to retrieve a list of meetings associated with a given roomID
        final String SELECT_MEETINGS_FOR_ROOM = "SELECT * FROM meeting WHERE roomId = ?";
        List<Meeting> meetings = jdbc.query(SELECT_MEETINGS_FOR_ROOM, 
                new MeetingMapper(), room.getId());
        
        //helper method defined below
        addRoomAndEmployeesToMeetings(meetings);
        
        return meetings;
    }

    @Override
    public List<Meeting> getMeetingsForEmployee(Employee employee) {
        //make a query to retrieve a list of meetings associated with a given employeeID
        final String SELECT_MEETINGS_FOR_EMPLOYEE = "SELECT * FROM meeting m "
                + "JOIN meeting_employee me ON m.id = me.meetingId WHERE me.employeeId = ?";
        List<Meeting> meetings = jdbc.query(SELECT_MEETINGS_FOR_EMPLOYEE, 
                new MeetingMapper(), employee.getId());
        
        //helper method defined below
        addRoomAndEmployeesToMeetings(meetings);
        
        return meetings;
    }    
    
    //private (helper) methods -------------------------------------------------
    
    private Room getRoomForMeeting(Meeting meeting) { //pass in the meeting object that we care about
        //create a query String, joining from 'Room' to 'Meeting', to get the room object
        final String SELECT_ROOM_FOR_MEETING = "SELECT r.* FROM room r "
                + "JOIN meeting m ON r.id = m.roomId WHERE m.id = ?";
        return jdbc.queryForObject(SELECT_ROOM_FOR_MEETING, new RoomMapper(), 
                meeting.getId()); 
        //no need to include a try-catch, because by DB definitions, the meeting is
            //guarenteed to have a valid room and will not return null
    }
    
    private List<Employee> getEmployeesForMeeting(Meeting meeting) { //pass in the meeting object that we care about
        //see comments for the method above
        final String SELECT_EMPLOYEES_FOR_MEETING = "SELECT e.* FROM employee e "
                + "JOIN meeting_employee me ON e.id = me.employeeId WHERE me.meetingId = ?";
        return jdbc.query(SELECT_EMPLOYEES_FOR_MEETING, new EmployeeMapper(), 
                meeting.getId());
    }
    
     private void addRoomAndEmployeesToMeetings(List<Meeting> meetings) { //pass in the list of meetings
        //for every meeting, add the room and attendees
        for(Meeting meeting : meetings) {
            meeting.setRoom(getRoomForMeeting(meeting));
            meeting.setAttendees(getEmployeesForMeeting(meeting));
        }
    }
     
    //given a meeting, update the meeting-employee bridge table appropriately 
    private void insertMeetingEmployee(Meeting meeting) {
        //create a formatted query string
        final String INSERT_MEETING_EMPLOYEE = "INSERT INTO meeting_employee"
                + "(meetingId, employeeId) VALUES(?,?)";
        
        //loop over each employee that will be attending the meeting
        for(Employee employee : meeting.getAttendees()) {
            jdbc.update(INSERT_MEETING_EMPLOYEE, meeting.getId(), employee.getId());
        }
    }
   
}
