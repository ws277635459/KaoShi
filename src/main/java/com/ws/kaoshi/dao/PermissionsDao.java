package com.ws.kaoshi.dao;

import java.util.Set;

public interface PermissionsDao {
    public Set<String> queryPermissionsByUsername(String username);
}
