package DesignPatterns;

public class ContCredit extends Cont {
	private double imprumut;
	
	public ContCredit(){
		this.tip = "credit";
	}
	
	@Override
	public void plateste(double suma){
		if(suma>imprumut){
			this.sold -= imprumut;
			this.imprumut -= imprumut;
		} else{
			this.sold -= suma;
			this.imprumut -= suma;
		}
	}

	@Override
	public void depune(double suma) {
		this.sold += suma;
	}

	@Override
	public void extrage(double suma) {
		this.sold -= suma;
	}	
	
	public void setImprumut(double imprumut){
		this.imprumut = imprumut;
	}
	
	public double getImprumut(){
		return this.imprumut;
	}
	
	public String getTip(){
		return tip;
	}
	
	//BUILDER
	public static class Builder{
		ContCredit cont = new ContCredit();
		
		public Builder(int id, double sold){
			cont.id = id;
			cont.sold = sold;
		}
		
		public Builder iaImprumut(double imprumut){
			cont.setImprumut(imprumut);
			return this;
		}
		
		public ContCredit build(){
			return cont;
		}
	}
}
