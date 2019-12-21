/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerInventory.dao;

import ServerInventory.dto.Server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Boone
 */
public class ServerDaoInMemImpl implements ServerDao {
    
    //create a map to store the servers
    private Map<String, Server> serverMap = new HashMap<>();

    //these next four are pretty simple pass-through methods -------------------
    @Override
    public void addServer(Server server) {
        serverMap.put(server.getName(), server);
    }

    @Override
    public Server getServer(String name) {
        return serverMap.get(name);
    }

    @Override
    public void removeServer(String name) {
        serverMap.remove(name);
    }

    @Override
    public List<Server> getAllServers() {
        //converts collection of servers into arrayList
        return new ArrayList<Server>(serverMap.values());
    }

    // These next methods use lambas and strings -------------------------------
    @Override
    public Map<String, List<Server>> getAllServersGroupByManufacturer() {
        return serverMap.values()
                .stream()
                .collect(Collectors.groupingBy(Server :: getManufacturer));
    }

    @Override
    public List<Server> getServersByManufacturer(String manufacturer) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
                    //filter keeps data only if the above statement is true
                .collect(Collectors.toList());
                    //collect puts all the filtered data into a list
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.toList());
    }

    @Override //combination of two previous methods
    public Map<String, List<Server>> getServersOlderThanGroupByManufacturer(int ageInYears) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.groupingBy(Server :: getManufacturer));    
    }

    @Override
    public double getAverageServerAge() {
        return serverMap.values()
                .stream()
                .mapToLong(Server :: getServerAge)
                //.mapToLong(s -> s.getServerAge())
                    //this syntax does the same thing
                //transform stream of servers into stream of long
                .average() //averages values, still longs
                .getAsDouble(); //converts the long values to double     
    }
    
}