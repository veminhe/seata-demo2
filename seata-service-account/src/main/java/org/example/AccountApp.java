package org.example;

import com.alibaba.cloud.seata.feign.SeataFeignClientAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {SeataFeignClientAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("org.example.mapper")
public class AccountApp {


    public static void main(String[] args) {


        SpringApplication.run(AccountApp.class, args);
    }
}
