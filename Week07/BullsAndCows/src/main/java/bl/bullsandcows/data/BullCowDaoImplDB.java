/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcows.data;

import bl.bullsandcows.models.BullCowGameObject;
import bl.bullsandcows.models.BullCowRoundObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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
@Profile("database")
public class BullCowDaoImplDB implements BullCowDao {
 
    /*
    Making JdbcTemplate final and putting it in the constructor ensures that
    there will only ever be the one instance of the class, regardless of how 
    many users there might be.
    If you don't care how many people might instantiate it, you could just declare
    the JdbcTemplate, add @Autowire, and do not declare it final or add a constructor
    */
    private final JdbcTemplate jdbc;
    @Autowired
    public BullCowDaoImplDB(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    //CRUD for gameObjects -----------------------------------------------------
    
    @Override
    @Transactional
    public BullCowGameObject addGame(BullCowGameObject game) {
        final String ADD_GAME = "INSERT INTO games (answer) VALUES (?);";
        jdbc.update(ADD_GAME, game.getAnswer());
        
        int newGameID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        return getGameById(newGameID);
    }
    
    
    @Override
    @Transactional
    public List<BullCowGameObject> getAllGames() {
        final String sql = "SELECT GameID, Answer, GameStatus FROM games";
        return jdbc.query(sql, new GameMapper());        
    }

    
    @Override
    @Transactional
    public BullCowGameObject getGameById(int gameID) {
        try {
            final String SELECT_GAME_BY_ID = "SELECT * FROM games WHERE GameID = ?;";
            BullCowGameObject game = jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), gameID);
            return game;            
        } catch(DataAccessException ex) {
            return null;
        }
    }

    
    @Override
    @Transactional
    public BullCowGameObject updateGame(BullCowGameObject game) {
        final String UPDATE_GAME = "UPDATE games SET GameStatus = ? WHERE GameID = ?;";
        jdbc.update(UPDATE_GAME, "Finished", game.getGameID());
        return getGameById(game.getGameID());
    }
    
    //CRUD for roundObjects ----------------------------------------------------
    
    @Override
    @Transactional
    public BullCowRoundObject addRound(BullCowRoundObject round) {
        final String ADD_ROUND = "INSERT INTO allRounds (TimeOfGuess, RoundResults, Guess, GameID) VALUES (?, ?, ?, ?);";
        jdbc.update(ADD_ROUND,
                Timestamp.valueOf(round.getTimeOfGuess()),
                round.getRoundResults(),
                round.getGuess(),
                Integer.toString(round.getGameID()));
        
        int newRoundID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        round.setRoundID(newRoundID);
        
        return round;
    }
    

    @Override
    @Transactional
    public List<BullCowRoundObject> getAllRoundsByGameID(int gameID) {
        final String sql = "SELECT RoundID, TimeOfGuess, RoundResults, Guess, GameID "
                + "FROM allRounds WHERE GameID = ?;";
        return jdbc.query(sql, new RoundMapper(), gameID);
    }
    
    
    //Mappers ------------------------------------------------------------------
    
    private static final class GameMapper implements RowMapper<BullCowGameObject> {
        @Override
        public BullCowGameObject mapRow(ResultSet rs, int index) throws SQLException {
            BullCowGameObject game = new BullCowGameObject();
            game.setGameID(rs.getInt("gameID"));
            game.setAnswer(rs.getString("Answer"));
            game.setStatus(rs.getString("GameStatus"));
            return game;
        }
    }
    
    private static final class RoundMapper implements RowMapper<BullCowRoundObject> {
        @Override
        public BullCowRoundObject mapRow(ResultSet rs, int index) throws SQLException {
            BullCowRoundObject round = new BullCowRoundObject();
            round.setRoundID(rs.getInt("RoundID"));
            round.setTimeOfGuess(rs.getTimestamp("TimeOfGuess").toLocalDateTime());
            round.setRoundResults(rs.getString("RoundResults"));
            round.setGuess(rs.getString("Guess"));
            round.setGameID(rs.getInt("GameID"));
            return round;
        }
    }
    
    
    //Delete methods for unit testing ------------------------------------------
    
    @Override
    @Transactional
    public void deleteGameById(int gameID) {
        //note, the gameID might be a foreign key in the AllRoudns table.  Make
            //sure to delete those references first
        final String DELETE_GAME = "DELETE FROM games WHERE GameID = ?";
        jdbc.update(DELETE_GAME, gameID);
    }
    
    @Override
    @Transactional
    public void deleteRoundByGameId(int gameID) {
        final String DELETE_ROUND = "DELETE FROM allRounds WHERE GameID = ?";
        jdbc.update(DELETE_ROUND, gameID);
    }

}