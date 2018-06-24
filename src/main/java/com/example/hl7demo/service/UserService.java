package com.example.hl7demo.service;

import com.example.hl7demo.dao.UserDao;
import com.example.hl7demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public UserEntity dologin(UserEntity userEntity){
        userEntity=userDao.login(userEntity.getUsername(),userEntity.getPassword());
        return  userEntity;
    }
    public void doregist(String username,String password){
        userDao.regist(username,password);
    }
}
