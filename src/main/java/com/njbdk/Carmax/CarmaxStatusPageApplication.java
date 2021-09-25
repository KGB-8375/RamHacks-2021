package com.njbdk.Carmax;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarmaxStatusPageApplication {
	public static Carmax carmax = new Carmax();

	public static void main(String[] args) {
		carmax.getPart("windshield").setDamaged(Duration.ofDays(7), "Cracked, needs replacement", 150.00);

		SpringApplication.run(CarmaxStatusPageApplication.class, args);
	}
}
