/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import bl.flooringmastery.dto.FlooringOrder;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Boone
 */
public interface FlooringOrderDao {

    public Map<LocalDate, List<FlooringOrder>> getAllFlooringOrders(String testOrProd)
            throws FlooringOrderDaoException;

    public List<FlooringOrder> getFlooringOrdersBySingleDate(LocalDate dateToPull, String testOrProd)
            throws FlooringOrderDaoException;

    public FlooringOrder addFlooringOrder(FlooringOrder newOrder, String testOrProd)
            throws FlooringOrderDaoException;

    public FlooringOrder deleteFlooringOrder(int orderNumber, String testOrProd)
            throws FlooringOrderDaoException;
    
    public List<FlooringOrder> getAllOrdersByOrderNumber(String testOrProd)
            throws FlooringOrderDaoException;
    
    public FlooringOrder getASingleFlooringOrder(String testOrProd, int orderNumber) 
            throws FlooringOrderDaoException;
       
}