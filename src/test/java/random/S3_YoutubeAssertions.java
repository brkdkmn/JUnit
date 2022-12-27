package random;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S3_YoutubeAssertions {
           // 1) Bir class oluşturun: YoutubeAssertions
           // 2) https://www.youtube.com adresine gidin
           // 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
           //  ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
           //  ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
           //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
           //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void titleTest(){
        String expected = "YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expected));
    }
    @Test
    public void imageTest() throws InterruptedException {
        WebElement logo= driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(1000);
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        String expected = "youtube";
        String actualTitle= driver.getTitle();
       Assert.assertNotEquals(expected,actualTitle);
    }

}
