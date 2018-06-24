package com.example.hl7demo.dao;

import com.example.hl7demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    public UserEntity login(String username,String password);
    public void regist(String username,String password);
}
