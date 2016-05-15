package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

//COMPOSITE
public class Angajat {
	public String nume;
	public String departament;
	public double salariu;
	public List<Angajat> subordonati;
	
	public Angajat(String nume, String departament, double salariu){
		this.nume = nume;
		this.departament = departament;
		this.salariu = salariu;
		subordonati = new ArrayList<Angajat>();
	}
	
	public void adaugaSubordonat(Angajat a){
		this.subordonati.add(a);
	}
	
	public void scoateSubordonat(Angajat a){
		this.subordonati.remove(a);
	}
	
	public List<Angajat> getSubordonati(){
		return subordonati;
	}
	
	public String toString(){
	      return ("Angajat : [Nume : " + nume + ", departament : " + departament + ", salariu :" + salariu +"]");
	  }  
}
