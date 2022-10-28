package com.dxc.questionary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dxc.questionary.mapper")
public class QuestionaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuestionaryApplication.class, args);
        System.out.println("\n------------\n" + "启动成功" + "\n------------");
    }
}
