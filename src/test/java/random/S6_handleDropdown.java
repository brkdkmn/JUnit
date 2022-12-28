package random;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class S6_handleDropdown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test1(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // arama kutusu yanindaki dropdown menuden Computers secin
        WebElement ddmenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddmenu);
        select.selectByVisibleText("Computers");
        // arama kutusuna Asus laptop yazdirip aramayi yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Asus laptop"+ Keys.ENTER);
        // title'in Asus laptop icerdigini test edin
        String actualTitle= driver.getTitle();
        String expected="Asus laptop";
        Assert.assertTrue(actualTitle.contains(expected));
        // dropdown menuden Asus laptop seceneginin secildigini test edin
        ddmenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(ddmenu);
        select.selectByVisibleText("Computers");
        String actualSecilenOption=select.getFirstSelectedOption().getText();
        String expectedSecilecekOption="Computers";
        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);
        // Dropdown menudeki secenek sayisinin 25 olmadigini test edin
        List<WebElement> elemenListesi=select.getOptions();
        int actualOptionsayisi=elemenListesi.size();
        int expectedOptionsayisi=25;
        Assert.assertNotEquals("Dropdown menu sayisi:28",expectedOptionsayisi,actualOptionsayisi);

    }


}
