package com.example.hl7demo.dao;

import com.example.hl7demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Integer> {
    public UserEntity findByUsernameAndPassword(String username,String passwod);
}
