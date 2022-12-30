package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class notasyonlar {
    WebDriver driver;
   // String https="https://www.";
    @Before
    public void SetUp(){
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
    public void test01(){

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test02(){
      //  driver.get(https+"wisequarter.com");

        driver.get("https://www.google.com");
    }
}
