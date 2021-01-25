package Clase15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelefonicaTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver  = new ChromeDriver();
        driver.get("https://www.telefonica.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public  void telefonicaCotizacionesTest(){
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.telefonica.com/es/home");
        Assert.assertEquals(driver.getTitle(),"Telefónica");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //me posiciono en el iframe
        driver.switchTo().frame("euroland-ticker-es");

        List<WebElement> tabsList = driver.findElements(By.className("Tab"));
        Assert.assertEquals(tabsList.size(),2);

        for(WebElement tab: tabsList){
            System.out.println("--> " + tab.getText());
            if (tab.getText().equals("NYSE")){
                tab.click();
            }
        }

        WebElement activeTab = driver.findElement(By.className("Tab_Active"));
        Assert.assertEquals(activeTab.getText(),"NYSE");

        List<WebElement> dataItemsList = driver.findElements(By.className("DataItem"));
        List<WebElement> dataValuesList = driver.findElements(By.className("DataValue"));

        Assert.assertEquals(dataItemsList.size(),6);
        Assert.assertEquals(dataValuesList.size(),6);

        for(WebElement di: dataItemsList){
            System.out.println("-***  "+di.getText());
        }

        for(WebElement dv: dataValuesList){
            System.out.println("-***  "+dv.getText());
        }
    }


}
