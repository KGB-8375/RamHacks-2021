package com.njbdk.Carmax;

import java.time.Duration;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/* This class is the main object application, i.e. the webserver itself */

@SpringBootApplication
public class CarmaxStatusPageApplication {
	// create a small database of cars
	// in a production environment this would be queried from a database
	private static Carmax honda = new Carmax("JH4KA7561PC008269", "Honda", "Civic", 2004, "honda.jpg");
	private static Carmax ford = new Carmax("2HGES26772H566107", "Ford", "F150", 2020, "ford.jpg");
	public static Carmax[] cars = new Carmax[2];

	// main method
	public static void main(String[] args) {
		// set some parts to be damaged for demonstration purposes
		honda.getPart("windshield").setDamaged(Duration.ofDays(7), "Cracked, needs replacement", 150.00);
		honda.getPart("tires").setDamaged(Duration.ofDays(1), "Rear left tire is flat", 300.00);
		honda.getPart("oil").setDamaged(Duration.ofMinutes(30), "Oil needs to be changed", 25.00);
		honda.getPart("brakes").setDamaged(Duration.ofMillis(20), "lil bit squeaky", 2000.69);
		honda.getPart("brakes").setInProgress(true);
		honda.getPart("suspension").setDamaged(Duration.ofDays(3), "Rusting, needs reconditioning", 350.00);
		honda.getPart("suspension").setInProgress(true);
		honda.getPart("hood").setDamaged(Duration.ofDays(0), "Minor dents, condition as is", 0);

		// populate databse
		cars[0] = honda;
		cars[1] = ford;

		// enter main event loop
		SpringApplication.run(CarmaxStatusPageApplication.class, args);
	}

	// force local to EN-US, in order to show correct currency
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
}
