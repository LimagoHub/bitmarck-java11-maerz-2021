package de.dep.impl;

import de.dep.Depenccy;
import de.services.TranslationService;

public class DependencyImpl implements Depenccy {
	
	private final TranslationService translationService;
	
	
	
	public DependencyImpl() {
		
		this.translationService = TranslationService.newInstance();
	}

	@Override
	public void foo() {
		System.out.println(translationService.translate("Hier ist foo"));
	}

	@Override
	public void bar() {
		System.out.println(translationService.translate("Hier ist bar"));
	}

	@Override
	public String getName() {
		
		return "impl";
	}
}
