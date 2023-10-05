package com.shop.urshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UrshopApplication {

  public static void main(String[] args) {
    SpringApplication.run(UrshopApplication.class, args);
  }
}
