package com.ws.kaoshi.dao;

import com.ws.kaoshi.KaoshiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KaoshiApplication.class)
public class PermissionsDaoTest {

    @Resource
    private PermissionsDao permissionsDao;
    @Test
    public void queryRoleNamesByUsername() throws Exception{
      Set<String> ps =permissionsDao.queryPermissionsByUsername("10001");
        Iterator<String> it =ps.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}