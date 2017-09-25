package com.springboot.project.dao;

import com.springboot.project.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Mapper
public interface StudentMapper {
    List<Student> getListStudent();

    Student getId(Integer id);

}
