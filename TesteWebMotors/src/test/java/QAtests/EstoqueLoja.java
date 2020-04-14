package QAtests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class EstoqueLoja extends Hooks {

	@Dado ("acesse o site")
	public void	acesseosite() {
		setUp(); // iniciando WebDriver
		navegador.get("https://www.webmotors.com.br/carros/estoque/?IdRevendedor=3834764&TipoVeiculo=carro s&anunciante=concession%C3%A1ria%7Cloja"); //Indicando qual URL devera ser aberto
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Quando ("clicar na marca da honda")
	public void clicarnamarcadahonda() {
		navegador.findElement(By.xpath("//small[@class='CardMake__name-make'][contains(.,'honda')]")).click(); // clicando no simbolo da marca Honda
	} 
	
	@Entao ("selecionar city")
	public void selecionarcity() {
		navegador.findElement(By.xpath("//div[@class='Filters__line Filters__line--gray Filters__line--icon Filters__line--icon--right'][contains(.,'Todos os modelos')]")).click(); //Clicando na aba para escolher o modelo do veiculo
		navegador.findElement(By.xpath("//a[@href='https://www.webmotors.com.br/carros/estoque/honda/city']")).click();	// Escolhendo o modelo City
	}
	
	@E ("escolher versao")
	public void escolherversao() {
		navegador.findElement(By.xpath("//div[@class='Filters__line Filters__line--icon Filters__line--icon Filters__line--icon--right Filters__line--gray']")).click(); // clicando na aba para escolher a versão do veiculo
		navegador.findElement(By.xpath("//a[@href='https://www.webmotors.com.br/carros/estoque/honda/city/15-sport-16v-flex-4p-manual']")).click();	// clicando na versão desejada para pesquisa
	}
	
	@Entao ("fazer verificacao")
	public void fazerverificacao() {
		String textoElement = navegador.findElement(By.xpath("//li[@itemprop='itemListElement'][contains(.,'1.5 Sport 16v Flex 4p Manual')]")).getText();
		assertEquals("1.5 Sport 16v Flex 4p Manual", textoElement); // fazendo a validação
		tearDown(); // apos execução fechar navegador
	}
}
