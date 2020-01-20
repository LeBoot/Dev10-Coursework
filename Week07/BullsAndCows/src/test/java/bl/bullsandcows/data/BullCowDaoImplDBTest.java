/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcows.data;

import bl.bullsandcows.models.BullCowGameObject;
import bl.bullsandcows.models.BullCowRoundObject;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Boone
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BullCowDaoImplDBTest {
    @Autowired
    private BullCowDao dao;
    
    public BullCowDaoImplDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<BullCowGameObject> games = dao.getAllGames();
        for (BullCowGameObject game : games) {
            dao.deleteRoundByGameId(game.getGameID());
            dao.deleteGameById(game.getGameID());
        }
    }
 
    @After
    public void tearDown() {
    }
    
    /*
    TESTS ----------------------------------------------------------------------
    ----------------------------------------------------------------------------
    */
    
    //CRUD for gameObjects -----------------------------------------------------
    @Test
    public void testAddGameANDgetGameByID() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setGameID(1);
        newGame.setAnswer("1234");
        dao.addGame(newGame);
        
        //retrieve game
        BullCowGameObject gameFromDao = dao.getGameById(newGame.getGameID());
        
        //assert that game added and game retrieved are the same
        assertEquals(newGame, gameFromDao);
    }
    
    @Test
    public void testGetAllGames() {
        //add one game
        BullCowGameObject game1 = new BullCowGameObject();
        game1.setAnswer("1234");
        dao.addGame(game1);
        
        //add second game
        BullCowGameObject game2 = new BullCowGameObject();
        game2.setAnswer("4321");
        dao.addGame(game2);
        
        //call getall method
        List<BullCowGameObject> games = dao.getAllGames();
        
        //assertions
        assertEquals(2, games.size());
        assertTrue(games.contains(game1));
        assertTrue(games.contains(game2));
    }

    @Test
    public void testUpdateGame() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setGameID(1);
        newGame.setAnswer("1234");
        dao.addGame(newGame);
        
        //retrive game
        newGame = dao.getGameById(newGame.getGameID());
        
        //call update method
        BullCowGameObject updatedGame = dao.updateGame(newGame);
        
        //verify that the status of the updated game and game pulled from the DAO are not equal
        assertNotEquals(newGame.getStatus(), updatedGame.getStatus());
    }
    
    
    //CRUD for roundObjects ----------------------------------------------------
    @Test
    public void testAddRoundANDGetAllRoundsByGameID() {
        //make and add two rounds, each for the same game
        BullCowRoundObject round1 = new BullCowRoundObject();
        round1.setGameID(1);
        round1.setGuess("1234");
        round1.setRoundResults("e:0:p:0");
        round1.setTimeOfGuess(LocalDateTime.now());
        dao.addRound(round1);
        
        BullCowRoundObject round2 = new BullCowRoundObject();
        round2.setGameID(1);
        round2.setGuess("1234");
        round2.setRoundResults("e:0:p:0");
        round2.setTimeOfGuess(LocalDateTime.now());
        dao.addRound(round2);
        
        //make and add one round, for a different game than the first two rounds
        BullCowRoundObject round3 = new BullCowRoundObject();
        round3.setGameID(2);
        round3.setGuess("1234");
        round3.setRoundResults("e:0:p:0");
        round3.setTimeOfGuess(LocalDateTime.now());
        dao.addRound(round3);
        
        //call getAllRounds method
        List<BullCowRoundObject> listGame1 = dao.getAllRoundsByGameID(1);
        List<BullCowRoundObject> listGame2 = dao.getAllRoundsByGameID(2);
        
        //assertions
        assertEquals(2, listGame1.size());
        assertTrue(listGame1.contains(round1));
        assertTrue(listGame1.contains(round2));
        assertFalse(listGame1.contains(round3));
        
        assertEquals(1, listGame2.size());
        assertFalse(listGame2.contains(round1));
        assertFalse(listGame2.contains(round2));
        assertTrue(listGame2.contains(round3));
    }
    
    //CRUD for unit testing ----------------------------------------------------
    @Test
    public void testDeleteGameById() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setGameID(1);
        newGame.setAnswer("1234");
        dao.addGame(newGame);
        
        //retrieve all game
        List<BullCowGameObject> allGames = dao.getAllGames();
        
        //check that list has game
        assertTrue(allGames.contains(newGame));
        
        //delete the game
        dao.deleteGameById(newGame.getGameID());
        
        //retrieve all games again
        List<BullCowGameObject> updatedList = dao.getAllGames();
        
        //check that the list does not have the game
        assertFalse(updatedList.contains(newGame));
    }
    
    @Test
    public void testDeleteRoundByGameId() {
        //make and add a new round
        BullCowRoundObject round1 = new BullCowRoundObject();
        round1.setGameID(1);
        round1.setGuess("1234");
        round1.setRoundResults("e:0:p:0");
        round1.setTimeOfGuess(LocalDateTime.now());
        dao.addRound(round1);
        
        //retrieve all round for that game
        List<BullCowRoundObject> allRounds = dao.getAllRoundsByGameID(round1.getGameID());
        
        //check that list has round
        assertTrue(allRounds.contains(round1));
        
        //delete the round
        dao.deleteRoundByGameId(round1.getGameID());
        
        //retrieve all rounds again
        List<BullCowRoundObject> updatedList = dao.getAllRoundsByGameID(round1.getGameID());
        
        //check that the list does not have the game
        assertFalse(updatedList.contains(round1));
    }
}