package com.zyc.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zyc.mp.dao")
public class MpTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpTemplateApplication.class, args);
	}

}
