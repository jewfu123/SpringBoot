package com.example.orders.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.pojo.Order;
import com.example.orders.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
    OrderMapper orderMapper;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("test")
	public String test() {
		return "order";
	}
	
	@GetMapping("orders")
	public List<Order> read() {
		return orderMapper.read();
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable("id") Integer id) {
	    return orderMapper.findById(id);
	}
	
	@GetMapping("/q/{orderId}")
	public Order queryOrderByUserId(@PathVariable("orderId")Integer orderId) {
	  return orderService.queryOrderById(orderId);
	}
	
	@PostMapping("")
    public boolean create(@RequestBody String uid, String oid) {
        return orderMapper.create(uid, oid);
    }
	
	@PatchMapping("/{id}")
    public boolean update(@PathVariable int id, @RequestBody String uid) {
        return orderMapper.update(id, uid);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return orderMapper.delete(id);
    }
}
