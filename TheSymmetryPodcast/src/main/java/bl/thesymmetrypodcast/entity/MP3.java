/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.thesymmetrypodcast.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Boone
 */
@Entity
@Table(name = "mp3tbl")
@Data
public class MP3 {
    
    @Id
    private String episodelink;
    
    @Column(name = "episodetitle")
    private String episodeTitle;
    
    @Column(name = "episodedate")
    private LocalDate episodeDate;
    
    @Column(name = "episodedescription")
    private String episodeDescription;
}