package DesignPatterns;

public class Main {

	public static void main(String[] args) {
		Banca banca = Banca.getInstance();
		
		Angajat CEO = new Angajat("Doctor Who", "CEO", 99999);
		Angajat sefBanca = new Angajat("John Cena", "Sef Management", 45000);
		Angajat sefMarketing = new Angajat("Donald Duck", "Sef Marketing", 2500);
		
		banca.adaugareCEO(CEO);
		
		CEO.adaugaSubordonat(sefBanca);
		sefBanca.adaugaSubordonat(new Angajat("Sherlock Holmes", "Banking", 7200));
		sefBanca.adaugaSubordonat(new Angajat("Scarlet Johannson", "Banking", 6800));
		sefBanca.adaugaSubordonat(sefMarketing);
		sefMarketing.adaugaSubordonat(new Angajat("The Rock", "Marketing", 1400));
		
		banca.afisareAngajati();

		Client andrei = new Client("Andrei", "1940116151932", new Telefon("0726607407"));
		Client paul = new Client("Paul", "1701015229465", new Email("paul@gmail.com"));
		
		banca.adaugareClient(andrei);
		banca.adaugareClient(paul);
		
		banca.afisareClienti();
		
		Cont credit = ContFactory.getCont(Conturi.CREDIT, 1, 100, 125);
		Cont debit = ContFactory.getCont(Conturi.DEBIT, 2, 225, 0);
		Cont debit2 = ContFactory.getCont(Conturi.DEBIT, 123, 423, 0);
		
		new Observator(andrei);
		
		andrei.adaugaCont(credit);
		
		System.out.println("Sold cont debit: " + andrei.getSold(Conturi.DEBIT) + " lei.");
		ContDebitProxy cdp = new ContDebitProxy();
		cdp.extrage(andrei, 13, 120, 100);
		System.out.println("Sold cont debit: " + andrei.getSold(Conturi.DEBIT) + " lei.");
		
		andrei.adaugaCont(debit);
		andrei.adaugaCont(debit2);
		
		System.out.println("Cont debit: " + andrei.getSold(Conturi.DEBIT));
		
		andrei.platesteSuma(120);
		andrei.depuneSuma(andrei.getCont(Conturi.DEBIT), 40);
		andrei.platesteDupaDepunere(45, 80);
		andrei.depuneSuma(andrei.getCont(Conturi.DEBIT), 40);
		andrei.extrageSuma(andrei.getCont(Conturi.DEBIT), 15);
		
		paul.adaugaCont(ContFactory.getCont(Conturi.DEBIT, 99, 1500, 0));
		paul.extrageSuma(paul.getCont(Conturi.DEBIT), 1900);
		paul.extrageSuma(paul.getCont(Conturi.CREDIT), 100);
		
		System.out.println("Sold cont credit: " + andrei.getSold(Conturi.CREDIT) + ". Imprumut: " + andrei.getImprumut() + "\n");
		andrei.depuneSuma(andrei.getCont(Conturi.CREDIT), 130);
		andrei.platesteSuma(130);
		andrei.platesteSuma(110);
		
	}

}
