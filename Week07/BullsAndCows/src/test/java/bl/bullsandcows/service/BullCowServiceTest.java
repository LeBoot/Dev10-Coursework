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
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
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
        List<BullCowGameObject> games = dao.getAllGames();
        for (BullCowGameObject game : games) {
            dao.deleteRoundByGameId(game.getGameID());
            dao.deleteGameById(game.getGameID());
        } 
    }

    /*
    TESTS ----------------------------------------------------------------------
     */
    @Test
    public void testAddGameANDGetGameByID() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setAnswer("1234");
        newGame = service.addGame(newGame);

        //retrieve game
        BullCowGameObject gameFromDao = service.getGameById(newGame.getGameID(), false);

        //assert that game added and game retrieved are the same
        assertEquals(newGame, gameFromDao);
    }

    @Test
    public void testAddRoundANDGetAllRoundsByGameID() {
        //make and add two games
        BullCowGameObject game1 = new BullCowGameObject();
        game1.setAnswer("1234");
        game1 = service.addGame(game1);

        List<BullCowRoundObject> testGame1 = new ArrayList<>();

        BullCowGameObject game2 = new BullCowGameObject();
        game2.setAnswer("4321");
        game2 = service.addGame(game2);

        //make and add two rounds, each for the same game
        BullCowRoundObject round1 = new BullCowRoundObject();
        round1.setGameID(game1.getGameID());
        round1.setGuess("1234");
        round1.setRoundResults("e:0:p:0");
        round1.setTimeOfGuess(LocalDateTime.now().withNano(0));
        service.addRound(round1);
        testGame1.add(round1);

        BullCowRoundObject round2 = new BullCowRoundObject();
        round2.setGameID(game1.getGameID());
        round2.setGuess("1234");
        round2.setRoundResults("e:0:p:0");
        round2.setTimeOfGuess(LocalDateTime.now().withNano(0));
        service.addRound(round2);
        testGame1.add(round2);

        //make and add one round, for a different game than the first two rounds
        BullCowRoundObject round3 = new BullCowRoundObject();
        round3.setGameID(game2.getGameID());
        round3.setGuess("1234");
        round3.setRoundResults("e:0:p:0");
        round3.setTimeOfGuess(LocalDateTime.now().withNano(0));
        service.addRound(round3);

        //call getAllRounds method
        List<BullCowRoundObject> listGame1 = service.getAllRoundsByGameID(game1.getGameID());
        List<BullCowRoundObject> listGame2 = service.getAllRoundsByGameID(game2.getGameID());

        //assertions
        assertEquals(testGame1, listGame1);
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
        newGame.setAnswer("1234");
        newGame = service.addGame(newGame);

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
        game2.setAnswer("4321");
        service.addGame(game2);

        //call getall method
        List<BullCowGameObject> games = service.getAllGames();

        //assertion
        assertEquals(2, games.size());
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
        
        String testGuess5 = "4444";
        String testResults5 = "e:1:p:3";
        assertEquals(testResults5, service.calculateResults(testAnswer, testGuess5));
        
        String testGuess6 = "4445";
        String testResults6 = "e:0:p:3";
        assertEquals(testResults6, service.calculateResults(testAnswer, testGuess6));
        
        String testGuess7 = "4441";
        String testResults7 = "e:0:p:4";
        assertEquals(testResults7, service.calculateResults(testAnswer, testGuess7));
    }


    @Test
    public void testVerifyGameID() {
        //make and add a new game
        BullCowGameObject newGame = new BullCowGameObject();
        newGame.setAnswer("1234");
        newGame = service.addGame(newGame);
        
        //retrive that game and verify that its gameID is 1
        BullCowGameObject fromDao = service.getGameById(newGame.getGameID(), false);
        assertEquals(newGame.getGameID(), fromDao.getGameID());
        
        //check that verify returns true/false appropriately
        int testID = 50;
        assertFalse(service.verifyGameID(testID));
        assertTrue(service.verifyGameID(newGame.getGameID()));        
    }
   
}
