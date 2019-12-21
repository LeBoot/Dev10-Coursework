/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.controller.dao;

import bl.mp3project.dto.MP3File;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Boone
 */
public interface mp3ProjectDao {
    
    MP3File addMP3File(String title, MP3File mp3file) throws mp3ProjectDaoException;
    
    MP3File removeMP3File(String title) throws mp3ProjectDaoException;
    
    List<MP3File> getAllMP3Files() throws mp3ProjectDaoException;
    
    MP3File getMP3File(String title) throws mp3ProjectDaoException;
    
    Map<String, List<MP3File>> getMP3FilesInAGenre() throws mp3ProjectDaoException;
    
    Map<String, List<MP3File>> getMP3FilesInAnAlbum() throws mp3ProjectDaoException;
    
    Map<String, List<MP3File>> getMP3FilesByAnArtist() throws mp3ProjectDaoException;
    
    double getAverageMP3Age() throws mp3ProjectDaoException;
    
    List<MP3File> getOldestMP3File() throws mp3ProjectDaoException;
    
    List<MP3File> getNewestMP3File() throws mp3ProjectDaoException;
    
    List<MP3File> getFilesOlderThan(long ageInYears) throws mp3ProjectDaoException;
    
    List<MP3File> filterByAlbum(String albumToFind) throws mp3ProjectDaoException;
    
}