package random;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S4_Ornek {
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
    public void test01() throws InterruptedException {


       // - https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
       // - cookies uyarisini kabul ederek kapatin
       // WebElement cerezler = driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
       // cerezler.click();
       // -Sayfa basliginin "Google" ifadesi icerdigini test edin
        String expected="Google";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expected)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

       // if (driver.getTitle().contains("Google")){
          //  if (actualTitle.contains(expected)){
          //      System.out.println("Test passed");
          //  }else{
          //      System.out.println("Test failed");
          //  }
       // }
       // - Arama cubuguna "Masa" yazip aratin
        WebElement arabaCubugu = driver.findElement(By.xpath("(//input[@class='gLFyf'])[1]"));
        arabaCubugu.sendKeys("Masa"+ Keys.ENTER);
       // -Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.id("result-stats"));
       // - sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        //Yaklaşık 1.970.000.000 sonuç bulundu (0,50 saniye)
        String sonucSayisi=sonuc.getText();
        if (sonucSayisi.contains("10 milyondan fazla")){
            System.out.println("Test basarili: sonuc sayisi 10 milyondan fazla ");
        }else{
            System.out.println("Test basarisiz : sonuc syisi 10 milyondan az");
        }

        Thread.sleep(2000);
        // -Sayfayi kapatin


    }
}
