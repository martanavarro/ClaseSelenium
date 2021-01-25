package Clase15.DocusignObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DocusignRegistrationPage {

    public WebDriver driver;

    public String getTitle(){
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void fillingRegistrationFields() {

        driver.findElement(By.xpath("//*[@title='close']")).click();
        driver.findElement(By.name("first_name")).sendKeys("Brianne");
        driver.findElement(By.name("last_name")).sendKeys("Eastburn");
        driver.findElement(By.name("email")).sendKeys("brianne@gmail.com");

        //driver.findElement(By.xpath("//*[@title='close']")).click();
        //driver.findElement(By.id("submitMainText_0")).click();
    }

    public void clickOnGetStartBtn(){
        driver.findElement(By.id("submitMainText_0")).click();
    }
}
