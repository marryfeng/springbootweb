package com.springboot.project.controller;


import com.springboot.project.entity.Student;
import com.springboot.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/12.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="getStudentByID",method = RequestMethod.GET)
    public Student getStudentByID(@RequestParam Integer id){

        return studentService.getStudentByID(id);
    }


}
