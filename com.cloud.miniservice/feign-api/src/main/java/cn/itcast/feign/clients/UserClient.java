package cn.itcast.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cn.itcast.feign.pojo.User;

@FeignClient(value="userservice")
public interface UserClient {
  @GetMapping("/user/{id}")
  public User findById(@PathVariable("id")Integer id);
}
