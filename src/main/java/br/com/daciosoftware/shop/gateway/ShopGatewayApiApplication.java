package br.com.daciosoftware.shop.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ShopGatewayApiApplication {

	@Value("${product.api.url}")
	private String productApiUrl;
	@Value("${user.api.url}")
	private String userApiUrl;
	@Value("${shopping.api.url}")
	private String shoppinApiUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(ShopGatewayApiApplication.class, args);
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route("product_route", r -> r.path("/product/**")
						.uri(productApiUrl))
				.route("product_route", r -> r.path("/category/**")						
						.uri(productApiUrl))
				.route("user_route", r -> r.path("/user/**")
						.uri(userApiUrl))
				.route("shopping_route", r -> r.path("/shopping/**")
						.uri(shoppinApiUrl))
				.build();
	}

}
