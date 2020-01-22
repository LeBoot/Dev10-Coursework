/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcows.controllers;

import bl.bullsandcows.models.BullCowGameObject;
import bl.bullsandcows.models.BullCowRoundObject;
import bl.bullsandcows.models.GuessObject;
import bl.bullsandcows.service.BullCowService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Boone
 */
@RestController
@RequestMapping("/api/BullCow")
public class BullCowController {
    


    //CONSTRUCTOR --------------------------------------------------------------
    //Can take BullCow (impl) as a dependency because that class was marked with "@Repository"
    @Autowired
    BullCowService service;
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public String beginNewGame() {
        //retrieve a new answer, generated from the service layer
        String newAnswer = service.generateNewAnswer();
        //create a new game object
        BullCowGameObject newGame = new BullCowGameObject();
        //set the answer of that game object
        newGame.setAnswer(newAnswer);
        //call service/dao method to add game to database, which automatically
            //sets ID and default status
        BullCowGameObject returnedGame = service.addGame(newGame);
        //return the ID of the game
        return "Your new game's gameID is '" + returnedGame.getGameID() + "'.";       
    }
    
    
    @PostMapping("/guess")
    public ResponseEntity<BullCowRoundObject> makeAGuess(@RequestBody GuessObject guessObject) {
        
            //retrieve game based on ID
            int gameID = guessObject.getGameID();
            BullCowGameObject game = service.getGameById(gameID, false);
            //retrieve the answer from that game
            String answer = game.getAnswer();
            //compare the answer and guess, and retrieve results
            String guess = guessObject.getGuess();
            String results = service.calculateResults(answer, guess);
            System.out.println(results);

            //if game is won...
            if (results.equalsIgnoreCase("e:4:p:0")) {
                service.updateGame(game);
            }

            //generate new round object
            BullCowRoundObject round = new BullCowRoundObject();
            //add info to that round object
            round.setTimeOfGuess(LocalDateTime.now().withNano(0));
            round.setRoundResults(results);
            round.setGuess(guess);
            round.setGameID(gameID);
            //add round to DB and return to user
            BullCowRoundObject returnedRound = service.addRound(round);
            return new ResponseEntity(returnedRound, HttpStatus.OK);       
    }
    
    @GetMapping("/getAllGames")
    public List<BullCowGameObject> getAllGames() {
          return service.getAllGames();
    }
    
    @GetMapping("/getGame/{gameID}")
    public ResponseEntity<BullCowGameObject> getGameByID(@PathVariable int gameID) {
        //check if submitted ID is in the list of games; if yes, boolean = true
        boolean isGameIDValid = service.verifyGameID(gameID);
        if (isGameIDValid) {
            BullCowGameObject returnedObject = service.getGameById(gameID, true);
            return new ResponseEntity(returnedObject, HttpStatus.FOUND);
        } else {
            return new ResponseEntity("The gameID that you entered could not be located.", HttpStatus.NOT_FOUND);
        }        
    }

    @GetMapping("/getRounds/{gameID}")
    public ResponseEntity<List<BullCowRoundObject>> getAllRounds(@PathVariable int gameID) {
        //check if submitted ID is in the list of games; if yes, boolean = true
        boolean isGameIDValid = service.verifyGameID(gameID);
        if (isGameIDValid) {
            List<BullCowRoundObject> returnedList = service.getAllRoundsByGameID(gameID);
            return new ResponseEntity(returnedList, HttpStatus.FOUND);
        } else {
            return new ResponseEntity("The gameID that you entered could not be located.", HttpStatus.NOT_FOUND);
        }   
    }
    
}
