package com.acruz.spring;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
			System.out.println("Teste de funcionamento:");
			Scanner scan = new Scanner(System.in);
			String x = scan.next();
			System.out.println("Replicador de informação: " + x);
		
	}
	
	

}
