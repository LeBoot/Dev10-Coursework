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
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
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
public class RoomDaoDBTest {
    
    //Autowire the DAOs to be used ---------------------------------------------
    @Autowired
    RoomDao roomDao;
    
    @Autowired
    EmployeeDao employeeDao;
    
    @Autowired
    MeetingDao meetingDao;
    
//--------------------------------------------------------------------------
    public RoomDaoDBTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Room> rooms = roomDao.getAllRooms();
        for(Room room : rooms) {
            roomDao.deleteRoomById(room.getId());
        }
        
        List<Employee> employees = employeeDao.getAllEmployees();
        for(Employee employee : employees) {
            employeeDao.deleteEmployeeById(employee.getId());
        }
        
        List<Meeting> meetings = meetingDao.getAllMeetings();
        for(Meeting meeting : meetings) {
            meetingDao.deleteMeetingById(meeting.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

// TESTS -----------------------------------------------------------------------
    @Test
    public void testAddANDGetRoomById() {
        //create a new room object and add the appropriate information
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        
        //add that room into the database
        room = roomDao.addRoom(room);
        
        //try to retrieve that room
        Room fromDao = roomDao.getRoomById(room.getId());
        
        //check that the room pulled from the database matches the one that was put in
            //NB, equals and hashcode must be enabled
        assertEquals(room, fromDao);
    }
    

    @Test
    public void testGetAllRooms() {
        //create a new room object and add the appropriate information
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        //add that room into the database
        roomDao.addRoom(room);
        
        //create a second new room object and add the appropriate information
        Room room2 = new Room();
        room2.setName("Test Room 2");
        room2.setDescription("Test Room 2");
        //add that room into the database
        roomDao.addRoom(room2);
        
        //Call "getAllRooms" and save it into a list
        List<Room> rooms = roomDao.getAllRooms();
        
        //assert that the list has exaclty two rooms
        assertEquals(2, rooms.size());
        
        //assert that each room we added is in the list returend
        assertTrue(rooms.contains(room));
        assertTrue(rooms.contains(room2));
    }
  

    @Test
    public void testUpdateRoom() {
        //create a new room object and add the appropriate information
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        //add that room into the database
        room = roomDao.addRoom(room);
        
        //retrieve that room
        Room fromDao = roomDao.getRoomById(room.getId());
        //verify that it is the one just added
        assertEquals(room, fromDao);
        
        //change something about that object
        room.setName("Another Test Room");
        //call the update method
        roomDao.updateRoom(room);
        
        //check that the old and new ojects do not match
        assertNotEquals(room, fromDao);
        
        //retrieve the updated room
        fromDao = roomDao.getRoomById(room.getId());
        //check that it has been updated correclty
        assertEquals(room, fromDao);
    }

    
    @Test
    public void testDeleteRoom() {
        //create a new room object and add the appropriate information
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        //add that room into the database
        room = roomDao.addRoom(room);
        
        //create a new employee object and add the appropriate information
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        //add that employee into the database
        employee = employeeDao.addEmployee(employee);
        
        //this block creates links between several tables in the DB
        //create a meeting object and add the appropriate information
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now());
        meeting.setRoom(room);
        //create a list of employees
        List<Employee> employees = new ArrayList<>();
        //add the newly-created employee to it
        employees.add(employee);
        //add the list of employee(s) to the meeting
        meeting.setAttendees(employees);
        //add the meeting to the database
        meeting = meetingDao.addMeeting(meeting);
        
        //delete that room
        roomDao.deleteRoomById(room.getId());
        
        //try to retrive room from database
        Room fromDao = roomDao.getRoomById(room.getId());
        //assert that the room is not there
        assertNull(fromDao);
    }
    
}