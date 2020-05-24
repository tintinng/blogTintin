package com.tintin.blog.po;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "t_comment")
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickName;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;

    private boolean adminComment;

    @ManyToOne
    private Blog blog;
    /**
     *  一个评论可以有多个子评论
     */
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();
    /**
     *  一个子评论只能有一个父评论
     */
    @ManyToOne
    private Comment parentComment;
}
