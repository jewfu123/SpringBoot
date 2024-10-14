package com.example.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.pojo.Order;
import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;

@Service
public class OrderService {
  @Autowired
  private OrderMapper orderMapper;
  
  @Autowired
  private UserClient userClient;
  
  public Order queryOrderById(Integer orderId) {
    Order order = orderMapper.findById(orderId);
    // used Feign
    User user = userClient.findById(order.getUser_id());
    order.setUser(user);
    return order;
  }
  
//  @Autowired
//  private RestTemplate restTemplate;
//  
//  public Order queryOrderById(Integer orderId) {
//    Order order = orderMapper.findById(orderId);
//    String url = "http://userservice/user/" + order.getUser_id();
//    User user = restTemplate.getForObject(url, User.class);
//    order.setUser(user);
//    return order;
//  }
}
