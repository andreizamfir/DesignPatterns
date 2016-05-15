package DesignPatterns;

//SIMPLE FACTORY
public class ContFactory {
	public static Cont getCont(Conturi cont, int id, double sold, double imprumut){
		switch(cont){
		case CREDIT:
			return new ContCredit.Builder(id, sold).iaImprumut(imprumut).build();
		case DEBIT:
			return new ContDebit(id, sold);
		}
		return null;
	}
}
