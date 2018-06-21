package com.example.hl7demo.controller;

import com.example.hl7demo.dao.UserDao;
import com.example.hl7demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

    @Controller
    public class UserController {
        @Autowired
        private UserDao userdao;
        @RequestMapping("/index")
        public String index(){
            return "index";
        }
        @RequestMapping("/regist")
        public String register(){
            return "register";
        }
        @RequestMapping("/addregister")
        public String addregister(HttpServletRequest request){
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String password2=request.getParameter("password2");
            if (password.equals(password2)){
                UserEntity userentity=new UserEntity();
                userentity.setUsername(username);
                userentity.setPassword(password);
                userdao.save(userentity);
                return "regsucceed";
            }
            else
                return "register";
        }
        @RequestMapping("/login")
        public String login(){
            return "login";
        }
        @RequestMapping("/addlogin")
        public String login(HttpServletRequest request){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserEntity userEntity = userdao.findByUsernameAndPassword(username,password);
            if (userEntity !=null){
                return "logsucceed";
            }else {
                return "login";
            }
        }
    }