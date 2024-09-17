package br.com.tiagocordeiro.cloudgatewayms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudgatewaymsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudgatewaymsApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
					.route(r -> r.path("/customers/**").uri("lb://customerms"))
					.route(r -> r.path("/cards/**").uri("lb://cardsms"))
				.build();
	}

}
