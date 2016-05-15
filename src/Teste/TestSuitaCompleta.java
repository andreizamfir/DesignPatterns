package Teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestBanca.class,
	TestClient.class,
	TestContCredit.class
})

public class TestSuitaCompleta {

}
