/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.cfblog.dao;

import com.thesoftwareguild.model.BlogPost;
import com.thesoftwareguild.model.Category;
import com.thesoftwareguild.model.Comment;
import com.thesoftwareguild.model.Role;
import com.thesoftwareguild.model.Tag;
import com.thesoftwareguild.model.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jonathan Chiou, Greg Lindemann, Jonathan Yates
 */
public interface CFBlogDao {
    
    //BlogPost
    
    public BlogPost getBlogPostById(int blogPostId);
    
    public BlogPost createNewBlogPost(BlogPost newBlogPost);
    
    public void editBlogPost(BlogPost blogPost);
    
    public void deleteBlogPost(int blogPostId);
    
    public List<BlogPost> listAllBlogPosts();
    
    public List<BlogPost> searchBlogPosts(Map<SearchTerm, String> Criteria);
        
    ///categories

    public Category getCategoryByid(int categoryId);
    public Category createNewCategory(Category category);
    public void editCategory(Category category);
    public void deleteCategory(int categoryId);
    public List<Category> listAllCategories();
    public List<Category> searchCategories(Map<SearchTerm, String> Criteria);
    
    
    //Tags
    public Tag getTagByid(int tagId);
    public Tag createNewTag(Tag tag);
    public void editTag(Tag tag);
    public void deleteTag(int tagId);
    public List<Tag> listAllTags();
    public List<Tag> searchTags(Map<SearchTerm, String> Criteria);
    
    
    //USERS
    public User getUserById(int userId);
    public User createNewUser(User user);
    public void editUser(User user);
    public void deleteUser(int userId);
    public List<User> listAllUsers();
    public List<User> searchUsers(Map<SearchTerm, String> Criteria);
    
    
    //COMMENTS
    public Comment getCommentById(int commentId);
    public Comment createNewComment(Comment comment);
    public void editComment(Comment comment);
    public void deleteComment(int commentId);
    public List<Comment> listAllComments();
    public List<Comment> searchComments(Map<SearchTerm, String> Criteria);
    
    
    //Roles
    public Role getRoleById(int roleId);
    public Role createNewRole(Role role);
    public void editRole(Role role);
    public void deleteRole(int roleId);
    public List<Role> listAllRoles();
    public List<Role> searchRoles(Map<SearchTerm, String> Criteria);
    
    
    
    
    
    
    
    
    
}
