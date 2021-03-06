/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInventory.dto;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Boone
 */
public class Server {
    private String name;
    private String ip;
    private String manufacturer;
    private int ram;
    private int numProcessors;
    private LocalDate purchaseDate;

    //constructor
    public Server(String name) {
        this.name = name;
    }

    //make method for getting age of server
    public long getServerAge() {
        Period p = purchaseDate.until(LocalDate.now());
        return p.getYears();        
    }
    
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getNumProcessors() {
        return numProcessors;
    }

    public void setNumProcessors(int numProcessors) {
        this.numProcessors = numProcessors;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
}
