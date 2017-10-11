package com.springboot.project.controller;

import com.springboot.project.entity.PersonObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by Administrator on 2017/10/10.
 */
@Controller
public class PersonObjectController extends WebMvcConfigurerAdapter {
//那么通过上面的配置extends WebMvcConfigurerAdapter，不用添加Controller或者处理“results”的方法就可以直接通过“http://localhost:8080/projectContext/login”访问到login.html页面了！
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonObject personObject){
        return "form";
    }
//@Valid注解用于校验;BindingResult:代表数据绑定的结果,继承了Errors接口。 BindException:代表数据绑定的异常,它继承Exception,并实现了BindingResult,这是内部使用的错误对象
    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonObject personObject, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
            return "redirect:/results";

    }


}
