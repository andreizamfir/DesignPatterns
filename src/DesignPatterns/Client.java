package DesignPatterns;

import java.util.HashMap;

public class Client {
	public HashMap<Conturi, Cont> conturi;
	public String nume;
	public String CNP;
	public Observator observator;
	protected Decizie decizie;
	
	public Client(String nume, String CNP, Decizie decizie){
		this.conturi = new HashMap<Conturi, Cont>();
		this.nume = nume;
		this.CNP = CNP;
		this.decizie = decizie;
	}
	
	public void inregistreaza(Observator o){
		this.observator = o;
	}
	
	public boolean verificareCont(Cont cont){
		if(cont!=null)
			return true;
		else
			return false;
	}
	
	public boolean posibilitatePlata(Cont cont, double suma){
		if(cont.sold >= suma)
			return true;
		else
			return false;
	}
	
	public void depuneSuma(Cont cont, double suma){
		if(verificareCont(cont)){
			cont.depune(suma);
			notificareDepunere(cont, suma);
		}
		else
			System.out.println("Nu exista cont.\n");
	}
	
	public void extrageSuma(Cont cont, double suma){
		if(verificareCont(cont)){
			if(posibilitatePlata(cont, suma)){
				cont.extrage(suma);
				notificareExtragere(cont, suma);
			} else
				System.out.println("Nu se poate extrage suma de " + suma + " lei: fonduri insuficiente.");
		}
		else
			System.out.println("Nu exista cont.\n");
	}
	
	public void platesteSuma(double suma){
		ContCredit cc = (ContCredit) conturi.get(Conturi.CREDIT);
		if(verificareCont(cc)){
			if(cc.getImprumut()>0){
			if(posibilitatePlata(cc, suma)){
					double diferenta = suma;
					if(suma>cc.getImprumut())
						diferenta = cc.getImprumut();
					cc.plateste(suma);
					notificarePlata(diferenta);
				}
				else
					System.out.println("Nu se poate plati suma de " + suma + " lei: fonduri insuficiente!\n");
			} else
				System.out.println("Imprumutul s-a platit!\n");
		}
		else
			System.out.println("Nu exista cont de credit.\n");
	}
	
	public double getSold(Conturi cont){
		if(cont == Conturi.CREDIT){
			if(conturi.get(Conturi.CREDIT)!=null)
				return conturi.get(Conturi.CREDIT).sold;
		}
		else if(cont == Conturi.DEBIT){
			if(conturi.get(Conturi.DEBIT)!=null)
				return conturi.get(Conturi.DEBIT).sold;
		}
		return 0;
	}
	
	//FACADE
	public void platesteDupaDepunere(double depunere, double plata){
		depuneSuma(getCont(Conturi.CREDIT),depunere);
		platesteSuma(plata);
}
	
	//FLYWEIGHT
	public void adaugaCont(Cont cont){
		Cont c;
		if(cont.tip=="credit")
			c = (Cont) conturi.get(Conturi.CREDIT);
		else 
			c = (Cont) conturi.get(Conturi.DEBIT);
		
		if(c==null){
			switch(cont.tip){
			case "credit":{
				ContCredit cc = (ContCredit)cont;
				c = new ContCredit.Builder(cc.id, cc.sold).iaImprumut(cc.getImprumut()).build();
				conturi.put(Conturi.CREDIT, c);
				System.out.println(this.nume + ": se adauga in HashMap un cont de " + cont.tip + "\n");
				break;
			}
			case "debit":{
				c = new ContDebit(cont.id, cont.sold);
				conturi.put(Conturi.DEBIT, c);
				System.out.println(this.nume + ": se adauga in HashMap un cont de " + cont.tip + "\n");
				break;
			}
			}
		}
	}
	
	public Cont getCont(Conturi tip){
		return conturi.get(tip);
	}
	
	public double getImprumut(){
		ContCredit cc = (ContCredit) conturi.get(Conturi.CREDIT);
		return cc.getImprumut();
	}
	
	public void notificareExtragere(Cont cont, double suma){
		observator.notificaExtragere(cont, suma);
	}
	
	public void notificareDepunere(Cont cont, double suma){
		observator.notificaDepunere(cont, suma);
	}
	
	public void notificarePlata(double suma){
		observator.notificaPlata(suma);
	}

	@Override
	public String toString() {
		return "Client : [Nume=" + nume + ", CNP=" + CNP + "]";
	}
	
	public Decizie getDecizie(){
		return this.decizie;
	}
	
}
