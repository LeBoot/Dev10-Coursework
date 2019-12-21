/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.ui;

import bl.mp3project.dto.MP3File;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Boone
 */
public class mp3ProjectView {
    
    //attribute and constructor
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
        io.print("7. List files by album");
        io.print("8. List files by genre");
        io.print("9. Get average file age");
        io.print("10. Get the oldest file(s)");
        io.print("11. Get the newest file(s)");
        io.print("12. List files older than a certain year");
        io.print("13. Search for an album");
        io.print("14. List files by artist");
        io.print("15. Exit");
	
        return io.readInt("Please select from the above choices.", 1, 15);
    }
    
    public int printMenuForEditing() {
        io.print("== Edit Menu ==");
        io.print("1. Edit release date");
        io.print("2. Edit album");
        io.print("3. Edit genre");
        io.print("4. Edit comment");
        io.print("5. Edit artist.");
        io.print("6. Done editing");

        return io.readInt("Please select from the above choices.", 1, 6);
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
        boolean isTitleGood = true;
        String title;
        do {
            title = io.readString("What is the mp3 title? ");
            if ((title == null) || (title.equals(""))) {
                isTitleGood = false;
            } else {
              isTitleGood = true;
            }
        } while (isTitleGood == false);
        LocalDate relDate = askForDate();
        String album = io.readString("What is the album? ");
        String artist = io.readString("What is the artist? ");
        String genre = io.readString("What is the genre? ");
        String comment = io.readString("Add comments: ");
	        
        //create new MP3File object via DAO implement method
        MP3File newMP3 = new MP3File(title);
	        
        //set parameters for the new MP3File
        newMP3.setReleaseDate(relDate);
        newMP3.setArtist(artist);
        newMP3.setAlbum(album);
        newMP3.setGenre(genre);
        if ((comment == null) || (comment.equals(""))) {
            newMP3.setComment("No Comments");
        } else {
            newMP3.setComment(comment);
        }
	        
        //return the new MP3File
        return newMP3;
    }
    
    public void displayAllFiles(List<MP3File> mp3List) {
        for (MP3File currentFile: mp3List) {
            io.print("Title: " + currentFile.getTitle());
            io.print("Artist: " + currentFile.getArtist());
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
            io.print("Artist: " + currentFile.getArtist());
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
    
    public void noTitle() {
        io.print("There is no mp3 with that title");
        io.print("");
    }
        
    public LocalDate askForDate() {
        LocalDate releaseDate = LocalDate.now();
        boolean isDateValid; //this type of validation really belongs in a service package
        do {
            try {
                String releaseDateStr = io.readString("What is the release date? (format 'yyyy-MM-dd'): ");
                releaseDate = LocalDate.parse(releaseDateStr);
                isDateValid = true;
            } catch (DateTimeParseException e) {
                isDateValid = false;
                System.out.println("That date was no good.  Be sure to follow the format exaclty.");
                System.out.println("");
            }
        } while (!isDateValid);
        return releaseDate;
    } 
    
    public void displayAverageAge(double age) {
        io.print("The average age of all the MP3s (by year) is " + age);
    }
    
    public void displayAllMP3sByGenre(Map<String, List<MP3File>> mapOfGenres) {
        Set<String> allGenres = mapOfGenres.keySet();
        allGenres.stream()
                .forEach(genre -> {
                    io.print("");
                    io.print("=========");
                    io.print("Genre: " + genre);
                    mapOfGenres.get(genre).stream()
                            .forEach(t -> io.print(t.getTitle()));         
                });
    }
    
    
    
    //Still working on making this one work; then, it will replace the above method
    public void displayAllMP3sByGenre2(Map<String, List<MP3File>> mapOfGenres) {
        Set<String> allGenres = mapOfGenres.keySet();
        allGenres.stream()
                .forEach(genre -> {
                    io.print("");
                    io.print("=========");
                    io.print("Genre: " + genre);
                    mapOfGenres.get(genre)
                            .stream()
                            .forEach(a -> {
                                Map<String, List<MP3File>> newMap = new HashMap<>();
                                io.print("Artist: " + a.getArtist());
                                List<MP3File> artistList = new ArrayList<>();
                                artistList.add(a);
                                newMap.put(a.getArtist(), artistList);
                                        newMap.get(a.getArtist())
                                                .stream()
                                                .forEach(song -> io.print("Song: " + song.getTitle()));
                                        
                                                                        
                                
                            });
                });
    }
    
    public void displayAllMP3sByAlbum(Map<String, List<MP3File>> mapOfFiles) {
        Set<String> allAlbums = mapOfFiles.keySet();
        allAlbums.stream()
                .forEach(album -> {
                    io.print("");
                    io.print("=========");
                    io.print("Album: " + album);
                    mapOfFiles.get(album).stream()
                            .forEach(t -> io.print(t.getTitle()));         
                });
    }
    
    public void displayMP3(List<MP3File> listOfFiles, String prompt) {
        io.print("The " + prompt + " mp3 file(s): ");
        displayAllFiles(listOfFiles);
    } 
    
    public long askForYears() {
        return io.readLong("How many years back do you want to go? ", 0, 100);
    }
    
    public String askForAlbum() {
        return io.readString("What album are you searching for?");
    }
    
    public void displayAllMP3sByArtist(Map<String, List<MP3File>> mapOfFiles) {
        Set<String> allArtists = mapOfFiles.keySet();
        allArtists.stream()
                .forEach(artist -> {
                    io.print("");
                    io.print("=========");
                    io.print("Artist: " + artist);
                    mapOfFiles.get(artist).stream()
                            .forEach(t -> io.print(t.getTitle()));         
                });
    }
}