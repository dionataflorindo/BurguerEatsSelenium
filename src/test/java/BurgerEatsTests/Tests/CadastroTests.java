package BurgerEatsTests.Tests;

import BurgerEatsTests.Pages.CadastroPage;
import BurgerEatsTests.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroTests {

    @Test
    public void preencheCadastro(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        HomePage homePage = new HomePage(navegador);

        homePage.acessaPaginaBurgerEats();

        homePage.cadastraParaFazerEntrega();

        CadastroPage cadastroPage = new CadastroPage(navegador);

        cadastroPage.preencheCadasto("dionata","dionata@teste.com","15783207047","5133698745","94055120","987","casa");

        cadastroPage.selecionaMetodoDeEntrga();

        cadastroPage.setCarregaFotoCnh();

        assertTrue(cadastroPage.cadastroFinalizado("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato."));
    }

}
