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
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
                        listfilesbyAlbum();
                        break;
                    case 8:
                        listfilesbyGenre();
                        break;
                    case 9:
                        getAvgAge();
                        break;
                    case 10:
                        getOldest();
                        break;
                    case 11:
                        getNewest();
                        break;
                    case 12:
                        getSinceNYears();
                        break;
                    case 13:
                        searchForAlbum();
                        break;
                    case 14:
                        listfilesByArtist();
                        break;
                    case 15:
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
        String titleToSearch = view.getChoiceForTitle(); //return "bad value" if file is not found
        
        boolean isStillEditing = true;
        if (dao.getMP3File(titleToSearch) != null) {
            MP3File fileToEdit = dao.removeMP3File(titleToSearch);
        
            int userSelection;
            while (isStillEditing) {
                userSelection = view.printMenuForEditing();
                switch (userSelection) {
                    case 1: //edit release date
                        LocalDate editedReleaseDate = view.askForDate();
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
                        if ((editedComment == null) || editedComment.equals("")) {
                            fileToEdit.setComment("No Comments");
                        } else {
                            fileToEdit.setComment(editedComment);
                        }
                        break;
                    case 5: //edit artist
                        String editedArtist = view.newInfo("artist");
                        fileToEdit.setArtist(editedArtist);
                        break;
                    case 6: //done editing
                        isStillEditing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }

            //add edited MP3File back to text file
            dao.addMP3File(titleToSearch, fileToEdit);

            view.displayConcludedBanner("Edit MP3 file");
        } else {
            view.noTitle();
        }
    
    }
    
    private void listfilesbyAlbum() throws mp3ProjectDaoException { //switch case 7
        view.displayCommenceBanner("List MP3s by Album");
        Map<String, List<MP3File>> mapOfFiles = dao.getMP3FilesInAnAlbum();
        view.displayAllMP3sByAlbum(mapOfFiles);
        view.displayConcludedBanner("List MP3s by Album");
    }
    
    private void listfilesbyGenre() throws mp3ProjectDaoException { //switch case 8
        view.displayCommenceBanner("List MP3s by Genre");
        Map<String, List<MP3File>> mapOfFiles = dao.getMP3FilesInAGenre();
        view.displayAllMP3sByGenre(mapOfFiles);
        view.displayConcludedBanner("List MP3s by Genre");
    }
    
    private void getAvgAge() throws mp3ProjectDaoException { //switch case 9
        view.displayCommenceBanner("List average age of MP3");
        double avgAge = dao.getAverageMP3Age();
        view.displayAverageAge(avgAge);
        view.displayConcludedBanner("List average age of MP3");
    }
    
    private void getOldest() throws mp3ProjectDaoException { //switch case 10
        view.displayCommenceBanner("List oldest MP3(s)");
        List<MP3File> listOfFiles = dao.getOldestMP3File();
        view.displayMP3(listOfFiles, "oldest");
        view.displayConcludedBanner("List oldest MP3(s)");
    }
    
    private void getNewest() throws mp3ProjectDaoException { //switch case 11
        view.displayCommenceBanner("List newest MP3(s)");
        List<MP3File> listOfFiles = dao.getNewestMP3File();
        view.displayMP3(listOfFiles, "newest");
        view.displayConcludedBanner("List newest MP3(s)");
    }
    
    private void getSinceNYears() throws mp3ProjectDaoException { //switch case 12
        view.displayCommenceBanner("List MP3s newer than a certain year");
        long numOfYears = view.askForYears();
        List<MP3File> newList = dao.getFilesOlderThan(numOfYears);
        view.displayAllFiles(newList);
        view.displayConcludedBanner("List MP3s newer than a certain year");
    }
    
    private void searchForAlbum() throws mp3ProjectDaoException { //switch case 13
        view.displayCommenceBanner("Search for an album");
        String albumToFind = view.askForAlbum();
        List<MP3File> newList = dao.filterByAlbum(albumToFind);
        view.displayCommenceBanner(albumToFind);
        view.displayAllFiles(newList);
        view.displayConcludedBanner("Search for an album");
    }
    
    private void listfilesByArtist() throws mp3ProjectDaoException { //switch case 14
        view.displayCommenceBanner("List MP3s by artist");
        Map<String, List<MP3File>> mapOfFiles = dao.getMP3FilesByAnArtist();
        view.displayAllMP3sByArtist(mapOfFiles);
        view.displayConcludedBanner("List MP3s by artist");
    }
}