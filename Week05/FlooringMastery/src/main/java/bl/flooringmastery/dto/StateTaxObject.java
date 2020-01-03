/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author Boone
 */
public class StateTaxObject {
    
    //attributes
    private String stateName;
    private BigDecimal taxRate;

    //constructor
    public StateTaxObject(String stateName, BigDecimal taxRate) {
        this.stateName = stateName;
        this.taxRate = taxRate;
    }
    
    //getters and setters
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    
    
    
}
