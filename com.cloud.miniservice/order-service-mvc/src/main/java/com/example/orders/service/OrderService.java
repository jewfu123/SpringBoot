package com.example.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.pojo.Order;
import com.example.users.pojo.User;

@Service
public class OrderService {
  @Autowired
  private OrderMapper orderMapper;
  @Autowired
  private RestTemplate restTemplate;
  
  public Order queryOrderById(Integer orderId) {
    Order order = orderMapper.findById(orderId);
    String url = "http://userservice/user/" + order.getUser_id();
    User user = restTemplate.getForObject(url, User.class);
    order.setUser(user);
    return order;
  }
}
