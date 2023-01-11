package com.swcoaching.example1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwCoachingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwCoachingApplication.class, args);
  }

  @Bean
  public CommandLineRunner init(){
    return args -> {
      System.out.println("Hello world");
    };
  }

}
