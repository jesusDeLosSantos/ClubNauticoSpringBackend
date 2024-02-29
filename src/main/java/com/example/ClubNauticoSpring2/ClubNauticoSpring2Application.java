package com.example.ClubNauticoSpring2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClubNauticoSpring2Application{

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*");
//			}
//		};
//	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/login/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("POST", "Content-Type","X-Requested-With","accept","Origin",
//								"Access-Control-Request-Method","Access-Control-Request-Headers")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/register/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("POST", "Content-Type","X-Requested-With","accept","Origin",
//								"Access-Control-Request-Method","Access-Control-Request-Headers")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/juego/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","POST", "PUT", "Content-Type","X-Requested-With","accept","Origin",
//								"Authorization","Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/votacion/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","POST", "DELETE","Content-Type","X-Requested-With",
//								"accept","Authorization","Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/usuario/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","PUT","Content-Type","X-Requested-With",
//								"accept","Authorization","Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/amistad/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","PUT","Content-Type","X-Requested-With",
//								"accept","Authorization","Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/token/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","PUT","Content-Type","X-Requested-With",
//								"accept","Authorization","Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/comentario/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","POST","Content-Type","X-Requested-With",
//								"accept","Authorization","Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/enviar/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("POST", "Content-Type","X-Requested-With","accept","Origin",
//								"Access-Control-Request-Method","Access-Control-Request-Headers")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/carga/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("POST", "Content-Type","X-Requested-With","accept","Origin",
//								"Access-Control-Request-Method","Access-Control-Request-Headers")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/avatar/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("POST", "Content-Type","X-Requested-With","accept","Origin",
//								"Access-Control-Request-Method","Access-Control-Request-Headers")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/listado/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","POST","PUT","Content-Type","X-Requested-With","accept","Origin",
//								"Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//				registry.addMapping("/quiz/**")
//						.allowedOrigins("http://localhost:4200")
//						.allowedHeaders("GET","PUT","Content-Type","X-Requested-With","accept","Authorization","Origin",
//								"Access-Control-Request-Method","Access-Control-Request-Headers")
//						.allowedMethods("PUT", "DELETE","OPTIONS", "GET", "POST", "HEAD")
//						.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
//			};
//		};
//
//	}


	public static void main(String[] args) {
		SpringApplication.run(ClubNauticoSpring2Application.class, args);
	}

}
