package com.example.demo;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.ServiceInstanceListSuppliers;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Var1Configuration {
	 @Bean
     public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {
         ServiceInstanceListSupplier serviceInstanceListSupplier = ServiceInstanceListSuppliers.from("Var1",
                 new DefaultServiceInstance("ms-client-2", "Var1", "localhost", 8082, false),
                 new DefaultServiceInstance("ms-client-3", "Var1", "localhost", 8083, false)
         );

         return ServiceInstanceListSupplier.builder()
                 .withBase(serviceInstanceListSupplier)
                 .build(context);
     }

}