package com.sangini.SpringBootWebDemo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("add")
    public ModelAndView add(int num1, int num2, ModelAndView mv){

//        int num1= Integer.parseInt(request.getParameter("num1"));
//        int num2= Integer.parseInt(request.getParameter("num2"));
        mv.addObject("result", num1+num2);
        mv.setViewName("result");
        return mv;
    }
    @RequestMapping("addAlien")
    public String add(@ModelAttribute("alien1")  Alien alien){
        System.out.println("alien");
        System.out.println(alien);

//        int num1= Integer.parseInt(request.getParameter("num1"));
//        int num2= Integer.parseInt(request.getParameter("num2"));
//        mv.addObject("result", num1+num2);
//        mv.setViewName("result");
        return "result";
    }
}
