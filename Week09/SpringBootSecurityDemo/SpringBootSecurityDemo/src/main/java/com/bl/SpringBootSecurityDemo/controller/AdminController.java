/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bl.SpringBootSecurityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Boone
 */
@Controller
public class AdminController {
    
    @GetMapping("/admin")
    public String displayAdminPage() {
        return "admin";
    }
}