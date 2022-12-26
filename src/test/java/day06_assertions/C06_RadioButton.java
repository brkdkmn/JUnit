package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");
        // b. Cookies’i kabul edin
        driver.manage().deleteAllCookies();
        //c. Create an account buton’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //d.telefon numaranizi gonderin
        WebElement telNumber=driver.findElement(By.xpath("//input[@name='reg_email__']"));
        telNumber.sendKeys("12356892578"+ Keys.ENTER);
        //e. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement radioButton=driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        radioButton.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        radioButton.click();
        Thread.sleep(2000);
        //f. Daha fazla yazisina gidin
        driver.findElement(By.id("non-users-notice-link")).click();
        Thread.sleep(3000);


    }





}
