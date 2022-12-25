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
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;

import java.time.Duration;

public class S1_After_Before {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void teardown(){
       driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        // 1- https://www.vatanbilgisayar.com/adresine gidin ve cookiesleri kabul et
        driver.get("https://www.vatanbilgisayar.com/");
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//div[@class='banner-accept-button']"));
        // 2- Arama cubuguna "samsung" yazin
        WebElement aramaCubugu= driver.findElement(By.xpath("//input[@name='search']"));
        aramaCubugu.sendKeys("samsung" + Keys.ENTER);
        // 3- Cikan urun adedini  yazdirin
        WebElement urunadedi = driver.findElement(By.xpath("//div[@class='wrapper-detailpage-header__item-left']"));
        System.out.println("sonuc sayisi : " + urunadedi.getText());
        // 4- 5.urune tiklayin
        driver.findElement(By.xpath("(//a[@class='product-list__link'])[5]")).click();
        Thread.sleep(2000);
        // 5- Cikan 5. urunu sepete ekleyin
        driver.findElement(By.xpath("//button[@class='btn btn-success detail-cart-button basketBTN']")).click();
        Thread.sleep(2000);
        // 6- Sepete git'e tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-dark-blue goToBasket']")).click();
        // 7- Garanti belgesi ile ilgili bilgileri kapatin
        driver.findElement(By.xpath("//button[@id='closePop']")).click();
        Thread.sleep(1000);
       // 8- sepeti onaylayin
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-success input-lg basket-ordersummary__button continuebutton btn-arrow']")).click();
        // 9- sepete geri donun
        driver.findElement(By.xpath("//a[@class='btn btn-link']")).click();
        Thread.sleep(2000);
        // 10- en alttaki size ozel urunu ekleyin
        WebElement ozelUrun= driver.findElement(By.xpath("(//a[@id='btnBasket'])[4]"));
        ozelUrun.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        ozelUrun.click();






    }
}
