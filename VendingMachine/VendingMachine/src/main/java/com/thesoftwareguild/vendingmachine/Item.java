/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.vendingmachine;

/**
 *
 * @author apprentice
 */
public class Item {
    
    private String itemId;
    private String name;
    private Double cost;
    private Integer count;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String id) {
        this.itemId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    
}
