package org.cloud.amqp.rabbit.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * rabbit AMQP
 * @author XiaoHuiHui
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
