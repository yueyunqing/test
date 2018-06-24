package com.example.hl7demo.controller;

import com.example.hl7demo.dao.UserDao;
import com.example.hl7demo.entity.UserEntity;
import com.example.hl7demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/users")
    public class UserController {
        @Autowired
        private UserService userService;

        //一个简单的欢迎界面
        @RequestMapping("/index")
        public String index(){
            return "index";
        }

        //用户注册
        @RequestMapping("/regist")
        public String register(){
            return "register";
        }
        //注册过程
        @RequestMapping("/addregister")
        public String addregister(HttpServletRequest request){
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String password2=request.getParameter("password2");
            if (password.equals(password2)){
                userService.doregist(username,password);
                return "regsucceed";
            }
            else
                return "register";
        }
        //用户登录
        @RequestMapping("/login")
        public String login(){
            return "login";
        }
        //登录过程
        @RequestMapping("/addlogin")
        public String login(UserEntity userEntity,HttpServletRequest request){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(username+"********"+password);
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userEntity=userService.dologin(userEntity);
            if (userEntity !=null){
                return "logsucceed";
            }else {
                request.setAttribute("error", "用户名或密码错误！");
                return "login";
            }
        }
    }