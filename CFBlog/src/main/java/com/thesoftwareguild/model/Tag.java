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
public class Tag {
    
    
    private int tag_id;
    
    private String tag_name;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.tag_id;
        hash = 97 * hash + Objects.hashCode(this.tag_name);
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
        final Tag other = (Tag) obj;
        if (this.tag_id != other.tag_id) {
            return false;
        }
        if (!Objects.equals(this.tag_name, other.tag_name)) {
            return false;
        }
        return true;
    }

    
    
}
