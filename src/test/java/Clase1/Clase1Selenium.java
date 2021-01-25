package Clase1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.testng.annotations.Test;

import java.util.List;

//declarar variables para levantar instancias
public class Clase1Selenium {
    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    //Crear un método que abra el browser y muestre el explorador de google con chrome
    public void Ejercicio1(){
        WebDriver driver = getDriver("https://www.facebook.com");
    }

    @Test
    //EJ2: Crear un método llamado mostrarTituloTest, que muestre el título del sitio web.
    public void mostrarTituloTest(){
        WebDriver driver = getDriver("https://www.facebook.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    //EJ3: Crear un método llamado bbcMundo
    public void bbcMundo(){
        WebDriver driver = getDriver("https://www.bbc.com/mundo");

        System.out.println("El titulo del sitio es " + driver.getTitle());
        System.out.println("La url del sitio es " + driver.getCurrentUrl());

        //Mostrar la cantidad de <h1> y de párrafos que hay en el sitio
        List<WebElement> listah1 = driver.findElements(By.tagName("H1"));
        System.out.println("Hay: "+listah1.size() + " H1's");
        for(WebElement elemento : listah1){
            System.out.println("H1 ->"+elemento.getText());
        }

        //Mostrar la cantidad de <h2>
        List<WebElement> listah2 = driver.findElements(By.tagName("H2"));
        System.out.println("Hay: "+listah2.size() + " H2's");

        //Imprimir 3 títulos h2
        System.out.println("Se imprimiran 3 H2's: ");
        for(int i=0; i < 3; i++){
            System.out.println(listah2.get(i).getText());
        }

        //Mostrar la cantidad de <h3>
        List<WebElement> listah3 =  driver.findElements(By.tagName("H3"));
        System.out.println("Hay: "+listah3.size()+ " H3's");

        //Imprimir 3 títulos h3
        System.out.println("Se imprimiran 3 H3's: ");
        for(int i=0; i<3; i++){
            System.out.println(listah3.get(i).getText());
        }

        //Maximizar la página
        //Refrescarla
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.close();

    }

    @Test
    //EJ4: Crear un método llamado bbcMundoLinks
    public void bbcMundoLinks() {
        WebDriver driver = getDriver("https://www.bbc.com/mundo");

        System.out.println("El titulo del sitio es " + driver.getTitle());
        System.out.println("La url del sitio es " + driver.getCurrentUrl());

        //mostrar el texto de todos los link´s
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        for (WebElement link : listaLinks){
            System.out.println("Link: " + link.getText());
        }
    }

    @Test
    //EJ5: Crear un método llamado bbcMundoListas
    public void bbcMundoListas(){
        WebDriver driver = getDriver("https://www.bbc.com/mundo");

        //mostrar todos los elementos li y su texto
        List<WebElement> listali =driver.findElements(By.tagName("li"));
        for (WebElement lista : listali){
            System.out.println("Elementos Li: "+ lista.getText());
        }
        driver.close();
    }

    @Test
    //EJ6: Crear método llamado spotifyTitleTest
    public void spotifyTitleTest(){
        WebDriver driver =getDriver("https://www.spotify.com");

        String title = driver.getTitle();

        if (title.equals("Escuchar es todo - Spotify")) {
            System.out.println("Test Passed!!!");
        }else {
            System.out.println("Test Failed");
        }
    }

    @Test
    //EJ7: Crear un método llamado getWindowsSizeTest
    public void getWindowsSizeTest(){
        WebDriver driver =getDriver("https://www.google.com");

        //obtener y mostrar el ancho y alto de la página
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        System.out.println("El largo actual es " + height);
        System.out.println("El ancho actual es " + width);

        //Setear  dimension
        Dimension dimension = new Dimension( 1024, 768);
        driver.manage().window().setSize(dimension);
        System.out.println("Actualizando ancho y  largo");

        //obtener y mostrar el ancho y alto seteado de la página
        height = driver.manage().window().getSize().getHeight();
        width = driver.manage().window().getSize().getWidth();

        System.out.println("El largo actual es " + height);
        System.out.println("El ancho actual es " + width);
    }

    @Test
    //EJ8: Crear un método llamado getGoogleDriver que inicialice un sitio web www.google.com. Debe
    //retornar un objeto de tipo Webdriver
    public WebDriver getGoogleDriver(){
        WebDriver driver = getDriver("http://www.google.com");
        return driver;
    }

    @Test
    //EJ9: Crear un método llamado getDriver que inicialice un sitio web que recibe por parámetro. Debe
    //retornar un objeto de tipo Webdriver
    public WebDriver getDriver2(String URL){
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    //EJ10: Crear un método llamado searchInGoogle
    public void searchInGoogle(){
        //acceder a google
        WebDriver driver = getDriver("https://www.google.com");

        //buscar la palabra "WebElement" y presionar Enter
        driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);
    }

    @Test
    //EJ11: Crear un método llamado searchInGoogleAndGoBack
    public void searchInGoogleAndGoBack(){
        //acceder a google
        WebDriver driver = getDriver("https://www.google.com");

        //Imprimir el titulo del sitio
        System.out.println("El titulo del sitio es " + driver.getTitle());

        //Buscar: selenium driver
        driver.findElement(By.name("q")).sendKeys("selenium driver" + Keys.ENTER);

        //Volver Atras
        driver.navigate().back();

        //Refrescar pagina
        driver.navigate().refresh();

        //ir hacia adelante
        driver.navigate().forward();
    }

    @Test
    //EJ12: Crear un método llamado facebookPageTest
    public void facebookPageTest(){

        //Abrir un navegador con facebook: https://www.facebook.com/
        WebDriver driver  = getDriver("https://www.facebook.com/");

        //Mostrar la cantidad de div que existen (utilizando tagname)
        List<WebElement> div = driver.findElements(By.tagName("div"));
        System.out.println("Hay: "+div.size() + " div");

        //Mostrar el texto de todos los tipos a (hipervínculos)
        List<WebElement> hipervinculo = driver.findElements(By.tagName("a"));
        for (WebElement link: hipervinculo) {
            System.out.println("Link: " + link.getText());
        }

        //Mostrar la cantidad de botones que tiene la página
        List<WebElement> boton = driver.findElements(By.tagName("button"));
        System.out.println("Hay: "+boton.size() + " Botones");

        //Mostrar los textos de los botones que se encuentran en la página
        for (WebElement btn: boton) {
            System.out.println("Btn: " + btn.getText());
        }
    }

    @Test
    //EJ13: Crear un metodo de test llamado sendKeysToFacebook
    public void sendKeysToFacebook(){
        
    }
}
