package com.tintin.blog.po;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "t_type")
public class Type{
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "分类名称不为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
