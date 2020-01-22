/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcows.service;

import bl.bullsandcows.data.BullCowDao;
import bl.bullsandcows.models.BullCowGameObject;
import bl.bullsandcows.models.BullCowRoundObject;
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
    
  

    //CONSTRUCTOR --------------------------------------------------------------
    //Can take BullCow (impl) as a dependency because that class was marked with "@Repository"
    @Autowired
    BullCowDao dao;
    
    
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
        
        for (int i = 0; i < 4; i++) {
            //calculate exact matches
            if (guess.charAt(i) == answer.charAt(i)) {
                numExact++;
            }
            //calculate partial matches
            else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                numPartial++;
            }
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
