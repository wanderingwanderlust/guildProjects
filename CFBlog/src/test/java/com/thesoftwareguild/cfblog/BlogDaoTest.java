/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.cfblog;

import com.thesoftwareguild.cfblog.dao.BlogDaoDbImpl;
import com.thesoftwareguild.cfblog.dao.CFBlogDao;
import com.thesoftwareguild.model.BlogPost;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jonathan Chiou, Greg Lindeman, Jonathan Yates
 */
public class BlogDaoTest {
    
     CFBlogDao daoTest;
     BlogPost b1 = new BlogPost();
    
    
    public BlogDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        daoTest = new BlogDaoDbImpl();
         //TODO: finish seeting up dao on lines 39 and 40
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        daoTest = ctx.getBean("CFBlogDao", CFBlogDao.class);
        
        daoTest = new BlogDaoDbImpl();
        LocalDate date;
//        LocalDate date1 = date.atTime(6, 30, second);
        
        b1.setBlogPostId(1);
        b1.setUser_id(1);
        b1.setPost_status_id(1);
//        b1.setBlogDate();
        b1.setTitle("test!");
        b1.setBlogText("Test test test test test test");
        b1.setCategory_id(1);
        
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

 /*

    @Test
    public void addBlogPost() {
    daoTest.createNewBlogPost(b1);
    BlogPost test = daoTest.getBlogPostById(b1.getBlogPostId());
    
    String blogPostTitle = test.getTitle();
    
    assertEquals("test!",blogPostTitle);

    }
    */
}