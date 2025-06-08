package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {

    Dotenv dotenv = Dotenv.load();
    System.setProperty("spring.datasource.url", dotenv.get("POSTGRES_URL"));
    System.setProperty("spring.datasource.username", dotenv.get("POSTGRES_USERNAME"));
    System.setProperty("spring.datasource.password", dotenv.get("POSTGRES_PASSWORD"));
    System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
    System.setProperty("MONGO_DB", dotenv.get("MONGO_DB"));
    System.setProperty("AWS_ACCESS_KEY", dotenv.get("AWS_ACCESS_KEY"));
    System.setProperty("AWS_SECRET_KEY", dotenv.get("AWS_SECRET_KEY"));
    System.setProperty("AWS_REGION", dotenv.get("AWS_REGION"));
    SpringApplication.run(DemoApplication.class, args);
  }

}
