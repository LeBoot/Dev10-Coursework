/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@Repository //This annotation allows for using the @Autowired annotation (maybe)
    //indicates that the data in this class will be persisted
public class RoomDaoDB implements RoomDao {

    @Autowired //autowire JDBCTemplate
    JdbcTemplate jdbc;
    
    //This creates the RowMapper
    //It is public so that we can access this mapper to add a Room object 
        //to the Meeting objects when we implement the Meeting DAO.
    public static final class RoomMapper implements RowMapper<Room> {

        @Override
        public Room mapRow(ResultSet rs, int index) throws SQLException {
            Room rm = new Room();
            rm.setId(rs.getInt("id"));
            rm.setName(rs.getString("name"));
            rm.setDescription(rs.getString("description"));
            return rm;
        }
    }
    
    //CRUD methods -------------------------------------------------------------
    @Override
    public List<Room> getAllRooms() {
        //declare the query as a string
        final String SELECT_ALL_ROOMS = "SELECT * FROM room";
        
        //return the results of the query (a list of rooms) using the query String
            //and RoomMapper as parameters
        return jdbc.query(SELECT_ALL_ROOMS, new RoomMapper());
    }

    @Override
    public Room getRoomById(int id) {
        try {
            //same as getAllRooms() method, except with the new parameter "id"
            final String SELECT_ROOM_BY_ID = "SELECT * FROM room WHERE id = ?";
            return jdbc.queryForObject(SELECT_ROOM_BY_ID, new RoomMapper(), id);
        } catch(DataAccessException ex) {
            //if no object is found, an exception will be thrown
            //return null as an indicator that no object was retrieved
            return null;
        }
    }

    @Override
    @Transactional //This means that every query run is a single transaction, so if
        //any queries fail, the program will roll back all of them.
        //Additonally, these queries will run together, with no other queries being inserted
    public Room addRoom(Room room) {
        //create a query to create a new room, and run using the "update" method
        final String INSERT_ROOM = "INSERT INTO room(name, description) VALUES(?,?)";
        jdbc.update(INSERT_ROOM, 
                room.getName(), 
                room.getDescription());
        
        //run another query to get the room id for the just-created room
        //LAST_INSERT_ID() is a built-in function that returns the ID of the most recent
            //row inserted into the database, because we are using @Transaction,
            //the INSERTed row is guarenteed to be the last one
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        //put that ID into the room object and return it
        room.setId(newId);
        return room;
    }

    @Override
    public void updateRoom(Room room) {
        //update a room; rather straight-forward
        final String UPDATE_ROOM = "UPDATE room SET name = ?, description = ? WHERE id = ?";
        jdbc.update(UPDATE_ROOM,
                room.getName(),
                room.getDescription(),
                room.getId());
    }

    @Override
    @Transactional //same notation as above, to ensure that all queries succeed or fail together
    public void deleteRoomById(int id) {
        //multi-tier deletion because of foreign key relationships
        
        //first, delete from 'meeting-employee' table
        final String DELETE_MEETING_EMPLOYEE_BY_ROOM = "DELETE me.* FROM meeting_employee me "
                + "JOIN meeting m ON me.meetingId = m.id WHERE m.roomId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE_BY_ROOM, id);
        
        //then, delete from 'meeting' table
        final String DELETE_MEETING_BY_ROOM = "DELETE FROM meeting WHERE roomId = ?";
        jdbc.update(DELETE_MEETING_BY_ROOM, id);
        
        //finally, delete from 'room' table
        final String DELETE_ROOM = "DELETE FROM room WHERE id = ?";
        jdbc.update(DELETE_ROOM, id);
    }  
    
}
