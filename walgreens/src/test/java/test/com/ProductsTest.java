/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author giril
 */
public class ProductsTest {

    private WebDriver driver;
    private String baseUrl;

    public ProductsTest() {
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
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testProductSearchTestcase() throws Exception {
        List<ProductVO> productlist = FileUtil.loadData();
        for (int i = 0; i < productlist.size(); i++) {
            testEachProduct(productlist.get(i));
        }
        driver.quit();
    }

    public void testEachProduct(ProductVO productVO) {
        driver.get("https://www.walgreens.com/");
        driver.findElement(By.id("ntt-placeholder")).click();
        driver.findElement(By.id("ntt-placeholder")).clear();
        driver.findElement(By.id("ntt-placeholder")).sendKeys(productVO.getProductname());
        driver.findElement(By.cssSelector(".input__search-contain")).submit();
        driver.findElement(By.id("ntt-placeholder")).click();
    }
}
