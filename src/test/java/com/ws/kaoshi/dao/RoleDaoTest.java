package com.ws.kaoshi.dao;

import com.ws.kaoshi.KaoshiApplication;
import com.ws.kaoshi.beans.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KaoshiApplication.class)
public class RoleDaoTest {

    @Resource
    private RoleDao roleDao;
    @Test
    public void queryRoleNamesByUsername() throws Exception{
      Set<String> roleNames =roleDao.queryRoleNamesByUsername("10001");
        Iterator<String> it =roleNames.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}