package com.Employee.employee;

import com.Employee.employee.Entity.Address;
import com.Employee.employee.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class Controller {

    @Autowired
    private WebClient webClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/getEmployee")
    public Employee getAllController(){

        ServiceInstance serviceInstance
                = loadBalancerClient.choose("ADDRESS-SERVICE");
        String url = serviceInstance.getUri().toString();
        System.out.println(url);
        Address address =  webClient.get()
                .uri(url+"/getAddress").retrieve()
                .bodyToMono(Address.class)
                .block();


        Employee employee =Employee.builder().id(1).name("prem").address(address).build();
        return employee;
    }
}
