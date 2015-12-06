package com.thesoftwareguild.cfblog;

import com.thesoftwareguild.cfblog.dao.CFBlogDao;
import com.thesoftwareguild.cfblog.dao.SearchTerm;
import com.thesoftwareguild.model.BlogPost;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Author Jonathan Y.
 */
public class SearchController {

    private CFBlogDao cfDao;


    @Inject
    public SearchController(CFBlogDao cfDao){
        this.cfDao=cfDao;
    }

    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String displaySearchPage(){
        return "search";
    }

    @RequestMapping(value="search/blogPosts", method=RequestMethod.POST)
    @ResponseBody
    public List<BlogPost> searchBlogPosts(@RequestBody Map<String,String>searchMap)
    {
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
        
        String currentTerm = searchMap.get("blogUser");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.BLOG_USER, currentTerm);
        }
        
        currentTerm = searchMap.get("blogDate");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.BLOG_DATE, currentTerm);
        }
        
        currentTerm = searchMap.get("title");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.TITLE, currentTerm);
        }
        
        currentTerm = searchMap.get("categories");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.CATEGORIES, currentTerm);
        }
        
        currentTerm = searchMap.get("tags");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(SearchTerm.TAGS, currentTerm);
        } 
        return cfDao.searchBlogPosts(criteriaMap);
    }
    
    
    
    
    /*
    @RequestMapping(value="search/blog", method = RequestMethod.POST)
    @ResponseBody
    public List<BlogPost> searchBlogs (@RequestBody Map<String, String> searchMap){

        Map<SearchTerm, String> criteriaMap = new HashMap<>();


        return cfDao.searchBlog(criteriaMap);


    }

 */

}
