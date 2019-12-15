/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.ui;

import bl.mp3project.dto.MP3File;
import java.util.List;

/**
 *
 * @author Boone
 */
public class mp3ProjectView {
    
    //parameter and constructor
    mp3ProjectUserIO io;
    public mp3ProjectView(mp3ProjectUserIO io) {
        this.io = io;
    }    
    
    public int printMenuAndGetSelection() {
	io.print("==== Main Menu ====");
	io.print("1. Add MP3 file");
	io.print("2. Remove MP3 file");
	io.print("3. Edit MP3 file");
	io.print("4. List all MP3 files");
	io.print("5. Display details of MP3 file");
        io.print("6. Search for MP3 file");
        io.print("7. Exit");
	
        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public int printMenuForEditing() {
        io.print("== Edit Menu ==");
        io.print("1. Edit release date");
        io.print("2. Edit album");
        io.print("3. Edit genre");
        io.print("4. Edit comment");
        io.print("5. Done editing");

        return io.readInt("Please select from the above choices.", 1, 5);
    }
    
    public String newInfo(String prompt) {
        String newInfo = io.readString("Please enter the new " + prompt + ": ");
        return newInfo;
    }
    
    public void displayExitBanner() {
        io.print("");
        io.print("Program terminated.  Goodbye!");
    }
    
    public MP3File getInfoForNewFile() {
	//ask for information
        String title = io.readString("What is the mp3 title? ");
        String releaseDate = io.readString("What is the release date? ");
        String album = io.readString("What is the album? ");
        String genre = io.readString("What is the genre? ");
        String comment = io.readString("Add comments: ");
	        
        //create new MP3File object via DAO implement method
        MP3File newMP3 = new MP3File(title);
	        
        //set parameters for the new MP3File
        newMP3.setReleaseDate(releaseDate);
        newMP3.setAlbum(album);
        newMP3.setGenre(genre);
        newMP3.setComment(comment);
	        
        //return the new MP3File
        return newMP3;
    }
    
    public void displayAllFiles(List<MP3File> mp3List) {
        for (MP3File currentFile: mp3List) {
            io.print("Title: " + currentFile.getTitle());
            io.print("Release date: " + currentFile.getReleaseDate());
            io.print("Album: " + currentFile.getAlbum());
            io.print("Genre: " + currentFile.getGenre());
            io.print("Comments: " + currentFile.getComment());
            io.print("");
        }
    }
    
    public void displayFileDetails(MP3File currentFile) {
        if (currentFile != null) {
            io.print("");
            io.print("Title: " + currentFile.getTitle());
            io.print("Release date: " + currentFile.getReleaseDate());
            io.print("Album: " + currentFile.getAlbum());
            io.print("Genre: " + currentFile.getGenre());
            io.print("Comments: " + currentFile.getComment());
            io.print("");
        } else {
            io.print("There is no MP3 file with that title");
        }
    }
    
    public void displaySearchForFile(MP3File currentFile) {
        if (currentFile != null) {
            io.print("The library contains an MP3 file with that title");
        } else {
            io.print("There is no MP3 file with that title");
        }
    }
    
    public String getChoiceForTitle() {
        String getChoiceForTitle = io.readString("What is the title of the MP3? ");
        return getChoiceForTitle;
    }
    
    public void displayCommenceBanner(String action) {
        io.print("");
        io.print("== " + action + " ==");
    }
    
    public void displayConcludedBanner(String action) {
        io.readString(action + " has been successfully achieved.  Hit enter to continue");
    }
    
    public void displayUnknownCommmand() {
        io.print("That command is not recognized.  Try again.");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}