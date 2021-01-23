package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {
    public AddContactPage(WebDriver navegador) {
        super(navegador);
    }
    public AddContactPage chooseContactType(String type){
        WebElement campoType= navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(type);
        return this;
    }

    public AddContactPage typeContact(String contact){
        navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contact);
        return this;
    }
    public MePage clickAndSalve(){
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();
        return new MePage(navegador);
    }

    public MePage addContact(String type, String contact){
        chooseContactType(type);
        typeContact(contact);
        clickAndSalve();
        return new MePage(navegador);
    }
}
