package com.tintin.blog.po;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "t_blog")
public class Blog{
    /**
     * entity properties
     */
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentable;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;

    /**
     * entity relationship
     */
    @ManyToOne
    private Type type;
    @ManyToMany
    private List<Tag> tags = new ArrayList<>();
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Comment> comments = new ArrayList<>();
}
