package day08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
    /*
       Selenium4 ile yeni gelen bir ozellik olarak, test sirasinda yeni bir tab veya window
       acilabilir.
       Istersek kontrollu olarak driver icin yeni bir window veya tab olusturabiliriz
       Bu durumda driver'imiz otomatik olarak yeni sayfaya gecmis olur

       Testin ilerleyen asamalarinda yeniden eski sayfalara donus gorevi varsa
       osayfada iken o sayfanin window handle degeri alinip kaydedilir
       ve o sayfaya gecmek istendiginde driver.switchTo().window(istenensayfaninwindowhandledegeri) yazilarak
       o sayfaya gecis yapilir
     */
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
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");

        Thread.sleep(3000);
        //testin ilerleyen asamalarinda yeniden amazon sayfasina donmek gerekiyorsa
        //amazon sayfasindayken bu window;un window handle degerini alip kaydetmeliyiz
        String ilksayfaHandleDegeri= driver.getWindowHandle();

       // String sonSayfa= driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve gittigimizi test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        String actuallUrl= driver.getCurrentUrl();
        String expectedUrl="wisequarter";
        Assert.assertTrue(actuallUrl.contains(expectedUrl));
        Thread.sleep(3000);

        //wisequarter testini yaptiktan sonra
        //yeniden amazon'un acik oldugu tab'a gecin
        //ve amazon anasayfasinin acik oldugunu test edin

        driver.switchTo().window(ilksayfaHandleDegeri);
        String actalUrl= driver.getCurrentUrl();
        String expected="amazon";
        Assert.assertTrue(actalUrl.contains(expected));
        Thread.sleep(3000);

       // driver.switchTo().window(sonSayfa);
        Thread.sleep(3000);
    }
}
