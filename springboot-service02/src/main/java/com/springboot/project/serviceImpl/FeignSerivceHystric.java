package com.springboot.project.serviceImpl;

import com.springboot.project.entity.Student;
import com.springboot.project.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/25.
 */
@Component
public class FeignSerivceHystric implements FeignService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+name;
    }

    @Override
    public Student sayHiFromClientTwo(Integer id) {
        return new Student(null);
    }
}
