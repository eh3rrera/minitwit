package com.minitwit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static spark.Spark.*;
import com.minitwit.config.WebConfig;
import com.minitwit.service.impl.MiniTwitService;

@Configuration
@ComponentScan({ "com.minitwit" })
public class App {
	public static void main(String[] args) {
		port(getHerokuAssignedPort());
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
    	new WebConfig(ctx.getBean(MiniTwitService.class));
        ctx.registerShutdownHook();
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }
}
