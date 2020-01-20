/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcowssummative.service;

import bl.bullsandcowssummative.models.BullCowGameObject;
import bl.bullsandcowssummative.models.BullCowRoundObject;
import java.util.List;

/**
 *
 * @author Boone
 */
public interface BullCowService {
    
    //Pass through methods to DAO
    public BullCowGameObject addGame(BullCowGameObject game);
    public BullCowRoundObject addRound(BullCowRoundObject round);
    public List<BullCowRoundObject> getAllRoundsByGameID(int gameID);
    public BullCowGameObject updateGame(BullCowGameObject game);
    
    //DAO methods with modifications
    public List<BullCowGameObject> getAllGames();
    public BullCowGameObject getGameById(int gameID, boolean wantToHide);
    
    //Other methods
    public String generateNewAnswer();
    public String calculateResults(String answer, String guess);
    public boolean verifyGameID(int gameID);
}
