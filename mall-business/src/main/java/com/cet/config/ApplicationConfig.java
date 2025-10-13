package com.cet.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 30952
 */
@MapperScan(basePackages = "com.cet.mapper.user")
@Configuration
public class ApplicationConfig {
}
