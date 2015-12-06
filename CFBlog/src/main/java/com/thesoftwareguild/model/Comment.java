/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Comment {
    
    private int commentId;
    private int userId;
    private String commentText;
    private int postId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.commentId;
        hash = 53 * hash + this.userId;
        hash = 53 * hash + Objects.hashCode(this.commentText);
        hash = 53 * hash + this.postId;
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
        final Comment other = (Comment) obj;
        if (this.commentId != other.commentId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.commentText, other.commentText)) {
            return false;
        }
        if (this.postId != other.postId) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
