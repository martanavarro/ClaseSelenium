package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selectores {
    public WebDriver getDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void facebookTest(){
        WebDriver driver = getDriver("https://www.facebook.com");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testing@test.com");
        driver.findElement(By.xpath("//input[@data.testid='royal_email']")).sendKeys("asdf@test.cl");
    }

    @Test
    public void docusign_test(){
        WebDriver driver = getDriver("https//go.docusign.com");
    }

    @Test
    public void completeDocusignRegistration(){
        WebDriver driver = getDriver("https//go.docusign.com/o/trial/");

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Alan");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Alan@gmail..com");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123123123");
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("QA/QC");

        WebElement industryElement = driver.findElement(By.xpath("//*[@name='ds_industry']"));
        Select industryDropdown = new Select(industryElement);
        industryDropdown.selectByValue("Education");
    }

}
