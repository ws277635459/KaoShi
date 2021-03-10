package com.ws.kaoshi.dao;

import com.ws.kaoshi.beans.User;

public interface UserDao {

    public User queryUserByUsername(String username);
}
