package com.chen.movie.contorller;

import com.chen.movie.annotation.RateLimiter;
import com.chen.movie.domain.Movie;
import com.chen.movie.feign.MovieFeign;
import com.chen.movie.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private MovieFeign movieFeign;

    @GetMapping("/movie/{id}")
    @RateLimiter(key = "ratedemo:1.0.0")
    public Movie findByUser(@PathVariable Long id) {

        return movieFeign.findMoiveById(id);
    }

}