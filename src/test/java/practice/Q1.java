package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilies.ReusableMethods;
import utilies.TestBase;

public class Q1 extends TestBase {

    @Test
    public void test01(){

        //  http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");

        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String expectedTitle="Best";
        String actualTitle= driver.getTitle();
        //System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));


        //  Ayrica Relative Locator kullanarak;
        // logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement helloElementi= driver.findElement(By.xpath("//div[text()='Hello!']"));
        WebElement bestLogo= driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloElementi));
        Assert.assertTrue(bestLogo.isDisplayed());
        //  Ayrica Relative Locator kullanarak;
        //  mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
        WebElement chooseCountry= driver.findElement(By.tagName("h1"));
        WebElement mexbayrakElementi= driver.findElement(RelativeLocator.with(By.tagName("img")).below(chooseCountry));
        ReusableMethods.bekle(2);
        Assert.assertTrue(mexbayrakElementi.isDisplayed());


       // boolean goruntuleniyormMu= mexbayrakElementi.isDisplayed();
       // Assert.assertTrue(goruntuleniyormMu);
    }
}
