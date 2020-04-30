package com.tintin.blog.dao;

import com.tintin.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepostory extends JpaRepository<Type,Long>{
    Type findByName(String name);
}
