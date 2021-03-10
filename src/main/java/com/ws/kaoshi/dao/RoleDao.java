package com.ws.kaoshi.dao;

import java.util.Set;

public interface RoleDao {
    public Set<String> queryRoleNamesByUsername(String username);
}
