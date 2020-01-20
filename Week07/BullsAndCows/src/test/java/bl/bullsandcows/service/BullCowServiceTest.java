/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcows.service;

import bl.bullsandcows.data.BullCowDao;
import bl.bullsandcows.models.BullCowGameObject;
import bl.bullsandcows.models.BullCowRoundObject;
import java.time.LocalDateTime;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
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
@SpringBootTest
public class BullCowServiceTest {
    
    @Autowired
    BullCowService service;
    
    @Autowired
    BullCowDao dao;
    
    public BullCowServiceTest() {
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
     */
    @Test
    public void testAddGameANDGetGameByID() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setGameID(1);
        newGame.setAnswer("1234");
        service.addGame(newGame);
        
        //retrieve game
        BullCowGameObject gameFromDao = service.getGameById(newGame.getGameID(), false);
        
        //assert that game added and game retrieved are the same
        assertEquals(newGame, gameFromDao);
    }

    @Test
    public void testAddRoundANDGetAllRoundsByGameID() {
        //make and add two rounds, each for the same game
        BullCowRoundObject round1 = new BullCowRoundObject();
        round1.setGameID(1);
        round1.setGuess("1234");
        round1.setRoundResults("e:0:p:0");
        round1.setTimeOfGuess(LocalDateTime.now());
        service.addRound(round1);
        
        BullCowRoundObject round2 = new BullCowRoundObject();
        round2.setGameID(1);
        round2.setGuess("1234");
        round2.setRoundResults("e:0:p:0");
        round2.setTimeOfGuess(LocalDateTime.now());
        service.addRound(round2);
        
        //make and add one round, for a different game than the first two rounds
        BullCowRoundObject round3 = new BullCowRoundObject();
        round3.setGameID(2);
        round3.setGuess("1234");
        round3.setRoundResults("e:0:p:0");
        round3.setTimeOfGuess(LocalDateTime.now());
        service.addRound(round3);
        
        //call getAllRounds method
        List<BullCowRoundObject> listGame1 = service.getAllRoundsByGameID(1);
        List<BullCowRoundObject> listGame2 = service.getAllRoundsByGameID(2);
        
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

    @Test
    public void testUpdateGame() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setGameID(1);
        newGame.setAnswer("1234");
        service.addGame(newGame);
        
        //retrive game
        newGame = service.getGameById(newGame.getGameID(), false);
        
        //call update method
        BullCowGameObject updatedGame = service.updateGame(newGame);
        
        //verify that the status of the updated game and game pulled from the DAO are not equal
        assertNotEquals(newGame.getStatus(), updatedGame.getStatus());
    }

    @Test
    public void testGetAllGames() {
        //add one game
        BullCowGameObject game1 = new BullCowGameObject();
        game1.setAnswer("1234");
        service.addGame(game1);
        
        //add second game
        BullCowGameObject game2 = new BullCowGameObject();
        game1.setAnswer("4321");
        service.addGame(game2);
        
        //call getall method
        List<BullCowGameObject> games = service.getAllGames();
        
        //assertions
        assertEquals(2, games.size());
        assertTrue(games.contains(game1));
        assertTrue(games.contains(game2));
    }

    @Test
    public void testGenerateNewAnswer() {
        String newAnswer = service.generateNewAnswer();
        assertEquals(4, newAnswer.length());
        assertNotEquals(newAnswer.substring(0, 1), newAnswer.substring(1, 2));
        assertNotEquals(newAnswer.substring(0, 1), newAnswer.substring(2, 3));
        assertNotEquals(newAnswer.substring(0, 1), newAnswer.substring(3, 4));
        assertNotEquals(newAnswer.substring(1, 2), newAnswer.substring(2, 3));
        assertNotEquals(newAnswer.substring(1, 2), newAnswer.substring(3, 4));
        assertNotEquals(newAnswer.substring(2, 3), newAnswer.substring(3, 4));
    }

    @Test
    public void testCalculateResults() {
        String testAnswer = "1234";
        
        String testGuess1 = "1234";
        String testResults1 = "e:4:p:0";
        assertEquals(testResults1, service.calculateResults(testAnswer, testGuess1));
        
        String testGuess2 = "5555";
        String testResults2 = "e:0:p:0";
        assertEquals(testResults2, service.calculateResults(testAnswer, testGuess2));
        
        String testGuess3 = "1255";
        String testResults3 = "e:2:p:0";
        assertEquals(testResults3, service.calculateResults(testAnswer, testGuess3));
        
        String testGuess4 = "5512";
        String testResults4 = "e:0:p:2";
        assertEquals(testResults4, service.calculateResults(testAnswer, testGuess4));
    }


    @Test
    public void testVerifyGameID() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setGameID(1);
        newGame.setAnswer("1234");
        service.addGame(newGame);
        
        //retrive that game and verify that its gameID is 1
        BullCowGameObject fromDao = service.getGameById(newGame.getGameID(), false);
        assertEquals(newGame.getGameID(), fromDao.getGameID());
        
        //check that verify returns true/false appropriately
        int testID = 50;
        assertFalse(service.verifyGameID(testID));
        assertTrue(service.verifyGameID(newGame.getGameID()));        
    }
   
}
