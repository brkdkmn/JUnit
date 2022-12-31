package practice;

import io.netty.util.internal.ResourcesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBase;

import java.awt.*;

public class Q2 extends TestBase {

    @Test
    public void test01(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaBaslik= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(anaBaslik.isDisplayed());


        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement actualContactUs=driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        Assert.assertTrue(actualContactUs.isDisplayed());

        //6. Enter name, email, subject and message
        WebElement firstNameTextBox= driver.findElement(By.xpath("//input[@name='name']"));
        Actions actions=new Actions(driver);
        actions.click(firstNameTextBox).sendKeys("Kaan").
                sendKeys(Keys.TAB).
                sendKeys("kaan@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("Otomasyon").
                sendKeys(Keys.TAB).
                sendKeys("HelloNew Year").perform();

        //7. Upload file
        WebElement uploadFile= driver.findElement(By.xpath("//input[@name='upload_file']"));
        String dosyaYolu=System.getProperty("user.home" )+ "\\Desktop\\Yeni Metin Belgesi.txt";
        uploadFile.sendKeys(dosyaYolu);
        //8. Click 'Submit' button
        driver.findElement(By.xpath("(//input[@name='submit'])[1]")).click();
        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement succesYazisi=driver.findElement(By.xpath("(//div[text()='Success! Your details have been submitted successfully.'])[1]"));
        Assert.assertTrue(succesYazisi.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeSayfa=driver.findElement(By.xpath("//a[text()=' Home']"));
        homeSayfa.click();

        Assert.assertTrue(homeSayfa.isDisplayed());





    }
}
