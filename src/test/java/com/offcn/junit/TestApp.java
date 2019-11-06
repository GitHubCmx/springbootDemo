package com.offcn.junit;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.offcn.springbootDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = springbootDemoApplication.class)
@RunWith(SpringRunner.class)
public class TestApp {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;



    @Test
    public void test(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }


    }
    @Test
    public void testRedisTemplate(){
        // 存d到redis数据库

        redisTemplate.opsForValue().set("hello","0708java");
        // 取
        String str =(String) redisTemplate.opsForValue().get("hello");
        System.out.println(str);
        User user = new User("admin","123");
        user.setUid(1);
        redisTemplate.opsForValue().set("user",user);
        User user1 = (User)redisTemplate.opsForValue().get("user");
        System.out.println(user1);
    }
}
