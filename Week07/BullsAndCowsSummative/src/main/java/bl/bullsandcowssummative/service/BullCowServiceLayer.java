/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcowssummative.service;

import bl.bullsandcowssummative.data.BullCowDao;
import bl.bullsandcowssummative.models.BullCowGameObject;
import bl.bullsandcowssummative.models.BullCowRoundObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Boone
 */
@Component
public class BullCowServiceLayer implements BullCowService {
    
    private final BullCowDao dao;

    //CONSTRUCTOR --------------------------------------------------------------
    //Can take BullCow (impl) as a dependency because that class was marked with "@Repository"
    @Autowired
    public BullCowServiceLayer(BullCowDao dao) {
        this.dao = dao;
    }
    
    /*
    Pass through methods to DAO ------------------------------------------------
    ----------------------------------------------------------------------------
    */
    
    @Override
    public BullCowGameObject addGame(BullCowGameObject game) {
        return dao.addGame(game);
    }
    
    @Override
    public BullCowRoundObject addRound(BullCowRoundObject round) {
        return dao.addRound(round);
    }
    
    @Override
    public List<BullCowRoundObject> getAllRoundsByGameID(int gameID) {
        return dao.getAllRoundsByGameID(gameID);
    }
    
    @Override
    public BullCowGameObject updateGame(BullCowGameObject game) {
        return dao.updateGame(game);
    }
    
    
    /*
    DAO methods with modifications ---------------------------------------------
    ----------------------------------------------------------------------------
    */
    
    @Override
    public List<BullCowGameObject> getAllGames() {
        List<BullCowGameObject> listOfGames = dao.getAllGames();
        for (BullCowGameObject game : listOfGames) {
            this.hideAnswer(game);
        }
        return listOfGames;
    }
    
    @Override
    public BullCowGameObject getGameById(int gameID, boolean wantToHide) {
        BullCowGameObject game = dao.getGameById(gameID);
        if (wantToHide == true) {
            return this.hideAnswer(game);
        } else {
            return game;
        }
        
    }
    
    
    /*
    Helper methods -------------------------------------------------------------
    ----------------------------------------------------------------------------
    */
    
    private BullCowGameObject hideAnswer(BullCowGameObject game) {
        if (game.getStatus().equalsIgnoreCase("In Progress")) {
                game.setAnswer("ANSWER IS HIDDEN");
            }
        return game;
    }
    
    /*
    Other methods --------------------------------------------------------------
    ----------------------------------------------------------------------------
    */
    
    @Override
    public String generateNewAnswer() {
        Integer[] nums0through9Array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> nums0through9List = Arrays.asList(nums0through9Array);
        Collections.shuffle(nums0through9List);
        nums0through9List.toArray(nums0through9Array);
        String newAnswer = nums0through9Array[0] + ""
                + nums0through9Array[1] + "" 
                + nums0through9Array[2] + ""
                + nums0through9Array[3] + "";
        return newAnswer;
    }
    
    @Override
    public String calculateResults(String answer, String guess) {
        int numExact = 0;
        int numPartial = 0;
        
        //break apart answer
        String[] dissectedAnswer = new String[4];
        dissectedAnswer[0] = answer.substring(0, 1);
        dissectedAnswer[1] = answer.substring(1, 2);
        dissectedAnswer[2] = answer.substring(2, 3);
        dissectedAnswer[3] = answer.substring(3, 4);
        
        //break apart guess
        String[] dissectedGuess = new String[4];
        dissectedGuess[0] = guess.substring(0, 1);
        dissectedGuess[1] = guess.substring(1, 2);
        dissectedGuess[2] = guess.substring(2, 3);
        dissectedGuess[3] = guess.substring(3, 4);
        
        //calculate exact matches
        for (int i = 0; i < 4; i++) {
            if (dissectedGuess[i].equalsIgnoreCase(dissectedAnswer[i])) {
                numExact++;
            }
        }
        
        //calculate partial matches
        if ((dissectedGuess[0].equalsIgnoreCase(dissectedAnswer[1])) ||
                (dissectedGuess[0].equalsIgnoreCase(dissectedAnswer[2])) ||
                (dissectedGuess[0].equalsIgnoreCase(dissectedAnswer[3]))) {
            numPartial++;
        }
        if ((dissectedGuess[1].equalsIgnoreCase(dissectedAnswer[0])) ||
                (dissectedGuess[1].equalsIgnoreCase(dissectedAnswer[2])) ||
                (dissectedGuess[1].equalsIgnoreCase(dissectedAnswer[3]))) {
            numPartial++;
        }
        if ((dissectedGuess[2].equalsIgnoreCase(dissectedAnswer[0])) ||
                (dissectedGuess[2].equalsIgnoreCase(dissectedAnswer[1])) ||
                (dissectedGuess[2].equalsIgnoreCase(dissectedAnswer[3]))) {
            numPartial++;
        }
        if ((dissectedGuess[3].equalsIgnoreCase(dissectedAnswer[0])) ||
                (dissectedGuess[3].equalsIgnoreCase(dissectedAnswer[1])) ||
                (dissectedGuess[3].equalsIgnoreCase(dissectedAnswer[2]))) {
            numPartial++;
        }
        
        //return results
        String results = "e:" + numExact + ":p:" + numPartial;
        return results;
  
    }
    
    @Override
    public boolean verifyGameID(int gameID) {
        List<BullCowGameObject> ListOfAllGames = this.getAllGames();
        
        boolean isGameInList = false;
        for (BullCowGameObject game : ListOfAllGames) {
            if (game.getGameID() == gameID) {
                isGameInList = true;
            }
        }
        
        return isGameInList;
    }
    
}

