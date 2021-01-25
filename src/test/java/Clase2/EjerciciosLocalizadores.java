package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

//declarar variables para levantar instancias
public class EjerciciosLocalizadores {
    public WebDriver getDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    //ejercicios 2
    public void forgotAccountPartiaLinkTest(){
        WebDriver driver = getDriver("https//www.facebook.com");
        System.out.println("Titulo:" +driver.getTitle());
     //   driver.findElements(By.partialLinkText("¿Olvidaste")).click();
    }
}