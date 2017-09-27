package com.springboot.project.serviceImpl;

import com.springboot.project.entity.Student;
import com.springboot.project.service.FeignService02;
import org.springframework.stereotype.Component;

/**
 * 短路器的实现
 */
@Component
public class FeignService02Hystrix implements FeignService02 {
    @Override
    public String sayHiFromClientOne(String name) {
        return "SORRY"+name;
    }

    @Override
    public Student sayHiFromClientTwo(Integer id) {
        return new Student(1);
    }
}
