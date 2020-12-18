package com.shopskill.anubis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class AnubisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnubisApplication.class, args);
	}

	@Bean
	public RequestFilter requestFilter(){
		return new RequestFilter();
	}

}
