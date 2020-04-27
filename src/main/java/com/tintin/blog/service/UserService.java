package com.tintin.blog.service;

import com.tintin.blog.po.User;

public interface UserService{
    User checkUser(String username,String password);
}
