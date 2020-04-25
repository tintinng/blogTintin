package com.tintin.blog.po;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Comment{
    private Long id;
    private String nickName;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;

    private Blog blog;
    /**
     *  一个评论可以有多个子评论
     */
    private List<Comment> replyComments = new ArrayList<>();
    /**
     *  一个子评论只能有一个父评论
     */
    private Comment parentComment;
}
