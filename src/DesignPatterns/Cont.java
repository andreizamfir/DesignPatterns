package DesignPatterns;

public abstract class Cont{
	protected int id;
	protected double sold;
	protected String tip;
	
	public abstract void depune(double suma);
	public abstract void extrage(double suma);
	public abstract void plateste(double suma);

}
