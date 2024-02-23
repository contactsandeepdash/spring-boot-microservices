package com.dash.paymentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Payment Service REST API Controller",
				description = "Payment micro-service documentation",
				version = "0.0.1-SHAPSHOT",
				contact = @Contact(
						name = "Sandeep Dash",
						email = "contactsandeepdash@gmail.com",
						url = "https://www.linkedin.com/in/sandeep-dash-42a04217/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.linkedin.com/"
				)
		),
		externalDocs = @ExternalDocumentation(
				url = "https://www.google.com/",
				description = "Library"
		)

)
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
