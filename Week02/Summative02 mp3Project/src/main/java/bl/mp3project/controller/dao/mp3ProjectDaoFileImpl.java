/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.controller.dao;

import bl.mp3project.dto.MP3File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Boone
 */
public class mp3ProjectDaoFileImpl implements mp3ProjectDao {

    private Map<String, MP3File> mp3filesMap = new HashMap<>();
    
    @Override
    public MP3File addMP3File(String title, MP3File mp3file) throws mp3ProjectDaoException {
        loadMP3();
        MP3File newfile = mp3filesMap.put(title, mp3file);
        try {
            writeTextFile();
        } catch (IOException ex) {
            Logger.getLogger(mp3ProjectDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newfile;
    }

    @Override
    public MP3File removeMP3File(String title) throws mp3ProjectDaoException {
        loadMP3();
        MP3File removedfile = mp3filesMap.remove(title);
        try {
            writeTextFile();
        } catch (IOException ex) {
            Logger.getLogger(mp3ProjectDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return removedfile;
    }

    @Override
    public List<MP3File> getAllMP3Files() throws mp3ProjectDaoException {
        loadMP3();
        return new ArrayList<MP3File>(mp3filesMap.values());
    }

    @Override
    public MP3File getMP3File(String title) throws mp3ProjectDaoException {
        loadMP3();
        return mp3filesMap.get(title);
    }
    
    @Override
    public Map<String, List<MP3File>> getMP3FilesInAGenre() throws mp3ProjectDaoException {
        loadMP3();
        return mp3filesMap.values()
                .stream()
                .collect(Collectors.groupingBy(MP3File :: getGenre));
    }
    
    @Override
    public Map<String, List<MP3File>> getMP3FilesInAnAlbum() throws mp3ProjectDaoException {
        loadMP3();
        return mp3filesMap.values()
                .stream()
                .collect(Collectors.groupingBy(MP3File :: getAlbum));
    }
    
    @Override
    public Map<String, List<MP3File>> getMP3FilesByAnArtist() throws mp3ProjectDaoException {
        loadMP3();
        return mp3filesMap.values()
                .stream()
                .collect(Collectors.groupingBy(MP3File :: getArtist));
    }
    
    @Override
    public double getAverageMP3Age() throws mp3ProjectDaoException {
        loadMP3();
        return mp3filesMap.values()
                .stream()
                .mapToLong(MP3File :: getMP3Age)
                .average()
                .getAsDouble();
    }
    
    @Override
    public List<MP3File> getOldestMP3File() throws mp3ProjectDaoException {
        loadMP3();
        long oldestAge = mp3filesMap.values()
                .stream()
                .mapToLong(MP3File :: getMP3Age)
                .max()
                .getAsLong();
        return mp3filesMap.values()
               .stream()
               .filter(f -> f.getMP3Age() == oldestAge)
               .collect(Collectors.toList());
    }
    
    @Override
    public List<MP3File> getNewestMP3File() throws mp3ProjectDaoException {
        loadMP3();
        long youngestAge = mp3filesMap.values()
                .stream()
                .mapToLong(MP3File :: getMP3Age)
                .min()
                .getAsLong();
        return mp3filesMap.values()
               .stream()
               .filter(f -> f.getMP3Age() == youngestAge)
               .collect(Collectors.toList());
    }
    
     
    @Override
    public List<MP3File> getFilesOlderThan(long ageInYears) throws mp3ProjectDaoException {
        return mp3filesMap.values()
                .stream()
                .filter(f -> f.getMP3Age() < ageInYears)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<MP3File> filterByAlbum(String albumToFind) throws mp3ProjectDaoException {
        return mp3filesMap.values()
                .stream()
                .filter(f -> f.getAlbum().equalsIgnoreCase(albumToFind))
                .collect(Collectors.toList());
    }
    
    
//    
//    
//    
//        For File Persistance
//                
//         Format= title::releaseDate::album::genre::artist::comment   
//                
                
    
    //declare constants          
    public static final String DELIMITER = "::";
    public static String textFile = "mp3TextFile.txt";
    

    //method to format the text string that will be retrieved when the text file is unmarshalled
    private MP3File unmarshalTextFile(String mp3AsText) {
        
        //create an array of items that have been split at the delimitier
        String[] mp3Tokens = mp3AsText.split(DELIMITER);
        
        //retrieve "title" from index 0 of the newly-created array
        String title = mp3Tokens[0];
        
        //Create a new MP3File object based on the just-retrieved title
        MP3File mp3FromTextFile = new MP3File(title);
                
        //complete the new MP3File with the appropriate setters
        mp3FromTextFile.setReleaseDate(LocalDate.parse(mp3Tokens[1]));
        mp3FromTextFile.setAlbum(mp3Tokens[2]);
        mp3FromTextFile.setGenre(mp3Tokens[3]);
        mp3FromTextFile.setArtist(mp3Tokens[4]);
        mp3FromTextFile.setComment(mp3Tokens[5]);

        //return the new MP3File
        return mp3FromTextFile;
    }
    
    
    
    //method to read text from text file, incorporates unmarshall method above
    private void loadMP3() throws mp3ProjectDaoException {
        Scanner scanner;
        
        try {
            //Scanner to read the file
            scanner = new Scanner (
                new BufferedReader(
                    new FileReader(textFile)));
        } catch (FileNotFoundException e) {
            throw new mp3ProjectDaoException ("Could not load from text file into memory", e);
        }
        
        String currentLine; //to hold most-recently read line from file
        MP3File currentMP3; //to hold most-recenlty unmarshalled MP3File
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentMP3 = unmarshalTextFile(currentLine); //call method above, to convert line of text file into MP3File
            mp3filesMap.put(currentMP3.getTitle(), currentMP3); //add to Map
        }
        
        scanner.close(); //to prevent memory leaks
    }

    
    
    //convert an MP3File object into a properly-formatted string with delimiters
    private String marshalTextFile(MP3File someMP3) {
        //Format= title::releaseDate::album::genre::comment 
        
        //Place all components of address object into a giant string (in proper format)
        String mp3AsText = someMP3.getTitle() + DELIMITER;
        mp3AsText += someMP3.getReleaseDate().toString() + DELIMITER;
        mp3AsText += someMP3.getAlbum() + DELIMITER;
        mp3AsText += someMP3.getGenre() + DELIMITER;
        mp3AsText += someMP3.getArtist() + DELIMITER;
        mp3AsText += someMP3.getComment(); //no delimiter on last bit of information
        
       //return MP3File as text
       return mp3AsText;
    }
    
    
    
    //method to write text-string (created in method above) to text file
    private void writeTextFile() throws mp3ProjectDaoException, IOException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(textFile));
        } catch (IOException e) {
            throw new mp3ProjectDaoException("Could not save data", e);
        }
        
        String mp3AsText;
        
        //previously-established method for iterating over the collection and returning an arrayList of the values
        List<MP3File> mp3List = this.getAllMP3Files();
        
        for (MP3File currentMP3 : mp3List) {
            mp3AsText = marshalTextFile(currentMP3); //turn MP3File into string using method above
            out.println(mp3AsText); //write that line to the text file
            out.flush(); //force-print anything un-printed
        }
        
        out.close(); //to prevent memory leaks
        
    }
    
}