/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.cfblog;

import com.thesoftwareguild.cfblog.dao.CFBlogDao;
import com.thesoftwareguild.model.BlogPost;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    
   private CFBlogDao dao;
//    
    @Inject
    public HomeController(CFBlogDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value={"/", "/home", "/cfblog"}, method = RequestMethod.GET)
    public String displayHomePage()
    {
        return "home";
    }
    
//    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
//    @ResponseBody public List<BlogPost>getAllBlogPosts(){
//        
//        return dao.listAllBlogPosts();
//        
//    }
    
    
//    //Ajax method to get dvd by id
//   @RequestMapping(value="/blogPost/{id}", method=RequestMethod.GET)
//   @ResponseBody public BlogPost getBlogPost(@PathVariable("id") int id){
//       return dao.getBlogPostById(id);
//   }
   
//   //AJAX method to list all DVDS
//   @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
//   @ResponseBody public List<BlogPost> getBlogPosts(){
//       return dao.listAllBlogPosts();
//   }
    
      
    @RequestMapping(value="/postPage", method=RequestMethod.GET)
    public String displayPostPage(){
        return "postPage";
    }
    
    
    
    
    
    //COMMENT HANDLER
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    