package DesignPatterns;

public class Telefon implements Decizie {
	public String nrTelefon;
	
	public Telefon(){}
	
	public Telefon(String numar){
		nrTelefon = numar;
	}
	
	@Override
	public void executa() {
		System.out.println("Se trimite un SMS catre numarul " + nrTelefon + "...");
	}

}
