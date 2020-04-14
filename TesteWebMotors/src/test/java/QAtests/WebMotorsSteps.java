package QAtests;
import static org.junit.Assert.assertEquals;


import org.openqa.selenium.By;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;


public class WebMotorsSteps extends Hooks {

	@Dado ("que acesse o site")
	public void queacesseosite(){
	setUp();// Abrindo navegador
	navegador.get("https://www.webmotors.com.br");// Acessando a URL

	}

	@Quando ("clicar em ver ofertas")
	public void acessarclicaremverofertas(){
		navegador.findElement(By.xpath("//a[@href='/carros/estoque?idcmpint=t1:c17:m07:webmotors:busca::verofertas']")).click(); // Clicando em Ver Ofertas
		
	}
	
	@Entao ("clicar no simbolo da honda")
	public void acessarclicarnosimbolodahonda(){
		navegador.findElement(By.xpath("//small[@class='CardMake__name-make'][contains(.,'honda')]")).click(); // Clicando na Marca da Honda
	}

	@E ("selecionar modelo city")
	public void selecionarmodelocity() {
		navegador.findElement(By.xpath("//div[@class='Filters__line Filters__line--gray Filters__line--icon Filters__line--icon--right'][contains(.,'Todos os modelos')]")).click(); // Clicando sobre a aba para escolher modelo do veiculo
		navegador.findElement(By.xpath("//a[@href='https://www.webmotors.com.br/carros/estoque/honda/city']")).click(); // Selecionando o modelo City	
	}

	@E ("selecionar versao")
	public void selecionarversao() {
		navegador.findElement(By.xpath("//div[@class='Filters__line Filters__line--icon Filters__line--icon Filters__line--icon--right Filters__line--gray'][contains(.,'Todas as versões')]")).click(); // Clicando sobre a aba para escolher versão do veiculo
		navegador.findElement(By.xpath("//a[@href='https://www.webmotors.com.br/carros/estoque/honda/city/15-dx-16v-flex-4p-automatico']")).click(); // Selecionando a versão do veiculo
	}

	@Entao ("fazer validacao")
	public void fazervalidacao() {
	String textoElement = navegador.findElement(By.xpath("//h1[@class='title-search'][contains(.,'Honda City 1.5 Dx 16v Flex 4p Automático Novos e Usados')]")).getText();
	assertEquals("Honda City 1.5 Dx 16v Flex 4p Automático Novos e Usados", textoElement); // Fazendo a validação
	tearDown(); // Apos execução fechando o navegador
	}
	}
