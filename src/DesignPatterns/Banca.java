package DesignPatterns;

import java.util.ArrayList;

//SINGLETON
public class Banca {
	protected static Banca banca;
	public Angajat CEO;
	public ArrayList<Client> clienti;
	
	private Banca(){
		clienti = new ArrayList<Client>();
	}
	
	public static Banca getInstance(){
		if (banca==null)
			banca = new Banca();
		return banca;
	}
	
	public void adaugareClient(Client client){
		clienti.add(client);
	}
	
	public void adaugareCEO(Angajat CEO){
		this.CEO = CEO;
	}
	
	public void afisareAngajati(){
		System.out.println(CEO.toString());
		for(Angajat sef : CEO.getSubordonati()){
			System.out.println(sef.toString());
			
			for(Angajat marketing : sef.getSubordonati()){
				System.out.println(marketing.toString());
				
				for(Angajat angajat : marketing.getSubordonati())
					System.out.println(angajat.toString());
			}
		}
		System.out.println();
	}
	
	public void afisareClienti(){
		for(Client c: clienti)
			System.out.println(c.toString());
		System.out.println();
	}
}
