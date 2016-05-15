package Teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DesignPatterns.Client;
import DesignPatterns.ContCredit;
import DesignPatterns.ContDebit;
import DesignPatterns.Conturi;
import DesignPatterns.Email;
import DesignPatterns.Observator;

public class TestClient {
	Client client;
	ContDebit debit;
	ContCredit credit;
	
	@Before
	public void initializare(){
		client = new Client("Andrei", "1940116151932", new Email("andreizamfir@gmail.com"));
		debit = new ContDebit(43, 299);
		credit = new ContCredit.Builder(51, 45).iaImprumut(555).build();
		
		new Observator(client);

		client.adaugaCont(debit);
		client.adaugaCont(credit);
	}
	
	@Test
	public void testGetSold(){
		double sold = 299;
		
		Assert.assertEquals("Solduri diferite", sold, client.getSold(Conturi.DEBIT), 0);
	}
	
	@Test
	public void testAdaugaCont(){
		ContDebit debit2 = new ContDebit(51, 190);
		
		client.adaugaCont(debit2);
		ContDebit acelasi = (ContDebit) client.getCont(Conturi.DEBIT);
		
		Assert.assertSame("Conturi diferite", debit.getId(), acelasi.getId());
	}
	
	@Test
	public void testDepunerePlata(){
		
		double depunere = 155;
		double plata = 200;
		double sold = 0;
		System.out.println(client.getSold(Conturi.CREDIT));
		
		client.platesteDupaDepunere(depunere, plata);
		Assert.assertEquals("Solduri diferite", sold, client.getSold(Conturi.CREDIT), 0);
	}
}
