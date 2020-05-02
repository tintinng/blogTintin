package com.tintin.blog.dao;

import com.tintin.blog.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepostory extends JpaRepository<Tag,Long>{
    Tag findByName(String name);
}
