package com.demo.contrllor;

import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author X♡Game
 * @create 2020/5/21 21:07
 */

@Controller
public class UserConterllor {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @RequestMapping("/findAllType")
    @ResponseBody
    public List<User> findAll() {

        List<User> users = null;
        try {
            users = userMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Map<String, Object> findAll1() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> listUser = null;
        try {
            listUser = userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("listUser", listUser);
        return map;
    }


    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user) {
        try {
            if (userService.addUser(user) > 0) {
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "no";
    }


    @RequestMapping(value = "/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam("id") Integer id) {
        try {
            if (userService.deleteById(id) > 0) {
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "no";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("code")
            String code, @RequestParam("address") String address) {
        try {
            System.out.println(id + name + code + address);
            if (userService.update(id, name, code, address) > 0) {
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "no";
    }


    @RequestMapping(value = "/findById")
    public String findAll2(@RequestParam("id") int id, HttpSession session, User user) {
        try {
            user = userService.findById(id);
            session.setAttribute("user", user);
            System.out.println("user:" + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "update";

    }

    @RequestMapping(value = "/findByIde")
    @ResponseBody
    public Map<String, Object> findById(@RequestParam("id") Integer id, User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> listUser = null;
        try {
            user = userService.findById(id);
            listUser = userMapper.findAll();
            System.out.println("user" + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("user", user);
        map.put("listUser", listUser);
        return map;
    }
}