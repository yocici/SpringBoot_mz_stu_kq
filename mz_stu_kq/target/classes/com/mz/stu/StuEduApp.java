package com.mz.stu;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(scanBasePackages = "com.mz.stu")
@MapperScan("com.mz.stu.mapper")
public class StuEduApp {
    public static void main(String[] args) {
        SpringApplication.run(StuEduApp.class,args);
    }
}
