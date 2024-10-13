package com.example.users.controller;

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
import com.example.users.mapper.UserMapper;
import com.example.users.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    UserMapper userMapper;
	
	@GetMapping("test")
	public String test() {
		return "abc";
	}
	
	@GetMapping("users")
	public List<User> read() {
		return userMapper.read();
	}
	
	@PostMapping("")
    public boolean create(@RequestBody String name) {
        return userMapper.create(name);
    }
	
	@GetMapping("/{id}")
    public User check(@PathVariable int id) {
        return userMapper.check(id);
    }
	
	@PatchMapping("/{id}")
    public boolean update(@PathVariable int id, @RequestBody String name) {
        return userMapper.update(id, name);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return userMapper.delete(id);
    }
    
//    @GetMapping("/{id}")
//    public User queryById(@PathVariable("id") Long id) { return userService.queryById(id); }
}
