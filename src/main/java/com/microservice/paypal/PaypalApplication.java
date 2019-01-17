package com.microservice.paypal;

import com.microservice.config.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.InputStreamReader;
import java.util.Map;
import org.apache.log4j.Logger;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.microservice"
})
public class PaypalApplication implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(PaypalApplication.class.getName());

	@Autowired
	private Credentials credentials;

	public static void main(String[] args) {
		SpringApplication.run(PaypalApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		if (credentials == null) {
			logger.error("ERROR: Credentials not setted");
			System.exit(255);
		}

		if (credentials.getUsername() == null) {
			logger.error("ERROR: Paypal Username not setted");
			System.exit(254);
		}

		if (credentials.getUsername().isEmpty()) {
			logger.error("ERROR: Paypal Username not setted");
			System.exit(254);
		}

		if (credentials.getPassword() == null) {
			logger.error("ERROR: Paypal Password not setted");
			System.exit(253);
		}

		if (credentials.getPassword().isEmpty()) {
			logger.error("ERROR: Paypal Password not setted");
			System.exit(253);
		}
	}
}

