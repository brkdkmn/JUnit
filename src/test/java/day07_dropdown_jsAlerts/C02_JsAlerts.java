package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {


       //  Gerekli ayarlamaları yapıp
       //  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
       // 3 test methodu olusturup her method'da bir JsAlert'e basın
      //  ilgili method'ları kullanın

        static WebDriver driver;

        @BeforeClass
        public static  void setUp(){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        @AfterClass
        public static void teardown(){
                driver.close();
        }
        @Test
        public void test01() throws InterruptedException {
                driver.get("https://the-internet.herokuapp.com/javascript_alerts");
                // 1.alerte tiklayalim
                driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
                // Alertteki yazinin "i am a Js Alert " oldugunu test edin

                driver.switchTo().alert().getText();
                String actualAlertYasizi=driver.switchTo().alert().getText();
                String expectedalertYazisi="I am a JS Alert";
                Thread.sleep(3000);
                Assert.assertEquals(expectedalertYazisi,actualAlertYasizi);


                // Ok tusuna basip alerti kapatalim
                driver.switchTo().alert().accept();
        }
        @Test
        public void test02() throws InterruptedException {
                driver.get("https://the-internet.herokuapp.com/javascript_alerts");
                // 2.alerte tiklayalim
                driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

                // cansele basip, cikan sonuc yazisinin You clicked: "Cancel" oldugunu test edelim
                Thread.sleep(3000);
                driver.switchTo().alert().dismiss();

                String actualyazisi=driver.findElement(By.xpath("(//p[@id='result'])[1]")).getText();
                Thread.sleep(3000);

                String expectedSonucYazisi="You clicked: Cancel";
                Assert.assertEquals(expectedSonucYazisi,actualyazisi);

        }
        @Test
        public void test03() throws InterruptedException {
                driver.get("https://the-internet.herokuapp.com/javascript_alerts");
                // 3.alerte tiklayalim
                driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

                // cikan prompt ekranina "Burak" yazdiralim ve Ok tusuna basarak alerti kapatalim
                driver.switchTo().alert().sendKeys("Burak");
                Thread.sleep(3000);
                driver.switchTo().alert().accept();

                //cikan sonuc yazisinin Burak icerdigini test edelim
                String actualyazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();
                String expectedkelime="Burak";
                Assert.assertTrue(actualyazisi.contains(expectedkelime));
                Thread.sleep(3000);

        }



}
