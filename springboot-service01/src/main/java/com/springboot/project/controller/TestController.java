package com.springboot.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 跳转页面这里不能使用@RestController，只能用@Controller.如果返回json格式的数据，加上注解@ResponseBody
 * 如果使用@RestController则参考下面的写法.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String page(){
        return "index";
    }

    @RequestMapping(value = "/info/demo",method = RequestMethod.GET)
    public String infoDemo(){
        return "info";
    }
}
/*@RestController
public class TestController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView page() {
        ModelAndView mv=new ModelAndView("index");
        return mv;
    }

    @RequestMapping(value = "/info/demo",method = RequestMethod.GET)
    public ModelAndView infoDemo(){
        ModelAndView mv=new ModelAndView("info");
        return mv;
    }
}*/
