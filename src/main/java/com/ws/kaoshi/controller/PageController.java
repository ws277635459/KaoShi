package com.ws.kaoshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }
    @RequestMapping("/")
    public String login1(){
        return "login";
    }
    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("/add_student.html")
    public String add_student()
    {
        return "add_student";
    }
    @RequestMapping("/add_teacher.html")
    public String add_teacher()
    {
        return "add_teacher";
    }
    @RequestMapping("/delete_student.html")
    public String delete_student()
    {
        return "delete_student";
    }
    @RequestMapping("/delete_teacher.html")
    public String delete_teacher()
    {
        return "delete_teacher";
    }
    @RequestMapping("/make_exam.html")
    public String make_exam()
    {
        return "make_exam";
    }
    @RequestMapping("/mg_information.html")
    public String mg_information()
    {
        return "mg_information";
    }
    @RequestMapping("/online_exam.html")
    public String online_exam()
    {
        return "online_exam";
    }
    @RequestMapping("/online_test.html")
    public String online_test()
    {
        return "online_test";
    }
    @RequestMapping("/read_exam.html")
    public String read_exam()
    {
        return "read_exam";
    }
    @RequestMapping("/table.html")
    public String table()
    {
        return "table";
    }
    @RequestMapping("/update_permissions.html")
    public String update_permissions()
    {
        return "update_permissions";
    }
    @RequestMapping("/update_student.html")
    public String update_student()
    {
        return "update_student";
    }
}
