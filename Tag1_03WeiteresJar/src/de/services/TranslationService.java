package de.services;

import java.util.ServiceLoader;

public interface TranslationService {
	
	public String translate(String message);
	
	public static TranslationService newInstance() {
		return ServiceLoader.load(TranslationService.class).findFirst().get(); 
	}
	
	Laguages getLaguage();

}
