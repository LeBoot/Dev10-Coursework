/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.dto;

/**
 *
 * @author Boone
 */
public class MP3File {
    private String title;
    private String releaseDate;
    private String album;
    private String genre;
    private String comment;
    
    //constructor, for just title
    public MP3File(String title) {
        this.title = title;
    }
    
    //getter for title
    public String getTitle() {
        return title;
    }
    
    //getters and setters for others
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
