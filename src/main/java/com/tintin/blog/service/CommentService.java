package com.tintin.blog.service;

import com.tintin.blog.po.Comment;

import java.util.List;

public interface CommentService{
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
