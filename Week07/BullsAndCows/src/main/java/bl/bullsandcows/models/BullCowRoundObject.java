/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcows.models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Boone
 */
public class BullCowRoundObject {
    
    private int roundID;
    private LocalDateTime timeOfGuess;
    private String roundResults;
    private String guess;
    private int gameID;

    public int getRoundID() {
        return roundID;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public LocalDateTime getTimeOfGuess() {
        return timeOfGuess;
    }

    public void setTimeOfGuess(LocalDateTime timeOfGuess) {
        this.timeOfGuess = timeOfGuess;
    }

    public String getRoundResults() {
        return roundResults;
    }

    public void setRoundResults(String roundResults) {
        this.roundResults = roundResults;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.roundID;
        hash = 53 * hash + Objects.hashCode(this.timeOfGuess);
        hash = 53 * hash + Objects.hashCode(this.roundResults);
        hash = 53 * hash + Objects.hashCode(this.guess);
        hash = 53 * hash + this.gameID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BullCowRoundObject other = (BullCowRoundObject) obj;
        if (this.roundID != other.roundID) {
            return false;
        }
        if (this.gameID != other.gameID) {
            return false;
        }
        if (!Objects.equals(this.roundResults, other.roundResults)) {
            return false;
        }
        if (!Objects.equals(this.guess, other.guess)) {
            return false;
        }
        if (!Objects.equals(this.timeOfGuess, other.timeOfGuess)) {
            return false;
        }
        return true;
    }

    
    
    
    
}