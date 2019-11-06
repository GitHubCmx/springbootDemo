package com.offcn.controller;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.offcn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    @author cmx
    @date
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
     @Autowired
     private UserMapper userMapper;

    @Value("${uname}")
    private String uname;


    @RequestMapping("/name")
    @ResponseBody
    public String getName(){
        return "uname:"+uname;
    }
/*
     //springboot整合spring Data jPA访问数据库
    @RequestMapping("/list")
    @ResponseBody
    public List<User> showUserList(){
        return userDao.findAll();
    }*/

    //springboot整合MyBatis
    @RequestMapping("/getList")
    @ResponseBody
    public List<User> getList(){
        return userMapper.getList();
    }

    //springboot整合spring Data jPA 页面展示
    @RequestMapping("/readList")
    public String readList(Model model){
        List<User> list = userDao.findAll();
        model.addAttribute("userList",list);

        return "user";
    }

}
