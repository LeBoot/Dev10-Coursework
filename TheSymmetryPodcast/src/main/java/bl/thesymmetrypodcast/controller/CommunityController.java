/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.thesymmetrypodcast.controller;

import bl.thesymmetrypodcast.entity.Region;
import bl.thesymmetrypodcast.service.RegionServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Boone
 */
@Controller
@RequestMapping("/community")
public class CommunityController {
    
    @Autowired
    RegionServiceImpl regionService;
    
    //Return a list of all the regions -----------------------------------------
    @GetMapping("/regions")
    public ResponseEntity<List<Region>> getAllRegions() {
        List<Region> allRegions = regionService.getAllRegions();
        if (allRegions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(allRegions, HttpStatus.ACCEPTED);
        }
    }
        
}
