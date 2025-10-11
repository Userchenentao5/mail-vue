package com.cet.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "com.cet.mapper")
@Configuration
public class ApplicationConfig {
}
