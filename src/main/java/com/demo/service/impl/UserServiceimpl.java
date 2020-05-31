package com.demo.service.impl;

import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author X♡Game
 * @create 2020/5/21 19:39
 */
@Service
public class UserServiceimpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> findAll() throws Exception {

        return userMapper.findAll();
    }

    @Override
    public int addUser(User user) throws Exception {
        return userMapper.addUser(user);
    }

    @Override
    public int update(int id, String name, String code, String address) {
        return userMapper.update(id,name,code,address);
    }

    @Override
    public int deleteById(int id) throws Exception {
        return userMapper.deleteById(id);
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userMapper.findById(id);
    }
}
