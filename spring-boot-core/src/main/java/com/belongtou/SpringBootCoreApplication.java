package com.belongtou;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootCoreApplication.class);
		//app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
