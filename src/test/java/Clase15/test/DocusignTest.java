package Clase15.test;

import Clase15.DocusignObjects.DocusignLandingPage;
import Clase15.DocusignObjects.DocusignRegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DocusignTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver  = new ChromeDriver();
        driver.get("https://www.docusign.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void docusignTest(){
        DocusignLandingPage docusignLandingPage = new DocusignLandingPage(driver);

        Assert.assertEquals(docusignLandingPage.getTitle(), "DocuSign | #1 in Electronic Signature and Agreement Cloud");
        Assert.assertEquals(docusignLandingPage.getCurrentUrl(), "https://www.docusign.com/");
        DocusignRegistrationPage docusignRegistrationPage = docusignLandingPage.clickFreeTrialBtn();


        Assert.assertEquals(docusignRegistrationPage.getTitle(), "DocuSign Free Trial");
        Assert.assertEquals(docusignRegistrationPage.getCurrentUrl(), "https://go.docusign.com/o/trial/");

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        docusignRegistrationPage.fillingRegistrationFields();
        docusignRegistrationPage.clickOnGetStartBtn();
    }
}
