/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.model;

import java.util.Objects;

/**
 *
 * @author Jon Chiou, Greg Lindeman
 */
public class Category {
    
    private int category_id;
    
    private String category_name;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.category_id;
        hash = 23 * hash + Objects.hashCode(this.category_name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this.category_id != other.category_id) {
            return false;
        }
        if (!Objects.equals(this.category_name, other.category_name)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
