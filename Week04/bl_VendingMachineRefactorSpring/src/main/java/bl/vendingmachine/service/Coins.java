/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.service;

import java.math.BigDecimal;

/**
 *
 * @author Boone
 */
public enum Coins {
    QUARTERS(new BigDecimal("0.25")), 
    DIMES(new BigDecimal("0.10")),
    NICKELS(new BigDecimal("0.05")),
    PENNIES(new BigDecimal("0.01")),;
    
    private final BigDecimal value;
    private Coins(BigDecimal value) {
        this.value = value;
    }
    
    public BigDecimal getValue() {
        return value;
    }
}