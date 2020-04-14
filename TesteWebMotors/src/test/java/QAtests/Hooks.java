package QAtests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
	
public static WebDriver navegador;

@Before
public void setUp() {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jonat\\drivers\\chromedriver.exe");
	navegador = new ChromeDriver();
	navegador.manage().window().maximize(); // Aumetar o tamanho do navegador
	navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Aguardando 5 segundos para iniciar pagina carregar
}

@After
public void tearDown() {
	navegador.quit(); // fechar navegador
}

}
