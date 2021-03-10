package com.ws.kaoshi.beans;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String uName;
    private String pwdSalt;
}
