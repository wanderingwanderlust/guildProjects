package com.thesoftwareguild.cfblog.dao;

import com.thesoftwareguild.model.BlogPost;
import com.thesoftwareguild.model.Category;
import com.thesoftwareguild.model.Comment;
import com.thesoftwareguild.model.Role;
import com.thesoftwareguild.model.Tag;
import com.thesoftwareguild.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by .
 */
public class BlogDaoDbImpl implements CFBlogDao {

    //declare JdbcTemplate reference variable
    public JdbcTemplate jdbcTemplate;

    // setter/mutator for dependency injection
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //POST SQL  
    //Parameterized Strings for SQL Queries
    //Parameterized Strings for SQL BLOG POST Queries
    private static final String SQL_INSERT_BLOG_POST
            = "INSERT INTO Posts (user_id, post_status_id, content, title, blog_date)"
            + "values (?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_BLOG_POST
            = "DELETE FROM Posts WHERE post_id=?";

    private static final String SQL_SELECT_BLOG_POST
            = "SELECT * FROM Posts WHERE post_id=?";

    private static final String SQL_UPDATE_BLOG_POST
            = "UPDATE Posts SET user_id=?, post_status_id=?, content=? WHERE post_id=?";

    private static final String SQL_SELECT_ALL_POSTS
            = "SELECT * FROM Posts";

    
    @Override // we pull the requested blog post from the DB by it's ID
    public BlogPost getBlogPostById(int blogPostId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BLOG_POST, new postMapper(), blogPostId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override  //when user clicks submit, we add the blog post to the DB
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public BlogPost createNewBlogPost(BlogPost newBlogPost) {

        jdbcTemplate.update(SQL_INSERT_BLOG_POST, newBlogPost.getUser_id(), newBlogPost.getPost_status_id(),
                newBlogPost.getBlogText(), newBlogPost.getTitle(), newBlogPost.getBlogDate()
        );
        newBlogPost.setBlogPostId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return newBlogPost;
    }

    @Override
    public void editBlogPost(BlogPost blogPost) {
        jdbcTemplate.update(SQL_UPDATE_BLOG_POST,
                blogPost.getUser_id(),
                blogPost.getPost_status_id(),
                blogPost.getBlogDate(),
                blogPost.getTitle(),
                blogPost.getCategory_id(),
                blogPost.getTag(),
                blogPost.getBlogPostId()
        );

    }

    @Override
    public void deleteBlogPost(int blogPostId) {
        jdbcTemplate.update(SQL_DELETE_BLOG_POST, blogPostId);
    }

    @Override
    public List<BlogPost> listAllBlogPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new postMapper());
    }

    @Override
    public List<BlogPost> searchBlogPosts(Map<SearchTerm, String> Criteria) {
        return null;
    }

    
    // need to fill out the method budy for the mapRow method below
    private static final class postMapper implements RowMapper<BlogPost> {

        @Override
        public BlogPost mapRow(ResultSet rs, int i) throws SQLException {
            BlogPost blogPost = new BlogPost();
            blogPost.setBlogPostId(rs.getInt("post_id"));
            blogPost.setUser_id(rs.getInt("user_id"));
            blogPost.setPost_status_id(rs.getInt("post_status_id"));
            //blogPost.setBlogDate(rs.getDate("blogDate"));
            blogPost.setBlogText(rs.getString("content"));
            //blogPost.setBlogText(rs.getString("content"));
            blogPost.setTitle(rs.getString("title"));
            //blogPost.setCategories(rs.getString("categories"));
            //blogPost.setTags(rs.getString("tags"));
            return blogPost;

        }
    }

    
    /*
    Categories for SQL 
    */
    //Parameterized Strings for SQL Queries
    private static final String SQL_INSERT_CATEGORY
            = "INSERT INTO Categories (category_id, category_name)"
            + "values (?, ?)";
    
    private static final String SQL_DELETE_CATEGORY
            = "DELETE FROM Categories WHERE category_id=?";
    
    private static final String SQL_SELECT_CATEGORY
            ="SELECT * FROM Categories WHERE category_id=?";
    
    private static final String SQL_UPDATE_CATEGORY
            ="UPDATE Categories SET category_id=?, post_status_id=?, content=? WHERE post_id=?";
         
    private static final String SQL_SELECT_ALL_CATEGORIES
            ="SELECT * FROM Categories";
        
   @Override
    public Category getCategoryByid(int categoryId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY, new categoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

     //when user clicks submit, we add the blog post to the DB
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Category createNewCategory(Category category) {

        jdbcTemplate.update(SQL_INSERT_CATEGORY, category.getCategory_id(), category.getCategory_name()
        );
        category.setCategory_id(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return category;
    }

   @Override
    public void editCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategory_id(),
                category.getCategory_name()
                
        );

    }

    @Override
    public void deleteCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    @Override
    public List<Category> listAllCategories() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIES, new categoryMapper());
    }

    @Override
    public List<Category> searchCategories(Map<SearchTerm, String> Criteria) {
        return null;
    }
    
    
    // need to fill out the method budy for the mapRow method below
    private static final class categoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setCategory_id(rs.getInt("category_id"));
            category.setCategory_name(rs.getString("category_name"));
            return category;

        }
    }
   
    
    
    //Parameterized Strings for TAGS SQL Queries
    // ===================== TAGS ===============================

    private static final String SQL_INSERT_TAG
            = "INSERT INTO Tags (tag_id, tag_name)"
            + "values (?, ?)";

    private static final String SQL_DELETE_TAG
            = "DELETE FROM Tags WHERE tag_id=?";

    private static final String SQL_SELECT_TAG
            = "SELECT * FROM Tags WHERE tag_id=?";

    private static final String SQL_UPDATE_TAG
            = "UPDATE Tags SET tag_id=?, tag_name=?";

    private static final String SQL_SELECT_ALL_TAGS
            = "SELECT * FROM Tags";
    
    
    @Override
    public Tag getTagByid(int tagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY, new tagMapper(), tagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

     //when user clicks submit, we add the blog post to the DB
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Tag createNewTag(Tag tag) {

        jdbcTemplate.update(SQL_INSERT_TAG, tag.getTag_id(), tag.getTag_name()
        );
        tag.setTag_id(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return tag;
    }

   @Override
    public void editTag(Tag tag) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                tag.getTag_id(),
                tag.getTag_name()
        );

    }

    @Override
    public void deleteTag(int tagId) {
        jdbcTemplate.update(SQL_DELETE_TAG, tagId);
    }

    @Override
    public List<Tag> listAllTags() {
        return jdbcTemplate.query(SQL_SELECT_ALL_TAGS, new tagMapper());
    }

    @Override
    public List<Tag> searchTags(Map<SearchTerm, String> Criteria) {
        return null;
    }

    // need to fill out the method budy for the mapRow method below
    private static final class tagMapper implements RowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();
            tag.setTag_id(rs.getInt("tag_id"));
            tag.setTag_name(rs.getString("tag_name"));
            return tag;

        }
    }
    
    
     //Parameterized Strings for USERS SQL Queries
    // ===================== USERS ===============================
    
    
     private static final String SQL_INSERT_USER
            = "INSERT INTO Users (user_id, first_name, last_name, email, role_id, user_name, password)"
            + "values (?, ?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_USER
            = "DELETE FROM Users WHERE user_id=?";
    
    private static final String SQL_SELECT_USER
            ="SELECT * FROM Users WHERE user_id=?";
    
    private static final String SQL_UPDATE_USER
            ="UPDATE Users SET first_name=?, last_name=?, email=?, role_id=?, user_name=?, password=? WHERE user_id=?";
         
    private static final String SQL_SELECT_ALL_USERS
            ="SELECT * FROM Users";
    
    
     @Override
    public User getUserById(int userId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER, new userMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

     //when user clicks submit, we add the blog post to the DB
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User createNewUser(User user) {

        jdbcTemplate.update(SQL_INSERT_USER, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAccountRoleId(), user.getUsername(), user.getPassword()
        );
        user.setUserId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return user;
    }

   @Override
    public void editUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAccountRoleId(),
                user.getUsername(),
                user.getPassword()
        );

    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }

    @Override
    public List<User> listAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new userMapper());
    }

    @Override
    public List<User> searchUsers(Map<SearchTerm, String> Criteria) {
        return null;
    }

    // need to fill out the method budy for the mapRow method below
    private static final class userMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setAccountRoleId(rs.getInt("role_id"));
            user.setUsername(rs.getString("user_name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }
    
    
    
    
    //Parameterized Strings for COMMENTS SQL Queries
    // ===================== COMMENTS ===============================
      private static final String SQL_INSERT_COMMENT
            = "INSERT INTO Comments (user_id, comment_text, post_id)"
            + "values (?, ?, ?)";
    
    private static final String SQL_DELETE_COMMENT
            = "DELETE FROM Comments WHERE comment_id=?";
    
    private static final String SQL_SELECT_COMMENTS
            ="SELECT * FROM Comments WHERE comment_id=?";
    
    private static final String SQL_UPDATE_COMMENT
            ="UPDATE Users SET comment_text=?,WHERE comment_id=?";
         
    private static final String SQL_SELECT_ALL_COMMENTS
            ="SELECT * FROM Comments";
    
    
     @Override
    public Comment getCommentById(int commentId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_COMMENTS, new commentMapper(), commentId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

     //when user clicks submit, we add the blog post to the DB
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Comment createNewComment(Comment comment) {

        jdbcTemplate.update(SQL_INSERT_COMMENT, comment.getUserId(), comment.getCommentText(), comment.getPostId()
        );
        comment.setCommentId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return comment;
    }

   @Override
    public void editComment(Comment comment) {
        jdbcTemplate.update(SQL_UPDATE_COMMENT,
                comment.getCommentId(),
                comment.getUserId(),
                comment.getCommentText(),
                comment.getPostId()
               
        );

    }

    @Override
    public void deleteComment(int commentId) {
        jdbcTemplate.update(SQL_DELETE_COMMENT, commentId);
    }

    @Override
    public List<Comment> listAllComments() {
        return jdbcTemplate.query(SQL_SELECT_ALL_COMMENTS, new commentMapper());
    }

    @Override
    public List<Comment> searchComments(Map<SearchTerm, String> Criteria) {
        return null;
    }

    // need to fill out the method budy for the mapRow method below
    private static final class commentMapper implements RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            Comment comment = new Comment();
            comment.setCommentId(rs.getInt("comment_id"));
            comment.setUserId(rs.getInt("user_id"));
            comment.setCommentText(rs.getString("comment_text"));
            comment.setPostId(rs.getInt("post_id"));
            return comment;
        }
    }
    
    
    //Parameterized Strings for ROLES SQL Queries
    // ===================== ROLES ===============================
      private static final String SQL_INSERT_ROLE
            = "INSERT INTO Roles (roleName)"
            + "values (?)";
    
    private static final String SQL_DELETE_ROLE
            = "DELETE FROM Roles WHERE role_id=?";
    
    private static final String SQL_SELECT_ROLE
            ="SELECT * FROM Roles WHERE role_id=?";
    
    private static final String SQL_UPDATE_ROLE
            ="UPDATE Roles SET role_name=?,WHERE role_id=?";
         
    private static final String SQL_SELECT_ALL_ROLES
            ="SELECT * FROM Roles";
    
    
     @Override
    public Role getRoleById(int roleId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ROLE, new roleMapper(), roleId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

     //when user clicks submit, we add the blog post to the DB
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Role createNewRole(Role role) {

        jdbcTemplate.update(SQL_INSERT_ROLE, role.getRoleName()
        );
        role.setRoleId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return role;
    }

   @Override
    public void editRole(Role role) {
        jdbcTemplate.update(SQL_UPDATE_ROLE,
                role.getRoleId(),
                role.getRoleName()
        );

    }

    @Override
    public void deleteRole(int roleId) {
        jdbcTemplate.update(SQL_DELETE_ROLE, roleId);
    }

    @Override
    public List<Role> listAllRoles() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ROLES, new roleMapper());
    }

    @Override
    public List<Role> searchRoles(Map<SearchTerm, String> Criteria) {
        return null;
    }

    // need to fill out the method budy for the mapRow method below
    private static final class roleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException {
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
                    
            return role;
        }
    }
    
    
    
    

    } 
