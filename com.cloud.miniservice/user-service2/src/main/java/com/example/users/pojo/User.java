package com.example.users.pojo;

import java.sql.Date;
import lombok.Data;

@Data
public class User {

    private Integer id;
    private String  username;
    private Date birthday;
    private String sex;
    private String address;

    
}
