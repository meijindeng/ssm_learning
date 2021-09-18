package com.meijindeng.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: UserController
 * @Author: dengmeijin
 * @Date: 2021/9/18 14:10
 */
public class UserController extends MultiActionController {

    public ModelAndView home(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView("home");
        model.addObject("message","Home");
        return model;
    }

    public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView("user");
        model.addObject("message","Add meijindeng");
        return model;
    }

    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model = new ModelAndView("user");
        model.addObject("message","Remove meijindeng");
        return model;
    }
}
