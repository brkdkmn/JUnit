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

public class S5_Ornek {

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
    public void test() throws InterruptedException {
       // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
       // 2. Sign in butonuna basin
        driver.findElement(By.xpath("(//button[@id='signin_button'])[1]")).click();
       // 3. Login kutusuna “username” yazin
        WebElement loginKutusu= driver.findElement(By.xpath("//input[@name='user_login']"));
        loginKutusu.sendKeys("username");
       // 4. Password kutusuna “password” yazin
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");
       // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement moreServices=driver.findElement(By.xpath("//a[@id='online-banking']"));
        moreServices.click();
       // 6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        Thread.sleep(2000);
       // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();
       // 8. “Currency” drop down menusunden Mexico’u secin
        WebElement mexico= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(mexico);
        select.selectByVisibleText("Mexico (peso)");
        Thread.sleep(2000);
       // 9. “amount” kutusuna bir sayi girin
        WebElement amauntKutusu= driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amauntKutusu.sendKeys("200");
      // 10. “US Dollars” in secilmedigini test edin
        WebElement usDollars=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollars.isSelected());
        Thread.sleep(2000);
       // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(2000);
      // 12. “Calculate Costs” butonuna basin sonra "purchase" butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(2000);
       // driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(2000);
        //driver.switchTo().alert().dismiss();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement sonuc=driver.findElement(By.xpath("//div[@id='alert_content']"));
        sonuc.isDisplayed();
        // 14. “username” butonuna basin ve cikis yapin
        WebElement username= driver.findElement(By.xpath("(//li[@class='dropdown'])[2]"));
        username.click();
        Thread.sleep(2000);
        driver.findElement(By.id("logout_link")).click();
        Thread.sleep(2000);


    }
}
