package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String AUTOMATE_USERNAME = "rebecamorais1";
    public static final String AUTOMATE_ACCESS_KEY = "H6djHkEitxgxfPgUmokp";
    public static final String URLBrowserStack = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){

        //Abrindo navegador
        System.setProperty("webdriver.chrome.driver","C:\\CursoSeleniumWebDriver\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //Tempo de espera dos elementos
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // maximizando a janela
        navegador.manage().window().maximize();
        //Navegando para a pagina do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");
    return navegador;
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("browserstack.debug","true");
        WebDriver navegador = null;
                try{
                    navegador = new RemoteWebDriver(new URL(URLBrowserStack), caps);
                    //Tempo de espera dos elementos
                    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    // maximizando a janela
                    navegador.manage().window().maximize();
                    //Navegando para a pagina do Taskit
                    navegador.get("http://www.juliodelima.com.br/taskit");
                }catch (MalformedURLException e){
                   System.out.println("Houveram problemas com a URL:"+e.getMessage());
                }

                return navegador;
    }
}
