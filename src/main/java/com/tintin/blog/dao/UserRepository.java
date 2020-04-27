package com.tintin.blog.dao;

import com.tintin.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>{

    User findByUserNameAndPassword(String username,String password);

}
