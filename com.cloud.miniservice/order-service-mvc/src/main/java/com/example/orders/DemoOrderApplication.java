package com.example.orders;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.DefaultFeignConfiguration;

@EnableFeignClients(clients = {UserClient.class}, defaultConfiguration = DefaultFeignConfiguration.class)  //全局注解模式
@MapperScan("com.example.orders.mapper")
@SpringBootApplication
public class DemoOrderApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoOrderApplication.class, args);
  }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
      return new RestTemplate();
    }
    
//    @Bean
//    public IRule randomRule() {
//      return new RandomRule();
//    }
    
}

