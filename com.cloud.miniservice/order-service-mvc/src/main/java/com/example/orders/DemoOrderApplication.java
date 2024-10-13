package com.example.orders;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
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

