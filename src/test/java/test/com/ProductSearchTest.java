/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author giril
 */
public class ProductSearchTest {

    private WebDriver driver;
    private String baseUrl;

    public ProductSearchTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }

//    @Test
    public void testProductSearch() throws Exception {
        driver.get("https://www.walgreens.com/");
        driver.findElement(By.id("ntt-placeholder")).click();
        driver.findElement(By.id("ntt-placeholder")).clear();
        driver.findElement(By.id("ntt-placeholder")).sendKeys("Advil");
        driver.findElement(By.cssSelector(".input__search-contain")).submit();
        driver.findElement(By.id("secImgcompare_sku6247560")).click();
        driver.get("https://www.walgreens.com/store/c/advil-sinus-congestion-%26-pain-coated-tablets-10/ID=prod6293045-product");
        driver.findElement(By.xpath("//a[@id='receiveing-addToCartbtn']/strong")).click();
        driver.findElement(By.xpath("//a[@class='addtocart-cart-checkout']/span")).click();
        driver.get("https://www.walgreens.com/cart/view-ui");
        try {
            assertEquals(driver.findElement(By.id("wag-cart-proceed-to-checkout")).getText(), "Proceed to Checkout");
        } catch (Error e) {
            System.out.println(e.toString());
        }
        driver.quit();
    }

    //@Test
    public void testProductSearchTestcase() throws Exception {
        driver.get("https://www.walgreens.com/");
        driver.findElement(By.id("ntt-placeholder")).click();
        driver.findElement(By.id("ntt-placeholder")).clear();
        driver.findElement(By.id("ntt-placeholder")).sendKeys("advil");
        driver.findElement(By.cssSelector(".input__search-contain")).submit();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,650)", "");
        driver.findElement(By.id("prodTitleNamecompare_sku6247560")).click();
        driver.findElement(By.xpath("//a[@id='receiveing-addToCartbtn']/strong")).click();
        driver.findElement(By.xpath("//a[@id='addToCart-cart-checkout']/span")).click();
        try {
            assertEquals(driver.findElement(By.id("wag-cart-proceed-to-checkout")).getText(), "Proceed to Checkout");
        } catch (Error e) {
            System.out.println(e.toString());
        }
        driver.quit();
    }

    @Test
    public void logIn() throws Exception {
        driver.get("https://www.walgreens.com/");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Account'])[1]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("//a[@id='pf-dropdown-signin']/strong")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("user_name")).clear();
        driver.findElement(By.id("user_name")).sendKeys("seleniumjava@gmail.com");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("Seliniumjava@123");
        driver.findElement(By.id("user_name")).click();
        driver.findElement(By.id("submit_btn")).click();
        driver.quit();
    }

    @Test
    public void photopage() throws Exception {
        driver.get("https://www.walgreens.com/");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Menu'])[1]/following::*[name()='svg'][1]")).click();
        driver.findElement(By.xpath("//li[@id='menu-photo']/a/span[2]")).click();
        driver.findElement(By.xpath("//a[@id='photo_home']/strong")).click();
        driver.get("https://photo.walgreens.com/store/home");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)");
        try {
            assertEquals(driver.findElement(By.linkText("Shop Wall Décor")).getText(), "Shop Wall Décor");
        } catch (Error e) {
            System.out.println(e.toString());
        }
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testFindcare() throws Exception {
        driver.get("https://www.walgreens.com/");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='FREE Ship to Home No Minimum'])[1]/following::strong[1]")).click();
        driver.findElement(By.xpath("//li[@id='menu-find-care']/a/span[2]")).click();
        driver.findElement(By.xpath("//ul[@id='menu-ul-menu-find-care']/li[4]/a/span")).click();
        driver.findElement(By.linkText("All Vaccines")).click();
    }
}
