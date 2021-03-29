package de.services.impl;

import de.services.Laguages;
import de.services.TranslationService;

public class TranslationServiceImpl implements TranslationService {

	@Override
	public String translate(String message) {
		
		return message.toUpperCase();
	}

	@Override
	public Laguages getLaguage() {
		
		return Laguages.ENGLISH;
	}

}
