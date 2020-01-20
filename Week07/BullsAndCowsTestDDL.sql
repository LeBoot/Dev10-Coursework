-- Destroys existing database, if exists; this way, start from scratch each time.
DROP DATABASE IF EXISTS bullsAndCowsTestDB;

-- Create database.
CREATE DATABASE bullsAndCowsTestDB;

-- Ensure that the schema is using the correct database.
USE bullsAndCowsTestDB;

-- Create table for Games.
CREATE TABLE games(
	GameID INT PRIMARY KEY AUTO_INCREMENT,
    Answer VARCHAR(4) NOT NULL,
    GameStatus VARCHAR(12) DEFAULT "In Progress" NOT NULL 
);

-- Create table for allRounds.
CREATE TABLE allRounds(
	RoundID INT PRIMARY KEY AUTO_INCREMENT,
    TimeOfGuess DATETIME NOT NULL,
    RoundResults VARCHAR(8) NOT NULL,
    Guess VARCHAR(4) NOT NULL,
    GameID INT,
	FOREIGN KEY fk_allRounds_gameID (GameID)
		REFERENCES games (GameID)
);