/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.cfblog.dao;

import com.thesoftwareguild.model.BlogPost;
import com.thesoftwareguild.model.Category;
import com.thesoftwareguild.model.Tag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Jonathan Chiou, Greg Lindeman, Jonathan Yates
 */
public class BlogDaoMemImpl implements CFBlogDao {

    
    private Map<Integer, BlogPost> blogMap = new HashMap<>();
    private static int blogIdCounter = 0;
    
    
    
    @Override
    public BlogPost getBlogPostById(int blogPostId) {
        return blogMap.get(blogPostId);
    
    }

    @Override
    public BlogPost createNewBlogPost(BlogPost newBlogPost) {
        newBlogPost.setBlogPostId(blogIdCounter);
        blogIdCounter++;
        
        blogMap.put(newBlogPost.getBlogPostId(), newBlogPost);
        return newBlogPost;
    }

    @Override
    public void editBlogPost(BlogPost blogPost) {
        blogMap.put(blogPost.getBlogPostId(), blogPost);
    
    }

    @Override
    public void deleteBlogPost(int blogPostId) {
        blogMap.remove(blogPostId);
    }

    @Override
    public List<BlogPost> listAllBlogPosts() {
        Collection<BlogPost> bp = blogMap.values();
        
        return new ArrayList(bp);
    
    }

    @Override
    public List<BlogPost> searchBlogPosts(Map<SearchTerm, String> criteria) {
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String blogDateCriteria = criteria.get(SearchTerm.BLOG_DATE);
        String userCriteria = criteria.get(SearchTerm.BLOG_USER);
        String categoriesCriteria = criteria.get(SearchTerm.CATEGORIES);
        String tagCriteria = criteria.get(SearchTerm.TAGS);
        
        
        Predicate<BlogPost> titleMatches;
        Predicate<BlogPost> blogDateMatches;
        Predicate<BlogPost> userMatches;
        Predicate<BlogPost> categoriesMatches;
        Predicate<BlogPost> tagMatches;
        
        Predicate<BlogPost> truePredicate = (bp) ->{return true;};
        
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())?
                truePredicate:
                (bp) -> bp.getTitle().equals(titleCriteria);
//        
//        blogDateMatches = (blogDateCriteria == null || blogDateCriteria.isEmpty())?
//                truePredicate:
//                (bp) -> bp.getBlogDate().equals(blogDateCriteria);
//        
//        userMatches = (userCriteria == null || userCriteria.isEmpty())?
//                truePredicate:
//                (bp) -> bp.getUser_id().equals(userCriteria);
//         
//        categoriesMatches = (categoriesCriteria == null || categoriesCriteria.isEmpty())?
//                truePredicate:
//                (bp) -> bp.getCategory_id().equals(categoriesCriteria);
//        
//        tagMatches = (tagCriteria == null || tagCriteria.isEmpty())?
//                truePredicate:
//                (bp) -> bp.getTags().equals(tagCriteria);
        
        return blogMap.values().stream()
                .filter(titleMatches) //remove the closing parentheses when uncommenting the other statements below
//                    .and(blogDateMatches)
//                    .and(userMatches)
//                    .and(categoriesMatches)
//                    .and(tagMatches))
                .collect(Collectors.toList());
        
    
    }

    @Override
    public Category getCategoryByid(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category createNewCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> listAllCategories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> searchCategories(Map<SearchTerm, String> Criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tag getTagByid(int tagId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tag createNewTag(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editTag(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTag(int tagId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tag> listAllTags() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tag> searchTags(Map<SearchTerm, String> Criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
