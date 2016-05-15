package DesignPatterns;

//PROXY
public class ContDebitProxy extends Cont {
	protected ContDebit cd;
	
	public void verificaCont(Client titular, int id, double sold){
		if(cd==null){
			cd = new ContDebit(titular, id, sold);
			titular.adaugaCont(cd);
		}
	}
	
	public void depune(Client titular, int id, double sold, double suma) {
		verificaCont(titular, id, sold);
		//desi la fiecare depunere se actualizeaza contul, la iesire din cont.depune, ramane ca la inceput
		titular.depuneSuma(cd, suma);
	}

	public void extrage(Client titular, int id, double sold, double suma) {
		verificaCont(titular, id, sold);
		//desi la fiecare depunere se actualizeaza contul, la iesire din cont.extrage, ramane ca la inceput
		titular.extrageSuma(cd, suma);
	}

	@Override
	public void plateste(double suma) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void extrage(double suma){
		// TODO Auto-generated method stub
	}

	@Override
	public void depune(double suma) {
		// TODO Auto-generated method stub
		
	}

}
