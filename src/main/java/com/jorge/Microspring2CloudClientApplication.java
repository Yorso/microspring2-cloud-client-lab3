package com.jorge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Try: 
 * 		http://localhost:8002/lucky-word  => You should see the lucky word message in your browser
 * 
 * Si tiene perfil activado (ejemplo: spring.profiles.active: northamerica) irá a su archivo yml correspondiente automáticamente (comosellame-northamerica.yml), si no irá al normal (comosellame.yml).
 * 
 */
@SpringBootApplication
public class Microspring2CloudClientApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.cloud.bootstrap.enabled","false");
		SpringApplication.run(Microspring2CloudClientApplication.class, args);
	}
}
