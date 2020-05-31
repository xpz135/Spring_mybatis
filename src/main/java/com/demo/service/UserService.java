package com.demo.service;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author X♡Game
 * @create 2020/5/21 11:18
 */

public interface UserService {

    public List<User> findAll()throws Exception;

    //添加
    public int addUser(User user)throws Exception;

    //修改
    public int update(@Param("id") int id, String name ,String Code ,String Address);

    //删除
    public int deleteById(@Param("id") int id)throws Exception;

    public User findById(@Param("id")Integer id)throws Exception;
}
