CREATE TABLE users(
    user_id BIGINT AUTO_INCREMENT primary key,
    email varchar(255) not null unique key,
    password varchar(255) not null
);
INSERT INTO users(id,email,password) VALUES (1,'seok556@gmail.com','1234');
INSERT INTO users(id,email,password) VALUES (2,'chan7952@naver.com','7952');
INSERT INTO users(id,email,password) VALUES (3,'kang6231@gmail.com','6231');
