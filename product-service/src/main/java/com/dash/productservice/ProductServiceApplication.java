package com.dash.productservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info (
		title = "Product Service REST API Controller",
		description = "Product micro-service documentation",
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
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
