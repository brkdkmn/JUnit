package day08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedsayfaYazisi = "Opening a new window";

        String actualsayfayazisi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedsayfaYazisi,actualsayfayazisi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedSayfaTitle="The Internet";
        String actualSayfaTitle= driver.getTitle();
        String ilkSayfahandleDegeri= driver.getWindowHandle();
        Assert.assertEquals(expectedSayfaTitle,actualSayfaTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        /*
          Kontrolsuz acilan tab'a gecis yapmak icin
          1- ilk sayfada iken o sayfanin whd alip kaydedin
          2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
             acik olan tum sayfalarin wh degerlerini bir set olarak kaydedin
          3 - su anda elimizde 2 elementli bir set var
              elementlerden bir tanesi 1.sayfanin whd
              1.sayfanin whd'ine esit olmayan ise 2.sayfanin whd degeri olur
           4 -Bu sekilde 2.sayfanin whd elde edildikten sonra
           whd'leri kullanarak sayfalar arasinda gecis yapilabilir
         */

        Set<String> tumDegerlerIse=driver.getWindowHandles();

        String ikinciSayfaWHD="";
        for (String eachWhd: tumDegerlerIse
             ) {
            if (!eachWhd.equals(ilkSayfahandleDegeri)){
                ikinciSayfaWHD=eachWhd;
            }
        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedNewSayfaTitle="New Window";
        String actualNewSayfaTitle= driver.getTitle();
        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedyeniSayfaYazi="New Window";
        String actualyeniSayfaYazi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedyeniSayfaYazi,actualyeniSayfaYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfahandleDegeri);
        expectedSayfaTitle="The Internet";
        actualSayfaTitle=driver.getTitle();
        Assert.assertEquals(expectedSayfaTitle,actualSayfaTitle);

        Thread.sleep(3000);
    }
}
