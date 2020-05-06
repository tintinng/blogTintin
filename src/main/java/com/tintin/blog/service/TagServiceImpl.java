package com.tintin.blog.service;

import com.tintin.blog.dao.TagRepostory;
import com.tintin.blog.po.Tag;
import com.tintin.blog.web.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepostory tagRepostory;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepostory.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepostory.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tagRepostory.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepostory.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepostory.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepostory.findAllById(convertToList(ids));
    }
    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idArray = ids.split(",");
            for(int i=0;i<idArray.length;i++){
                list.add(new Long(idArray[i]));
            }
        }
        return list;
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        // 判断要update的标签是否存在
        Tag t = tagRepostory.findById(id).orElse(null);
        if(t==null){
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);

        return tagRepostory.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepostory.deleteById(id);
    }
}
