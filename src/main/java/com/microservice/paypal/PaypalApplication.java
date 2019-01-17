package com.microservice.paypal;

import com.microservice.beans.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.InputStreamReader;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.microservice"
})
public class PaypalApplication implements CommandLineRunner {

	@Autowired
	private Credentials credentials;

	public static void main(String[] args) {
		SpringApplication.run(PaypalApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		if (credentials == null) {
			System.out.println("ERROR: Credentials not setted");
			System.exit(255);
		}

		if (credentials.getUsername() == null) {
			System.out.println("ERROR: Paypal Username not setted");
			System.exit(254);
		}

		if (credentials.getUsername().isEmpty()) {
			System.out.println("ERROR: Paypal Username not setted");
			System.exit(254);
		}

		if (credentials.getPassword() == null) {
			System.out.println("ERROR: Paypal Password not setted");
			System.exit(253);
		}

		if (credentials.getPassword().isEmpty()) {
			System.out.println("ERROR: Paypal Password not setted");
			System.exit(253);
		}
	}
}

