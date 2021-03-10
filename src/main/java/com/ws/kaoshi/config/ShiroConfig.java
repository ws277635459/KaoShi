package com.ws.kaoshi.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.config.Ini;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroDialect getShiroDialect()
    {
        return new ShiroDialect();
    }

    //自定义realm
    @Bean
    public MyRealm getMyrealm()
    {
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm myRealm)
    {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //securityManager完成校验需要realm
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager)
    {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
                //过滤器就是Shiro进行权限校验的核心，进行认证和授权是需要SecurityManager的
        filter.setSecurityManager(securityManager);

        //设置shiro的拦截规则
        //anon匿名用户可访问
        //authc认证用户可访问
        //user 使用rememberMe的用户可访问
        //perms 对应权限可访问
        //role 对应角色才能访问
        Map<String,String> filterMap = new HashMap<>();
        filterMap.put("/","anon");
        filterMap.put("/login.html","anon");
        filterMap.put("/index.html","anon");
        filterMap.put("/register.html","anon");
        filterMap.put("/user/login","anon");
        filterMap.put("/user/register","anon");
        filterMap.put("/static/**","anon");
        filterMap.put("/img/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/**","authc");

        filter.setFilterChainDefinitionMap(filterMap);

        filter.setLoginUrl("/login.html");
        //设置未授权访问的页面路径
        filter.setUnauthorizedUrl("/login.html");
        return filter;
    }



}
