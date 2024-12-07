package com.example.demo;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@LoadBalancerClient(value="var1",configuration= Var1Configuration.class)
public class Calculator {
  RestTemplate restTemplate;
  public String add(int a,int b) {
    return restTemplate.getForObject("http://var1/add/" + a + "/" + b, String.class);
  }
}