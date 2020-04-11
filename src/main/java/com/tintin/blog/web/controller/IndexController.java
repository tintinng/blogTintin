package com.tintin.blog.web.controller;

import com.tintin.blog.web.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tintin
 */
@Controller
public class IndexController{

    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id,@PathVariable String name){

//        int i = 9/0;

//        String blog = null;
//        if(blog == null){
//            throw new NotFoundException("博客不存在");
//        }

        System.out.println("------------index-------------");

        return "index";
    }
}
