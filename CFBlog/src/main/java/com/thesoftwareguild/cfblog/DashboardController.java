/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.cfblog;

import com.thesoftwareguild.cfblog.dao.CFBlogDao;
import com.thesoftwareguild.model.BlogPost;
import com.thesoftwareguild.model.Category;
import com.thesoftwareguild.model.Tag;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Jonathan Chiou, Greg Lindeman, Jonathan Yates
 */
@Controller
public class DashboardController {
    
      private CFBlogDao dao;
//    
      @Inject
      public DashboardController(CFBlogDao dao){
        this.dao = dao;
       }
    

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String displayDashboardPage()
        {
            return "dashboard";
        }

    @RequestMapping(value="/dashboard/addEditStaticPage", method = RequestMethod.GET) //separate methods for add/edit? Since once may need to use POST?
    public String displayAddEditStaicPage() 
        {
            return "/dashboard/addEditStaticPage";
        }
    
    @RequestMapping(value="/dashboard/approveComments", method=RequestMethod.GET)
    public String displayApproveComments()
    {
        return "/dashboard/approveComments";
    }
    
    
//   The mapping below exists in its own controller, but I've left this here in the event that we migrate everything dashboard related here  
    
    @RequestMapping(value="/dashboard/addEditBlogPost", method = RequestMethod.GET) //separate methods for add/edit? Since once may need to use POST?
    public String displayAddEditBlogPost()
    {
        return "/dashboard/addEditBlogPost";
    }

    @RequestMapping(value="/dashboard/editPost", method=RequestMethod.GET)
    public String postBlogSubmission(){
        
        return "/dashboard/editPost";
    }
    
    @RequestMapping(value="/blogPost/{id}", method=RequestMethod.GET)
    @ResponseBody public BlogPost getBlogPost (@PathVariable("id") int id){
        return dao.getBlogPostById(id);
 
    }
    
    
    
     //Ajax method to add a blog Post

   @RequestMapping(value="/blogPost", method=RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody public BlogPost addBlogPost(@Valid @RequestBody BlogPost blogPost){
      
       dao.createNewBlogPost(blogPost);
       
       return blogPost;
   }
    
    @RequestMapping(value="/blogPost/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPost(@PathVariable ("id") int id){
        dao.deleteBlogPost(id);
    }
    
    
    @RequestMapping(value="blogPost/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putBlogPost(@PathVariable("id") int id, @RequestBody BlogPost blogPost){
    
        blogPost.setBlogPostId(id);
        dao.editBlogPost(blogPost);
    
    }
    
    @RequestMapping(value="/blogPost", method=RequestMethod.GET)
    @ResponseBody public List<BlogPost> getAllBlogPosts(){
        return dao.listAllBlogPosts();
    }
    
    
    
    //Ajax method to add Categoris

   @RequestMapping(value="/categories", method=RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody public Category addCategories(@Valid @RequestBody Category category){
      
       dao.createNewCategory(category);
       
       return category;
   }
    
    @RequestMapping(value="/categories/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable ("id") int id){
        dao.deleteCategory(id);
    }
    
    
    @RequestMapping(value="categories/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putCategory(@PathVariable("id") int id, @RequestBody Category category){
    
        category.setCategory_id(id);
        dao.editCategory(category);
    
    }
    
    @RequestMapping(value="/categories", method=RequestMethod.GET)
    @ResponseBody public List<Category> getAllCategories(){
        return dao.listAllCategories();
    }
        
    
    //AJAX Methods for Tags 
    
    
   @RequestMapping(value="/tags", method=RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody public Tag addTag(@Valid @RequestBody Tag tag){
      
       dao.createNewTag(tag);
       
       return tag;
   }
    
    @RequestMapping(value="/tags/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable ("id") int id){
        dao.deleteTag(id);
    }
    
    
    @RequestMapping(value="tags/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putTag(@PathVariable("id") int id, @RequestBody Tag tag){
    
        tag.setTag_id(id);
        dao.editTag(tag);
    
    }
    
    @RequestMapping(value="/tags", method=RequestMethod.GET)
    @ResponseBody public List<Tag> getAllTags(){
        return dao.listAllTags();
    }
    
    
    }

