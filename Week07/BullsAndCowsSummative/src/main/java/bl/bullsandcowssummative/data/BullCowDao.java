/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcowssummative.data;

import bl.bullsandcowssummative.models.BullCowGameObject;
import bl.bullsandcowssummative.models.BullCowRoundObject;
import java.util.List;

/**
 *
 * @author Boone
 */
public interface BullCowDao {
    
    //CRUD for gameObjects -----------------------------------------------------
    BullCowGameObject addGame(BullCowGameObject game);
    List<BullCowGameObject> getAllGames();
    BullCowGameObject getGameById(int gameID);
    BullCowGameObject updateGame(BullCowGameObject game);
    
    //CRUD for roundObjects ----------------------------------------------------
    BullCowRoundObject addRound(BullCowRoundObject round);
    List<BullCowRoundObject> getAllRoundsByGameID(int gameID);
    
    //CRUD for unit testing ----------------------------------------------------
    void deleteGameById(int gameID);
    void deleteRoundByGameId(int gameID);
}
