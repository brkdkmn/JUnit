package random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBase;

public class S11_Actions extends TestBase {
    @Test
    public void test01(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoveroverMeFirstKutusu= driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        actions.moveToElement(hoveroverMeFirstKutusu).perform();
        ReusableMethods.bekle(2);
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        ReusableMethods.bekle(2);
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        actions.sendKeys(Keys.PAGE_DOWN);
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickandHold= driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
        actions.clickAndHold(clickandHold).perform();
        ReusableMethods.bekle(2);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
         System.out.println(clickandHold.getText());
        ReusableMethods.bekle(2);
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleclickMe= driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleclickMe).perform();
        ReusableMethods.bekle(2);
    }
}
