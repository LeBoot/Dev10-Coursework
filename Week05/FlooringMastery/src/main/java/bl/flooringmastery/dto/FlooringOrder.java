/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Boone
 */
public class FlooringOrder {
    
    //attributes ---------------------------------------------------------------
    private int orderNumber;
    private String customerName;
    private LocalDate orderDate;
    private String stateName;
    private BigDecimal stateTaxRate;
    private String productType;
    private BigDecimal areaOfFlooring;
    private BigDecimal costMaterialSqFt;
    private BigDecimal costLaborSqFt;
    private BigDecimal costMaterialTotal;
    private BigDecimal costLaborTotal;
    private BigDecimal totalTax;
    private BigDecimal totalCost;
    
    //constructor --------------------------------------------------------------
    public FlooringOrder(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    //gettersAndSetters --------------------------------------------------------
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getStateTaxRate() {
        return stateTaxRate;
    }

    public void setStateTaxRate(BigDecimal stateTaxRate) {
        this.stateTaxRate = stateTaxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getAreaOfFlooring() {
        return areaOfFlooring;
    }

    public void setAreaOfFlooring(BigDecimal areaOfFlooring) {
        this.areaOfFlooring = areaOfFlooring;
    }

    public BigDecimal getCostMaterialSqFt() {
        return costMaterialSqFt;
    }

    public void setCostMaterialSqFt(BigDecimal costMaterialSqFt) {
        this.costMaterialSqFt = costMaterialSqFt;
    }

    public BigDecimal getCostLaborSqFt() {
        return costLaborSqFt;
    }

    public void setCostLaborSqFt(BigDecimal costLaborSqFt) {
        this.costLaborSqFt = costLaborSqFt;
    }

    public BigDecimal getCostMaterialTotal() {
        return costMaterialTotal;
    }

    public void setCostMaterialTotal(BigDecimal costMaterialTotal) {
        this.costMaterialTotal = costMaterialTotal;
    }

    public BigDecimal getCostLaborTotal() {
        return costLaborTotal;
    }

    public void setCostLaborTotal(BigDecimal costLaborTotal) {
        this.costLaborTotal = costLaborTotal;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
    
    
    //unit testing, equals and hashmap -----------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.orderNumber;
        hash = 83 * hash + Objects.hashCode(this.customerName);
        hash = 83 * hash + Objects.hashCode(this.orderDate);
        hash = 83 * hash + Objects.hashCode(this.stateName);
        hash = 83 * hash + Objects.hashCode(this.stateTaxRate);
        hash = 83 * hash + Objects.hashCode(this.productType);
        hash = 83 * hash + Objects.hashCode(this.areaOfFlooring);
        hash = 83 * hash + Objects.hashCode(this.costMaterialSqFt);
        hash = 83 * hash + Objects.hashCode(this.costLaborSqFt);
        hash = 83 * hash + Objects.hashCode(this.costMaterialTotal);
        hash = 83 * hash + Objects.hashCode(this.costLaborTotal);
        hash = 83 * hash + Objects.hashCode(this.totalTax);
        hash = 83 * hash + Objects.hashCode(this.totalCost);
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
        final FlooringOrder other = (FlooringOrder) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.stateTaxRate, other.stateTaxRate)) {
            return false;
        }
        if (!Objects.equals(this.areaOfFlooring, other.areaOfFlooring)) {
            return false;
        }
        if (!Objects.equals(this.costMaterialSqFt, other.costMaterialSqFt)) {
            return false;
        }
        if (!Objects.equals(this.costLaborSqFt, other.costLaborSqFt)) {
            return false;
        }
        if (!Objects.equals(this.costMaterialTotal, other.costMaterialTotal)) {
            return false;
        }
        if (!Objects.equals(this.costLaborTotal, other.costLaborTotal)) {
            return false;
        }
        if (!Objects.equals(this.totalTax, other.totalTax)) {
            return false;
        }
        if (!Objects.equals(this.totalCost, other.totalCost)) {
            return false;
        }
        return true;
    }
    
    
    
}