-- liquibase formatted sql
-- changeset jchiou:1

CREATE TABLE IF NOT EXISTS Users(
user_id INT(11) NOT NULL AUTO_INCREMENT,
first_name VARCHAR(256) NOT NULL,
last_name VARCHAR(256) NOT NULL,
email VARCHAR(256) NOT NULL,
role_id INT (100) NOT NULL,
user_name VARCHAR(256) NOT NULL,
password VARCHAR(256) NOT NULL,
PRIMARY KEY (user_id)

)ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=101;

CREATE TABLE IF NOT EXISTS Posts(
post_id INT (11) NOT NULL AUTO_INCREMENT,
user_id  INT (11) NOT NULL,
post_status_id INT (11) NOT NULL,
content BLOB,
PRIMARY KEY (post_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS PostStatus(
post_status_id int(11) NOT NULL auto_increment,
post_status varchar(250) NOT NULL,
PRIMARY KEY (post_status_id)
)ENGINE=InnoDB DEFAULT charset=latin1 auto_increment=1001;

ALTER TABLE Posts
ADD CONSTRAINT fk_post_user FOREIGN KEY(user_id)
REFERENCES Users(user_id);

ALTER TABLE Posts
ADD CONSTRAINT fk_post_status FOREIGN KEY(post_status_id)
REFERENCES PostStatus(post_status_id);

CREATE TABLE IF NOT EXISTS Roles(
role_id INT (11) NOT NULL AUTO_INCREMENT,
role_name VARCHAR(256) NOT NULL,
PRIMARY KEY(role_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=20;

CREATE TABLE IF NOT EXISTS Tags
(
tag_id int(11) NOT NULL AUTO_INCREMENT,
tag_name varchar (256) NOT NULL,
PRIMARY KEY (tag_id)
)Engine=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS Categories
(
category_id int(11) NOT NULL AUTO_INCREMENT,
categeory_name varchar(256) NOT NULL,
PRIMARY KEY (category_id)
)Engine=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS CommentStatus(
comment_status_id int(11) NOT NULL auto_increment,
comment_status varchar(250) NOT NULL,
PRIMARY KEY (comment_status_id)
)ENGINE=InnoDB DEFAULT charset=latin1 auto_increment=1001;

CREATE TABLE IF NOT EXISTS Comments(
comment_id INT(11) NOT NULL AUTO_INCREMENT,
post_id INT(11) NOT NULL,
user_id INT(11) NOT NULL,
comment_status_id INT(2) NOT NULL,
PRIMARY KEY (comment_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1001;

ALTER TABLE Comments
ADD CONSTRAINT
fk_comment_post FOREIGN KEY(post_id)
REFERENCES Posts(post_id);

ALTER TABLE Comments
ADD CONSTRAINT
fk_comment_user FOREIGN KEY(user_id)
REFERENCES Users(user_id);

ALTER TABLE Comments
ADD CONSTRAINT
fk_comment_status_id FOREIGN KEY(comment_status_id)
REFERENCES CommentStatus(comment_status_id);

CREATE TABLE IF NOT EXISTS TagPosts(
tag_id int(11) NOT NULL auto_increment,
post_id varchar(250) NOT NULL,
PRIMARY KEY (tag_id)
)ENGINE=InnoDB DEFAULT charset=latin1 auto_increment=1001;

CREATE TABLE IF NOT EXISTS Media(
blob_id INT (11) NOT NULL AUTO_INCREMENT,
blob_name VARCHAR(256) NOT NULL,
blob_type VARCHAR(256) NOT NULL,
blob_file_path VARCHAR(256) NOT NULL,
PRIMARY KEY (blob_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=101;

CREATE TABLE IF NOT EXISTS UserRoles(
role_id INT(11) NOT NULL,
user_id INT(11) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS Media_Posts(
post_id INT (11) NOT NULL,
blob_id INT (11) NOT NULL 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS Categories_Posts(
category_id INT (11) NOT NULL,
post_id INT (11) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- changeset jchiou:2

ALTER TABLE Posts
ADD title varchar (255) NOT NULL,
ADD blog_date date NOT NULL,
ADD category_id int (11),
ADD KEY category_id (category_id),
ADD CONSTRAINT fk_posts_category_id 
FOREIGN KEY(category_id)
REFERENCES
Categories (category_id);

-- changeset jchiou:3

INSERT INTO Users (user_id, first_name, last_name, email, role_id, user_name, `password`)
SELECT * FROM (SELECT 1 as user_id, "test" as first_name, "McTesty", "test@test.com", 1, "test", "password") AS tmp
WHERE NOT EXISTS(
	SELECT user_id from Users Where user_id =1 
) LIMIT 1;

INSERT INTO PostStatus (post_status_id, post_status)
SELECT * FROM (SELECT 1, "Pending") AS tmp
WHERE NOT EXISTS(
	SELECT post_status_id from PostStatus Where post_status_id =1 
) LIMIT 1;

-- changeset jchiou:4

ALTER TABLE Categories CHANGE categeory_name category_name VARCHAR(255);

INSERT INTO Categories (category_id, category_name)
SELECT * FROM (SELECT 1, "Pending") AS tmp
WHERE NOT EXISTS(
	SELECT category_id from Categories Where category_id =1 
) LIMIT 1;

INSERT INTO Roles (role_id, role_name)
SELECT * FROM (SELECT 1, "Admin") AS tmp
WHERE NOT EXISTS(
	SELECT role_id from Roles Where role_id =1 
) LIMIT 1;