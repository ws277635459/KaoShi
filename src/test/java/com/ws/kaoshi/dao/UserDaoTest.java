package com.ws.kaoshi.dao;

import com.ws.kaoshi.KaoshiApplication;
import com.ws.kaoshi.beans.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KaoshiApplication.class)
public class UserDaoTest {

    @Resource
    private UserDao userDao;
    @Test
    public void queryUserByUsername() throws Exception{
       User user = userDao.queryUserByUsername("10001");
        System.out.println(user);
    }
}