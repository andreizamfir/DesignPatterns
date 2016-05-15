package DesignPatterns;

public class ContDebit extends Cont {
	public Client titular;
	
	public ContDebit(int id, double sold){
		this.tip = "debit";
		this.id = id;
		this.sold = sold;
	}
	
	public ContDebit(Client titular, int id, double sold){
		this.tip = "debit";
		this.titular = titular;
		this.id = id;
		this.sold = sold;
	}
	
	public String getTip(){
		return tip;
	}
	
	public int getId(){
		return this.id;
	}

	@Override
	public void depune(double suma) {
		this.sold += suma;
	}

	@Override
	public void extrage(double suma) {
		this.sold -= suma;
	}

	@Override
	public void plateste(double suma) {
		// TODO Auto-generated method stub
		
	}
}
