package com.meijindeng;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: HelloWorldController
 * @Author: dengmeijin
 * @Date: 2021/9/11 0:09
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(Model model) {
        model.addAttribute("message", "Spring MVC!!!");
        return"helloworld";
    }
}
