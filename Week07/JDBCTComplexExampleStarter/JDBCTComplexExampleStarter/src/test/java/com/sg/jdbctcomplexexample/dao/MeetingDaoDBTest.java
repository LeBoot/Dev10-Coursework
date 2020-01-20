/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.TestApplicationConfiguration;
import com.sg.jdbctcomplexexample.entity.Employee;
import com.sg.jdbctcomplexexample.entity.Meeting;
import com.sg.jdbctcomplexexample.entity.Room;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Boone
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class MeetingDaoDBTest {
    
    @Autowired
    RoomDao roomDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    MeetingDao meetingDao;
    
    public MeetingDaoDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Room> rooms = roomDao.getAllRooms();
        for (Room room : rooms) {
            roomDao.deleteRoomById(room.getId());
        }

        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.deleteEmployeeById(employee.getId());
        }

        List<Meeting> meetings = meetingDao.getAllMeetings();
        for (Meeting meeting : meetings) {
            meetingDao.deleteMeetingById(meeting.getId());
        }
    }
    
    @After
    public void tearDown() {
    }

    //TESTS --------------------------------------------------------------------
    @Test
    public void testGetAllMeetings() {
        //create and add a room and its details
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);

        //create and add an employee and its details
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        //create a list of employees and to it, add the newly-created one
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        //create and add a meeting object and its details
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        //set the time, but have nanoseconds = 0 because the database does not
            //track nanoseconds, and these must match
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        //create and add a second meeting
        Meeting meeting2 = new Meeting();
        meeting2.setName("Test Meeting 2");
        meeting2.setTime(LocalDateTime.now().withNano(0));
        meeting2.setRoom(room);
        meeting2.setAttendees(employees);
        meeting2 = meetingDao.addMeeting(meeting2);
        
        //retrive a list of meetings from the DB
        List<Meeting> meetings = meetingDao.getAllMeetings();
        
        //check that there are two meetings in the list
        assertEquals(2, meetings.size());
        
        //check that the two meetings in the list are the ones just added
        assertTrue(meetings.contains(meeting));
        assertTrue(meetings.contains(meeting2));
    }


    @Test
    public void testAddANDGetMeetingById() {
        //create and add a room and its details
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);

        //create and add an employee and its details
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        //create a list of employees and to it, add the newly-created one
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        //create a meeting object and its details
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        //set the time, but have nanoseconds = 0 because the database does not
            //track nanoseconds, and these must match
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        //add the meeting
        meeting = meetingDao.addMeeting(meeting);

        //retrieve the meeting
        Meeting fromDao = meetingDao.getMeetingByid(meeting.getId());

        //check that the retrived meeting equals the one just created
        assertEquals(meeting, fromDao);
    }
    
    
    public void testUpdateMeeting() {
        //create and add a room and its details
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);

        //create and add an employee and its details
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        //create a list of employees and to it, add the newly-created one
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        //create a meeting object and its details
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        //set the time, but have nanoseconds = 0 because the database does not
            //track nanoseconds, and these must match
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        //retrieve the meeting
        Meeting fromDao = meetingDao.getMeetingByid(meeting.getId());

        //check that the retrieved meeting is the one just added
        assertEquals(meeting, fromDao);
        
        //change something about the meeting
        meeting.setName("Test Meeting 2");
        
        //create and add a second employee to add to the meeting
        Employee employee2 = new Employee();
        employee2.setFirstName("Test First 2");
        employee2.setLastName("Test Last 2");
        employee2 = employeeDao.addEmployee(employee2);
        
        //add employee2 to the list of employees
        employees.add(employee2);
        
        //change the meeting's attendees to be the new list
        meeting.setAttendees(employees);
        
        //call update method one meeting
        meetingDao.updateMeeting(meeting);
        
        //ensure that the changed meeting is different from the one previously retrieved
        assertNotEquals(meeting, fromDao);
        
        //retrieve the updated meeting from the DAO
        fromDao = meetingDao.getMeetingByid(meeting.getId());

        //check that the newly-retrieved meeting equals the one we put in (updated version)
        assertEquals(meeting, fromDao);
    }

    @Test
    public void testDeleteMeeting() {
        //create and add an employee and its details
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        //create a list of employees and to it, add the newly-created one
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        
        //create and add a room and its details
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);

        //create a meeting object and its details
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        //set the time, but have nanoseconds = 0 because the database does not
            //track nanoseconds, and these must match
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);

        //delete the meeting just added
        meetingDao.deleteMeetingById(meeting.getId());
        
        //attempt to retrieve the just-deleted meeting
        Meeting fromDao = meetingDao.getMeetingByid(meeting.getId());
        
        //assert that that meeting does not exist
        assertNull(fromDao);
    }

    //METHODS UNIQUE TO THIS DAO -----------------------------------------------
    
    @Test
    public void testGetMeetingsForRoom() {
        //create and add an employee and its details
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        //create a list of employees and to it, add the newly-created one
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        
        //create and add a room and its details
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        //create and add a second room and its details
        Room room2 = new Room();
        room2.setName("Test Room 2");
        room2.setDescription("Test Room Description 2");
        room2 = roomDao.addRoom(room2);
        
        //create and add a meeting object and its details
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        //set the time, but have nanoseconds = 0 because the database does not
            //track nanoseconds, and these must match
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        //create and add a second meeting
        Meeting meeting2 = new Meeting();
        meeting2.setName("Test Meeting");
        meeting2.setTime(LocalDateTime.now().withNano(0));
        meeting2.setRoom(room2);
        meeting2.setAttendees(employees);
        meeting2 = meetingDao.addMeeting(meeting2);
        
        //create and add a third meeting
        Meeting meeting3 = new Meeting();
        meeting3.setName("Test Meeting");
        meeting3.setTime(LocalDateTime.now().withNano(0));
        meeting3.setRoom(room);
        meeting3.setAttendees(employees);
        meeting3 = meetingDao.addMeeting(meeting3);
        
        //call get meetings by room ID
        List<Meeting> meetingsForRoom = meetingDao.getMeetingsForRoom(room);
        
        //check that although 3 meetings were added, only 2 were returned based on the room ID
        assertEquals(2, meetingsForRoom.size());
        
        //check that the 2 meetings returned are the appropriate ones for the room called
        assertTrue(meetingsForRoom.contains(meeting));
        assertTrue(meetingsForRoom.contains(meeting3));
        assertFalse(meetingsForRoom.contains(meeting2));
    }

    @Test
    public void testGetMeetingsForEmployee() {
        //create and add an employee and its details
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        //create and add a second employee and its details
        Employee employee2 = new Employee();
        employee2.setFirstName("Test First 2");
        employee2.setLastName("Test Last 2");
        employee2 = employeeDao.addEmployee(employee2);

        //add both employees to a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        
        //add only one of the employees to a second list of employees
        List<Employee> employees2 = new ArrayList<>();
        employees2.add(employee2);
        
        //create and add a room and its details
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        //create and add a meeting object and its details
        //use employee list 1
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now().withNano(0));
        meeting.setRoom(room);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        //create and add a second meeting object and its details
        //use employee list 2
        Meeting meeting2 = new Meeting();
        meeting2.setName("Test Meeting");
        meeting2.setTime(LocalDateTime.now().withNano(0));
        meeting2.setRoom(room);
        meeting2.setAttendees(employees2);
        meeting2 = meetingDao.addMeeting(meeting2);
        
        //create and add a third meeting object and its details
        //use employee list 1
        Meeting meeting3 = new Meeting();
        meeting3.setName("Test Meeting");
        meeting3.setTime(LocalDateTime.now().withNano(0));
        meeting3.setRoom(room);
        meeting3.setAttendees(employees);
        meeting3 = meetingDao.addMeeting(meeting3);
        
        //call the meetings for the first employee
        List<Meeting> meetingsForEmployee = meetingDao.getMeetingsForEmployee(employee);
        
        //check that there were two meetings returned
        assertEquals(2, meetingsForEmployee.size());
        
        //check that the employee is assigned to the correct two meetings
        assertTrue(meetingsForEmployee.contains(meeting));
        assertTrue(meetingsForEmployee.contains(meeting3));
        assertFalse(meetingsForEmployee.contains(meeting2));
    }
    
}