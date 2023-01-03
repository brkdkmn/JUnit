package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class N2 extends TestBase {

    @Test
     public void test01(){

           // https://www.automationexercise.com/ sayfasina gidelim
        driver.get("https://www.automationexercise.com/");
          // signUp linkine tiklayalim
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String expected="https://www.automationexercise.com/login";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(expected,actual);
         // name ve email adress kismina bilgiler gondererek uye olalim
        WebElement name=driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("burak");
        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        email.sendKeys("burakkk@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        // uye olundugunu test edelim
        WebElement enterAccountText= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountText.isDisplayed());
    }


    @Test
    public void olumsuzSenaryo(){
        driver.get("https://www.automationexercise.com/");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        WebElement name=driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("bk");
        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        email.sendKeys("burakkk.gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        WebElement newUserElementi= driver.findElement(By.tagName("h2"));
        Assert.assertTrue(newUserElementi.isDisplayed());

    }
}
