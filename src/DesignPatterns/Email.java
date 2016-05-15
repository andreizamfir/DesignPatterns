package DesignPatterns;

public class Email implements Decizie {
	public String email;
	
	public Email(String email){
		this.email = email;
	}
	
	@Override
	public void executa() {
		System.out.println("Se trimite un email catre adresa " + email + "...");
	}

}
