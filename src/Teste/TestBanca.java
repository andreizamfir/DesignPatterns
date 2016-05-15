package Teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DesignPatterns.Angajat;
import DesignPatterns.Banca;
import DesignPatterns.Client;
import DesignPatterns.Email;
import DesignPatterns.Telefon;

public class TestBanca {
	Banca banca;
	Client client;
	
	@Before
	public void initializare(){
		banca = Banca.getInstance();
		banca.adaugareCEO(new Angajat("Johnny", "CEO", 12900));
		
		client = new Client("Miruna", "2980318152365", new Email("mirunazamfir@yahoo.com"));
		banca.adaugareClient(client);
	}
	
	@Test
	public void testareInstante(){
		Banca banca2 = Banca.getInstance();
		
		Assert.assertSame("Referinte diferite", banca, banca2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testPrimulSubordonat(){
		banca.CEO.subordonati.get(0);
	}
	
	@Test
	public void testClienti(){
		Assert.assertNotNull("Nu exista clienti", banca.clienti);
	}
	
	@Test
	public void testTelefon(){
		Assert.assertNotSame("Clientul are email", new Telefon(), client.getDecizie());
	}
}
