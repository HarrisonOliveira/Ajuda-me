package com.estudo.ajudame;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AjudameApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjudameApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Ajuda-me")
						.description("API REST para gerenciamento de Organizações Não Governamentais (ONGs). " +
								"Esta API permite o cadastro, consulta e exclusão de ONGs, " +
								"com validação de dados e persistência em PostgreSQL.")
						.version("1.0.0")
						.contact(new Contact()
								.name("Equipe de Desenvolvimento Ajuda-me")
								.email("dev@ajudame.com")
								.url("https://www.ajudame.com"))
						.license(new License()
								.name("MIT License")
								.url("https://opensource.org/licenses/MIT")))
				.servers(List.of(
						new Server()
								.url("http://localhost:8080")
								.description("Servidor de Desenvolvimento"),
						new Server()
								.url("https://api.ajudame.com")
								.description("Servidor de Produção")
				));
	}
}
