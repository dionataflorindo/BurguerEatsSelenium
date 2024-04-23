package BurgerEatsTests.Tests;

import BurgerEatsTests.Pages.CadastroPage;
import BurgerEatsTests.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes na home page")
public class HomeTests {

    @Test
    @DisplayName("Acessando a página home da burger eats")
    public void testsAcessaHomePage(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        //abrir site do BurgerEats
        HomePage homePage = new HomePage(navegador);
        homePage.acessaPaginaBurgerEats();


        assertEquals("https://buger-eats-qa.vercel.app/", navegador.getCurrentUrl(),
                "A URL da página inicial não é a esperada.");

        homePage.fechaNavegador();
    }

    @Test
    @DisplayName("Acessando a pagina de cadastro da burger eats")
    public void testacessaCadastroParaEntregar(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        //abrir site do BurgerEats
        HomePage homePage = new HomePage(navegador);
        homePage.acessaPaginaBurgerEats();

        homePage.cadastraParaFazerEntrega();

        assertEquals("https://buger-eats-qa.vercel.app/deliver", navegador.getCurrentUrl(),
                "A URL da página inicial não é a esperada.");
    }

}
