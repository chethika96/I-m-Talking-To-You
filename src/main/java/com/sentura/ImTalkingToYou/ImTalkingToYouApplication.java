package com.sentura.ImTalkingToYou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class ImTalkingToYouApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ImTalkingToYouApplication.class, args);
	}

}
