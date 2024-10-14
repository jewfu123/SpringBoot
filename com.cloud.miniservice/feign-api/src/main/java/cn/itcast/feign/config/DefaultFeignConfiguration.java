package cn.itcast.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Logger;

@Configuration
public class DefaultFeignConfiguration {
    @Bean
    Logger.Level logLevel() {
    return Logger.Level.BASIC;
  }
}
