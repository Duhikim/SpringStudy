package io.goorm.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "io.goorm.mybatis.mapper")
@SpringBootApplication
public class MybatisApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybatisApplication.class, args);
	}

}
