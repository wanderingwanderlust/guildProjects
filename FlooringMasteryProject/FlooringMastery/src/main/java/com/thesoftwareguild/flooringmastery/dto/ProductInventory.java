/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class ProductInventory {
    private String productName;
    private Double productCostPSQ;
    private Double laborCostPSQ;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductCostPSQ() {
        return productCostPSQ;
    }

    public void setProductCostPSQ(Double productCostPSQ) {
        this.productCostPSQ = productCostPSQ;
    }

    public Double getLaborCostPSQ() {
        return laborCostPSQ;
    }

    public void setLaborCostPSQ(Double laborCostPSQ) {
        this.laborCostPSQ = laborCostPSQ;
    }
    
}
