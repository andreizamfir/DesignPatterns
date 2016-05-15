package DesignPatterns;

//OBSERVER
public class Observator implements Observer{
	public Client client;
	
	public Observator(Client client){
		this.client = client;
		this.client.inregistreaza(this);
	}
	
	@Override
	public void notificaDepunere(Cont cont, double suma) {
		client.decizie.executa();
		System.out.println("Id cont: " + cont.id + ". Tip cont: " + cont.tip);
		System.out.println("S-a efectuat o depunere de " + suma + " lei. Noul sold: " + cont.sold + " lei.\n");
	}

	@Override
	public void notificaExtragere(Cont cont, double suma) {
		client.decizie.executa();
		System.out.println("Id cont: " + cont.id + ". Tip cont: " + cont.tip);
		System.out.println("S-a efectuat o extragere de " + suma + " lei. Sold ramas: " + cont.sold + " lei.\n");
	}

	@Override
	public void notificaPlata(double suma) {
		client.decizie.executa();
		ContCredit cont = (ContCredit) client.getCont(Conturi.CREDIT);
		System.out.println("Id cont: " + cont.id + ". Tip cont: " + cont.tip);
		System.out.println("S-a platit suma de " + suma + " lei catre banca. Sold ramas: " + cont.sold + " lei. Imprumut ramas: " + cont.getImprumut() + " lei.\n");
	}

}
