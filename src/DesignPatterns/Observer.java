package DesignPatterns;

public interface Observer {
	public void notificaExtragere(Cont cont, double suma);
	public void notificaDepunere(Cont cont, double suma);
	public void notificaPlata(double suma);
}
