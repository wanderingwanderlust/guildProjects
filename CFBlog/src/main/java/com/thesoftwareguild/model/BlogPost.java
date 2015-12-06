/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jonathan Chiou, Greg Lindeman, Jonathan Yates
 */

public class BlogPost {

    private int blogPostId;

    private int user_id;
    
    private int post_status_id; //not sure if this should be an int instead? Using string for now as it can be converted to int easily for testste 
    
    private Date blogDate;
    
    private String title;
    
    private Category category;

    private int category_id;

    private List<Tag> tag;
    
    private String blogText;
    
    
    
    //getters and setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(int blogPostId) {
        this.blogPostId = blogPostId;
    }
    
    public int getPost_status_id() {
        return post_status_id;
    }

    public void setPost_status_id(int post_status_id) {
        this.post_status_id = post_status_id;
    }
    
    
    public Date getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(Date blogDate) {
        this.blogDate = blogDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.blogPostId;
        hash = 23 * hash + this.user_id;
        hash = 23 * hash + this.post_status_id;
        hash = 23 * hash + Objects.hashCode(this.blogDate);
        hash = 23 * hash + Objects.hashCode(this.title);
        hash = 23 * hash + Objects.hashCode(this.category);
        hash = 23 * hash + this.category_id;
        hash = 23 * hash + Objects.hashCode(this.tag);
        hash = 23 * hash + Objects.hashCode(this.blogText);
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
        final BlogPost other = (BlogPost) obj;
        if (this.blogPostId != other.blogPostId) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.post_status_id != other.post_status_id) {
            return false;
        }
        if (!Objects.equals(this.blogDate, other.blogDate)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (this.category_id != other.category_id) {
            return false;
        }
        if (!Objects.equals(this.tag, other.tag)) {
            return false;
        }
        if (!Objects.equals(this.blogText, other.blogText)) {
            return false;
        }
        return true;
    }


    






}
