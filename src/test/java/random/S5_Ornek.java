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
        amauntKutusu.sendKeys("$200");
      // 10. “US Dollars” in secilmedigini test edin
        WebElement usDollars=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollars.isSelected());
        Thread.sleep(2000);
       // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(2000);
      // 12. “Calculate Costs” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(4000);
       // 13.  sonra “purchase” butonuna calismadigindan geri donun verefresh edin
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
       // 14. “Account Summary” sayfasina gidin.
         driver.findElement(By.xpath("(//span[@class='headers'])[1]"));
        Thread.sleep(2000);
       //  15. "Pay Bills" 'e gidin.
         driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
        Thread.sleep(2000);
        // 15. "Account" drop down menusunden Loan'i secin
        WebElement loan= driver.findElement(By.xpath("//select[@id='sp_account']"));
        Select select1=new Select(loan);
        select1.selectByVisibleText("Loan");
        Thread.sleep(2000);
        // 16. "Pay" butonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(2000);

    }
}
