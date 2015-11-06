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
public class State {
    private String stateName;
    private Double stateTaxRate;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Double getStateTaxRate() {
        return stateTaxRate;
    }

    public void setStateTaxRate(Double stateTaxRate) {
        this.stateTaxRate = stateTaxRate;
    }
    
}
