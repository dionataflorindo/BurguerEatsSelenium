package BurgerEatsTests.Pages;

import BurgerEatsTests.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By localizadorBotaoCadastrarParaFazerEntrega = By.cssSelector("svg[stroke='currentColor']");

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public void acessaPaginaBurgerEats(){
        navegador.get("https://buger-eats-qa.vercel.app/");
    }

    public void cadastraParaFazerEntrega(){
        navegador.findElement(localizadorBotaoCadastrarParaFazerEntrega).click();
    }
}
