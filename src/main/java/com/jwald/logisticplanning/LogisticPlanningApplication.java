package com.jwald.logisticplanning;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class LogisticPlanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticPlanningApplication.class, args);
	}
}
