/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.controller;

import bl.mp3project.controller.dao.mp3ProjectDao;
import bl.mp3project.controller.dao.mp3ProjectDaoException;
import bl.mp3project.dto.MP3File;
import bl.mp3project.ui.mp3ProjectView;
import java.util.List;

/**
 *
 * @author Boone
 */
public class mp3ProjectController {
    
    //attributes and constructor
    mp3ProjectDao dao;
    mp3ProjectView view;
    public mp3ProjectController(mp3ProjectDao dao, mp3ProjectView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addMP3();
                        break;
                    case 2:
                        removeMP3();
                        break;
                    case 3:
                        editAFile();
                        break;
                    case 4:
                        listAllMP3s();
                        break;
                    case 5:
                        displayDetails();
                        break;
                    case 6:
                        searchForFile();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (mp3ProjectDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void exitMessage() {
       view.displayExitBanner();
    }
    
    private void unknownCommand() {
       view.displayUnknownCommmand();
   }
    
    private void addMP3() throws mp3ProjectDaoException { //switch case 1
        view.displayCommenceBanner("Add MP3 file");
        MP3File newFile = view.getInfoForNewFile();
        dao.addMP3File(newFile.getTitle(), newFile);
        view.displayConcludedBanner("Add MP3 file");
    }
    
    private void removeMP3() throws mp3ProjectDaoException { //switch case 2
        view.displayCommenceBanner("Remove MP3 file");
        String fileToRemove = view.getChoiceForTitle();
        dao.removeMP3File(fileToRemove);
        view.displayConcludedBanner("Remove MP3 file");
    }
      
    //switch case 3 is farther down 
    
    private void listAllMP3s() throws mp3ProjectDaoException { //switch case 4
        view.displayCommenceBanner("List all MP3 files");
        List<MP3File> mp3List = dao.getAllMP3Files();
        view.displayAllFiles(mp3List);
        view.displayConcludedBanner("List all MP3 files");
    }
    
    private void displayDetails() throws mp3ProjectDaoException { //switch case 5
        view.displayCommenceBanner("Display details of MP3 file");
        String fileToDisplay = view.getChoiceForTitle();
        MP3File mp3ToShow = dao.getMP3File(fileToDisplay);
        view.displayFileDetails(mp3ToShow);
        view.displayConcludedBanner("Display details of MP3 file");
    }
    
    private void searchForFile() throws mp3ProjectDaoException { //switch case 6
        view.displayCommenceBanner("Search for MP3 file");
        String titleToSearch = view.getChoiceForTitle();
        MP3File mp3ToSearch = dao.getMP3File(titleToSearch);
        view.displaySearchForFile(mp3ToSearch);
        view.displayConcludedBanner("Search for MP3 file");
    }
    
    private void editAFile() throws mp3ProjectDaoException { //switch case 3
        view.displayCommenceBanner("Edit MP3 file");
        String titleToSearch = view.getChoiceForTitle();
        
        //remove from text file before editing
        MP3File fileToEdit = dao.removeMP3File(titleToSearch);
        
        boolean isStillEditing = true;
        int userSelection;
        while (isStillEditing) {
            userSelection = view.printMenuForEditing();
            switch (userSelection) {
                case 1: //edit release date
                    String editedReleaseDate = view.newInfo("release date");
                    fileToEdit.setReleaseDate(editedReleaseDate);
                    break;
                case 2: //edit album
                    String editedAlbum = view.newInfo("album");
                    fileToEdit.setAlbum(editedAlbum);
                    break;
                case 3: //edit genre
                    String editedGenre = view.newInfo("genre");
                    fileToEdit.setGenre(editedGenre);
                    break;
                case 4: //edit comment
                    String editedComment = view.newInfo("comment(s)");
                    fileToEdit.setComment(editedComment);
                    break;
                case 5: //done editing
                    isStillEditing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        
        //add edited MP3File back to text file
        dao.addMP3File(titleToSearch, fileToEdit);
        
        view.displayConcludedBanner("Edit MP3 file");
    }

}