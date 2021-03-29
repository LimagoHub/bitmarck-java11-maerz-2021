package de.dep;

import java.util.Optional;
import java.util.ServiceLoader;

public interface Depenccy {
	
	String getName();

	void foo();

	void bar();
	
	public static Optional<Depenccy> create() {
		ServiceLoader<Depenccy> serviceLoader = ServiceLoader.load(Depenccy.class);
		return serviceLoader.stream().map(p->p.get()).filter(d->d.getName().equals("impl")).findFirst();
	}

}