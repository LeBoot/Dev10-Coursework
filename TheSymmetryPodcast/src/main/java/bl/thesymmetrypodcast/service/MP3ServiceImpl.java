/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.thesymmetrypodcast.service;

import bl.thesymmetrypodcast.repository.MP3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Boone
 */
@Service
public class MP3ServiceImpl implements MP3Service {
    
    @Autowired
    MP3Repository mp3repo;
}
