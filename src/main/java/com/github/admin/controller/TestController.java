package com.github.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述
 *
 * @author changjiang.tang Date:2/21/15 Time:1:39 PM
 */
@Controller
@RequestMapping
public class TestController {

    @RequestMapping("/test.do")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("layout/blank");
        modelAndView.addObject("content", "Hello World!");
        return modelAndView;
    }

}
