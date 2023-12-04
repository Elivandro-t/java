package br.com.ProjetoFood.pedidosFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PedidosFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosFoodApplication.class, args);
	}

}
