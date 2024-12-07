package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
  Calculator calculator;
  public AppController(Calculator calculator) {
    this.calculator=calculator;
  }
  @GetMapping("/")
  public String fun1()
  {
    return "client-1";
  }
  
  @GetMapping("/add/{a}/{b}")
  public String fun2(@PathVariable("a") int a,@PathVariable("b") int b) {
    URL url;
    String result=null;
    try {
     url = new  URL("http://localhost:8082/add/"+ a + "/" + b);
     HttpURLConnection con = (HttpURLConnection) url.openConnection();
     con.setRequestProperty("Accept","application/json");
     con.setDefaultUseCaches(false);
     BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
     result=br.readLine();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return result;
  }
  @GetMapping("/load/{a}/{b}")
  public String fun3(@PathVariable("a") int a,@PathVariable("b") int b) {
   return calculator.add(a,b);
  }
}