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
public class Order {
    
    private Integer orderNumber;
    private String orderDate;
    private String customerName;
    private String productType;
    private String state;
    private Double area;
    private Double tax;
    private boolean delete = false;
    private Double totalCostOfOrder;
    private Double taxRate;
    private Double costPSF;
    private Double laborCostPSF;
    private Double materialCost;
    private Double laborCost;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalCostOfOrder() {
        return totalCostOfOrder;
    }

    public void setTotalCostOfOrder(Double totalCostOfOrder) {
        this.totalCostOfOrder = totalCostOfOrder;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getCostPSF() {
        return costPSF;
    }

    public void setCostPSF(Double costPSF) {
        this.costPSF = costPSF;
    }

    public Double getLaborCostPSF() {
        return laborCostPSF;
    }

    public void setLaborCostPSF(Double laborCostPSF) {
        this.laborCostPSF = laborCostPSF;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public Double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
    
}
