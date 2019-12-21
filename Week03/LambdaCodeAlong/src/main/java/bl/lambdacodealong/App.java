/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.lambdacodealong;

import ServerInventory.dao.ServerDao;
import ServerInventory.dao.ServerDaoInMemImpl;
import ServerInventory.dto.Server;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        
        //instantiate DAO
        ServerDao dao = new ServerDaoInMemImpl();
        
        //add some servers -----------------------------------------------------
        Server server1 = new Server("server1");
        server1.setIp("2");
        server1.setNumProcessors(2);
        server1.setPurchaseDate(LocalDate.now());
        server1.setRam(3);
        server1.setManufacturer("dell");
        dao.addServer(server1);
        
        Server server2 = new Server("server2");
        server2.setIp("2");
        server2.setNumProcessors(2);
        server2.setPurchaseDate(LocalDate.now());
        server2.setRam(3);
        server2.setManufacturer("HP");
        dao.addServer(server2);
        
        Server server3 = new Server("server3");
        server3.setIp("2");
        server3.setNumProcessors(2);
        server3.setPurchaseDate(LocalDate.now());
        server3.setRam(3);
        server3.setManufacturer("dell");
        dao.addServer(server3);
        
        // print some data -----------------------------------------------------
        List<Server> dells = dao.getServersByManufacturer("dell");
        
        //method not using lambdas
        for (Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }
        
        //blank space
        System.out.println("");
        System.out.println("");
        
        //method using lambdas
        dells.stream().forEach(s -> System.out.println(s.getName()));
        
        // print some data -----------------------------------------------------
        //create a map that has lists of servers by key: manufacturer
        Map<String, List<Server>> serverMap = dao.getAllServersGroupByManufacturer();
        
        //take the set of manufacturers (keys) above, and put them into a set
        Set<String> manufacturers = serverMap.keySet();
        
        //for each name of a manufacturer:
        manufacturers.stream()
                .forEach(name -> {
                    System.out.println("");
                    System.out.println("=======================");
                    System.out.println("Manufacturer: " + name); //list the manufacturer
                    serverMap.get(name).stream() //go back to server map, for this manufacturer
                            .forEach(s -> System.out.println(s.getName()) ); //print each server in the list
                });
 
    }
}
