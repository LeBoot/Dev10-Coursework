/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Boone
 */
public class VendingItem {
    
    //attributes
    private String nameOfItem;
    private BigDecimal priceOfItem;
    private int quantityOfItem;

    //constructor
    public VendingItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }
    
    
    
    //getter only
    public String getNameOfItem() {
        return nameOfItem;
    }

    
    
    //getters and setters
    public BigDecimal getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(BigDecimal priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    public int getQuantityOfItem() {
        return quantityOfItem;
    }

    public void setQuantityOfItem(int quantityOfItem) {
        this.quantityOfItem = quantityOfItem;
    }

    //for unit testing ---------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nameOfItem);
        hash = 59 * hash + Objects.hashCode(this.priceOfItem);
        hash = 59 * hash + this.quantityOfItem;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendingItem other = (VendingItem) obj;
        if (this.quantityOfItem != other.quantityOfItem) {
            return false;
        }
        if (!Objects.equals(this.nameOfItem, other.nameOfItem)) {
            return false;
        }
        if (!Objects.equals(this.priceOfItem, other.priceOfItem)) {
            return false;
        }
        return true;
    }
    
    
}