package com.springboot.project.serviceImpl;


import com.springboot.project.dao.StudentMapper;
import com.springboot.project.entity.Student;
import com.springboot.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/12.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student getStudentByID(Integer id) {
        return studentMapper.getStudentByID(id);
    }
}
