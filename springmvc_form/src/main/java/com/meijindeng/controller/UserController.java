package com.meijindeng.controller;

import com.meijindeng.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        model.addAttribute("favoriteFrameworks",user.getFavoriteFrameworks());
        model.addAttribute("gender",user.getGender());
        model.addAttribute("favoriteNumber",user.getFavoriteNumber());
        model.addAttribute("country",user.getCountry());
        model.addAttribute("skills",user.getSkills());
        return "userlist";
    }

    /**
     * 复选框(多项)目录
     * @return
     */
    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList() {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Spring Boot");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Hadoop");
        return webFrameworkList;
    }

    /**
     * 单选按钮(多项)
     * @return
     */
    @ModelAttribute("numbersList")
    public List<String> getNumbersList(){
        List<String> numbersList = new ArrayList<String>();
        numbersList.add("5");
        numbersList.add("24");
        numbersList.add("8");
        numbersList.add("25");
        return numbersList;
    }

    /**
     * 下拉选项
     * @return
     */
    @ModelAttribute("countryList")
    public Map<String, String> getCountryList(){
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("CH", "China");
        countryList.put("SG", "Singapore");
        countryList.put("MY", "Malaysia");
        return countryList;
    }

    /**
     * 列表多选框
     * @return
     */
    @ModelAttribute("skillsList")
    public Map<String, String> getSkillsList(){
        Map<String, String> skillsList = new HashMap<String, String>();
        skillsList.put("SpringBoot", "SpringBoot");
        skillsList.put("Spring", "Spring");
        skillsList.put("MyBatis", "MyBatis");
        skillsList.put("Docker", "Docker");
        skillsList.put("Redis", "Redis");
        return skillsList;
    }
}
