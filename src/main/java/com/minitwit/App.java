package com.minitwit;

import static spark.Spark.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.minitwit.config.WebConfig;
import com.minitwit.service.impl.MiniTwitService;

@Configuration
@ComponentScan({ "com.minitwit" })
public class App {
  public static final int PORT = 4567;

  public static void main(String[] args) {
    port(getHerokuAssignedPort());

    @SuppressWarnings("resource")
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);

    new WebConfig(ctx.getBean(MiniTwitService.class));
    ctx.registerShutdownHook();
  }

  static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();

    if (processBuilder.environment().get("PORT") != null) {
      return Integer.parseInt(processBuilder.environment().get("PORT"));
    }

    return PORT;
  }
}
