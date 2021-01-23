package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador= navegador;
    }

    public String takeTextOfToask(){
        return navegador.findElement(By.id("toast-container")).getText();

    }
}
