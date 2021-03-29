package de.bitmarck.amphibien;

public class Frosch {
	
	private String name;
	private int gewicht;
	
	
	public Frosch() {
		this("Nobody");
	}


	public Frosch(String name) {
		this.gewicht =10;
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getGewicht() {
		return gewicht;
	}


	private void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	public void fressen() {
		setGewicht(getGewicht()  + 1);
	}


	@Override
	public String toString() {
		return "Frosch [name=" + name + ", gewicht=" + gewicht + "]";
	}
	
	

}
