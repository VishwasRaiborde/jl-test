package com.jl.bdd.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jl")
public class LiveTestApp {
	public static void main(String args[]) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(LiveTestApp.class);
        builder.headless(false).run(args);
	}
}
