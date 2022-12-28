package random;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class S7_HandleDropdown2 {
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
        //driver.close();
    }
    @Test
    public void DropDown() throws InterruptedException {
        //Bir class oluşturun: DropDown
       // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
       // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(1000);
       // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(1000);

       // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(1000);
       // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumDropdownoption=select.getOptions();
        for (WebElement each:tumDropdownoption
             ) {
            System.out.println(each.getText());
        }
       // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,

        int option = tumDropdownoption.size();
        System.out.println(option);

       // degilse False yazdırın.
        Assert.assertFalse(option>4);

    }
}
