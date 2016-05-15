package Teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DesignPatterns.ContCredit;
import DesignPatterns.ContFactory;
import DesignPatterns.Conturi;

public class TestContCredit {
	ContCredit contTestare;
	
	@Before
	public void initializare(){
		contTestare = (ContCredit) ContFactory.getCont(Conturi.CREDIT, 92, 1900, 5000);
	}
	
	@Test
	public void testInitializare(){
		Assert.assertNotNull("Contul nu exista", contTestare);
	}
	
	@Test
	public void testPlata(){
		double plata = 2200;
		double restImprumut = 2800;
		contTestare.plateste(plata);
		
		Assert.assertEquals("Nu sunt egale", restImprumut, contTestare.getImprumut(), 0);
	}
	
	@Test
	public void testTip(){
		Assert.assertEquals("Nu sunt la fel", "credit", contTestare.getTip());
	}
}
