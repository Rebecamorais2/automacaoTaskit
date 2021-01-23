package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.assertEquals;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTesteData.csv")
public class InformacoesUsuarioPageObjectsTeste {
    private WebDriver navegador;

    @Before
    public  void setUp(){

        //navegador = Web.createChrome();
        navegador = Web.createBrowserStack();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagemEsperada")String mensagemEsperada){
     String textoToask = new LoginPage(navegador)
             .clickSignIn()
             .fazerLogin(login,senha)
             .clickMe()
             .clickTabMoreDataAboutYou()
             .clickButtonAddMoreDataAboutYou()
             .addContact(tipo,contato)
             .takeTextOfToask();
        assertEquals(mensagemEsperada,textoToask);
    }
    @After
    public void tearDown(){
        navegador.quit();
    }
}
