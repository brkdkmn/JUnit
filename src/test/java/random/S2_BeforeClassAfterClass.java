package random;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S2_BeforeClassAfterClass {
    // 3 ayri test method'u olusturun
    // 1.method'da https://www.arabam.com/ gidip, arabam.com'a gittigimizi test edin
    // 2.method'da arabam.com'da bisiklet aratip, anahtar kelimenin bisiklet icerdigini test edin
    // 3.method'da bisiklet arama sonuc sayisinin 50'den az oldugunu test edin

    static WebDriver driver;
    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass

    public static void teardown(){
        driver.close();
    }

    @Test
    public  void test01(){
       driver.get("https://www.arabam.com/");

       String expectedKelime = "arabam.com";
       String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedKelime)) {
            System.out.println("arabam.com test passed");
        }else{
            System.out.println("arabam.com test failed");
        }
    }

    @Test
    public void test02(){
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@*='onSearchInput']"));
        aramaKutusu.sendKeys("bisiklet"+ Keys.ENTER);
        String expectedKelime="bisiklet";
        WebElement anahtarKelime= driver.findElement(By.xpath("//span[@class='filter-value']"));
        String anahtarKelimeStr= anahtarKelime.getText();
        if (anahtarKelimeStr.contains(expectedKelime)) {
            System.out.println("bisiklet arama testi passed");
        }else{
            System.out.println("bisiklet arama test failed");
        }
    }

    @Test
    public void test03(){
        WebElement sonucSayisi= driver.findElement(By.xpath("//span[@class='bold pl4 fz13']"));
        String sonucYazisiStr=sonucSayisi.getText();
        String sonucAdetiStr="37";
        int actualSonucAdetiInt=Integer.parseInt(sonucAdetiStr);
        int expectedSonucsayisi=50;

        if (actualSonucAdetiInt<expectedSonucsayisi){
            System.out.println("Sonuc testi passed");
        }else {
            System.out.println("Sonuc testi failed");
        }

    }
}
