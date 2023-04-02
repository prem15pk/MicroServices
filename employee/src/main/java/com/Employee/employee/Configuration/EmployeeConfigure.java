package com.Employee.employee.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class EmployeeConfigure {

   @Value("${address.base.url}")
   private String url;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Bean
    public WebClient webClient(){
        ServiceInstance serviceInstance
                = loadBalancerClient.choose("ADDRESS-SERVICE");
        String url = serviceInstance.getUri().toString();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+url);
        return WebClient.builder().build();
    }
}
