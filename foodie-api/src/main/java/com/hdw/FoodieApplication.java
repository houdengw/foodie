package com.hdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hdw.mapper")
public class FoodieApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodieApplication.class,args);
    }
}
