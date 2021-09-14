package com.meijindeng.controller;

import com.meijindeng.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: UserController
 * @Author: dengmeijin
 * @Date: 2021/9/14 9:14
 */
@Controller
public class UserController {
    /**
     * 在ModelAndView对象中传递了一个名称为“command”的空User对象，
     * 因为如果在JSP文件中使用<form:form>标签，spring框架需要一个名称为“command”的对象。
     * 所以当调用user()方法时，它返回user.jsp视图。
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(){
        return new ModelAndView("user","command", new User());
    }

    /**
     * 将根据URL => springmvc_form/addUser 上的POST方法请求时调用。根据提交的信息准备模型对象。
     * 最后从服务方法返回“userlist”视图.
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(User user, ModelMap model){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("address",user.getAddress());
        model.addAttribute("receivePaper",user.isReceivePaper());
        return "userlist";
    }
}
