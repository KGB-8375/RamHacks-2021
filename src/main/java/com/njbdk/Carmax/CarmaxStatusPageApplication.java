package com.njbdk.Carmax;

import java.time.Duration;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class CarmaxStatusPageApplication {
	public static Carmax carmax = new Carmax();
	public static void main(String[] args) {
		carmax.getPart("windshield").setDamaged(Duration.ofDays(7), "Cracked, needs replacement", 150.00);
		carmax.getPart("tires").setDamaged(Duration.ofDays(1), "Rear left tire is flat", 300.00);
		carmax.getPart("oil").setDamaged(Duration.ofMinutes(30), "Oil needs to be changed", 25.00);

		SpringApplication.run(CarmaxStatusPageApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
}
