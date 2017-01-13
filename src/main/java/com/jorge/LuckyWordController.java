package com.jorge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Try: 
 * 		http://localhost:8002/lucky-word  => You should see the lucky word message in your browser
 * 
 * Si tiene perfil activado (ejemplo: spring.profiles.active: northamerica) irá a su archivo yml correspondiente automáticamente (comosellame-northamerica.yml), si no irá al normal (comosellame.yml).
 * 
 */

@RestController
public class LuckyWordController {

	@Value("${lucky-word}") String luckyWord;

	@RequestMapping("/lucky-word")
	public String showLuckyWord() {
		return "The lucky word is: " + luckyWord;
	}
}