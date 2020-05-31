package com.demo.dao;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author X♡Game
 * @create 2020/5/21 10:41
 */
@Repository
public interface  UserMapper {
   //显示全部

    public  List<User> findAll();

    //添加
    public  int addUser(User user);

    //修改
    public int update(int id, String name ,String Code ,String Address);

    //删除
    public  int deleteById(@Param("id") int id);

    //根据id查询
    public User findById(@Param("id")Integer id)throws Exception;
}
