package com.metro.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class RewardsApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RewardsApplication.class, args);
	}
}
