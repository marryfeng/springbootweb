package com.springboot.project.dao;

import com.springboot.project.entity.Student;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */
@Mapper
public interface StudentMapper {
    Student getStudentByID(Integer id);

}
