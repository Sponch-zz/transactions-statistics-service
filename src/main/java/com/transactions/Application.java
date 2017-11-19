package com.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Start point of the application
 * @author csponchiado
 *
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.transactions")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	 @Bean
   public Docket newsApi() {
       return new Docket(DocumentationType.SWAGGER_2)
               .groupName("transactions-statistics-service")
               .apiInfo(apiInfo())
               .select()
               .paths(regex("/(statistics|transactions)"))
               .build();
   }
    
   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("REST API - Statistics of transactions")
               .description("Calculate and show statistics of transactions for the last 60 secs")
               .contact("Carlos Eduardo Spocnhiado")
               .license("Apache License Version 2.0")
               .version("2.0")
               .build();
   }
}
