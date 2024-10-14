package com.example.users.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="pattern")
public class PatternProperties {
  private String dateformat;
}
