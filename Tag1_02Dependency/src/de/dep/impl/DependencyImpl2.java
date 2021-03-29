package de.dep.impl;

import de.dep.Depenccy;

public class DependencyImpl2 implements Depenccy {
	
	@Override
	public void foo() {
		System.out.println("Hier ist foo2");
	}

	@Override
	public void bar() {
		System.out.println("Hier ist bar2");
	}

	@Override
	public String getName() {
		
		return "zwei";
	}
}
