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
public class ProductInfoCosts {
    
    //attributes ---------------------------------------------------------------
    private String productType;
    private BigDecimal costMaterialSqFt;
    private BigDecimal costLaborSqFt;
    
    //constructor --------------------------------------------------------------
    public ProductInfoCosts(String productType) {
        this.productType = productType;
    }
    
    //getters and setters ------------------------------------------------------
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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
    
}