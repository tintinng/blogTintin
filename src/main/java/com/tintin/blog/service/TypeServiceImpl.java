package com.tintin.blog.service;

import com.tintin.blog.dao.TypeRepostory;
import com.tintin.blog.po.Type;
import com.tintin.blog.web.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepostory typeRepostory;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepostory.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepostory.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeRepostory.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepostory.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepostory.findAll();
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type){
        Type t = typeRepostory.findById(id).orElse(null);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);

        return typeRepostory.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id){
        typeRepostory.deleteById(id);
    }

}
