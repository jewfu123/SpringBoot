package com.example.orders.pojo;

import java.sql.Date;
import cn.itcast.feign.pojo.User;
import lombok.Data;

@Data
public class Order {

    private Integer id;
    private Integer user_id;
    private String  number;
    private Date createtime;
    private String note;
    private User user;
    
}
