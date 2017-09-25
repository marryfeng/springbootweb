package com.springboot.project.controller;

import com.springboot.project.entity.Student;
import com.springboot.project.service.FeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/25.
 */
@RestController
@Api("feignController相关的api")
public class FeignController {
    //这里如果是用@PathVariable来获取参数的时候，可以用swagger的注解@ApiImplicitParam
    //如果是用@RequestParam来获取参数，则不要用swagger的这个注解
    @Autowired
    private FeignService feignService;
    @ApiOperation(value = "服务的消费者调用服务提供者提供的接口", notes = "调用服务的提供者")
    @ApiImplicitParam(name = "name", value = "姓名", paramType = "path", required = true, dataType = "String")
    @RequestMapping(value = "hi/{name}",method = RequestMethod.GET)
    public String feignCall(@PathVariable String name){
     return    feignService.sayHiFromClientOne(name);
    }
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student feignCall2(@PathVariable Integer id){
        return feignService.sayHiFromClientTwo(id);

    }
}
