package com.kkwli.mpspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kkwli.mpspringboot.mapper")
@SpringBootApplication
public class MpSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpSpringbootApplication.class, args);
    }

}
