package com.chen.movie.contorller;

import com.chen.movie.domain.Movie;
import com.chen.movie.feign.MovieFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.chen.movie.util.RedisUtil;

@RestController
public class UserController {

    @Autowired
    private MovieFeign movieFeign;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/user/watchMovie/{id}")
    public Movie findByUser(@PathVariable Long id) {

        String name = redisUtil.get("name");
        System.err.println(name);


        return movieFeign.findMoiveById(id);
    }





}