package BurgerEatsTests.Pages;

import org.openqa.selenium.*;


public class CadastroPage {

    private WebDriver browser;
    public static final String URL_CADASTROUSUARIO = "https://buger-eats-qa.vercel.app/deliver";

    private By inputNome = By.name("fullName");
    private By inputEmail = By.name("email");
    private By inputCpf = By.name("cpf");
    private By inputWhatsApp = By.name("whatsapp");
    private By inputCep = By.name("postalcode");
    private By inputNumero = By.name("address-number");
    private By inputComplemento = By.name("address-details");
    private By btnBuscarCep = By.cssSelector("input[value='Buscar CEP']");
    private By elementMoto = By.cssSelector("img[alt='Moto']");
    private By carregaFotoCnh = By.cssSelector("input[type='file']");
    private  By cadastroFinalizado = By.className("swal2-popup");
    private  By btnCadastrar = By.className("button-success");



    public CadastroPage(WebDriver browser) {
        this.browser = browser;
    }

    public boolean isPaginaAtual(){
        return browser.getCurrentUrl().equals(URL_CADASTROUSUARIO);
    }
    public void preencheCadasto(String nome, String email, String cpf, String whatsApp, String cep, String numero, String complemento){
        browser.findElement(inputNome).sendKeys(nome);
        browser.findElement(inputCpf).sendKeys(cpf);
        browser.findElement(inputEmail).sendKeys(email);
        browser.findElement(inputWhatsApp).sendKeys(whatsApp);
        browser.findElement(inputCep).sendKeys(cep);
        browser.findElement(inputNumero).sendKeys(numero);
        browser.findElement(inputComplemento).sendKeys(complemento);
        browser.findElement(btnBuscarCep).click();
    }

    public void selecionaMetodoDeEntrga(){
        browser.findElement(elementMoto).click();
    }

    public void setCarregaFotoCnh(){

        WebElement fileInput = browser.findElement(carregaFotoCnh);

        ((JavascriptExecutor) browser).executeScript("arguments[0].style.display = 'block';", fileInput);

        fileInput.sendKeys("C://SeleniumTest/DogDeMoto.jpg");
    }

    public boolean cadastroFinalizado(String textoEsperado){
        try {

            browser.findElement(btnCadastrar).submit();
            WebElement modalCadastroFinalizado = browser.findElement(cadastroFinalizado);

            if(!modalCadastroFinalizado.isDisplayed()){
                return false;
            }

            String mensagemConfirmacaoCadastro = modalCadastroFinalizado.getText();

            return  mensagemConfirmacaoCadastro.contains(textoEsperado);
        }catch (NoSuchElementException e){
            return false;
        }


    }

}
