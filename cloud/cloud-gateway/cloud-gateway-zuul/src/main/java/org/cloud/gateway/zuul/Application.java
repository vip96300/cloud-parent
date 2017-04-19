package org.cloud.gateway.zuul;

import org.cloud.gateway.zuul.filter.AccessFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 服务网关
 *
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
