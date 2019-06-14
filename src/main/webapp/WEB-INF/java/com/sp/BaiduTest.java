package com.sp;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import com.sp.util.readExcelByPoi;
import com.sp.readProperties;

public class BaiduTest {

    @DataProvider(name="testdata")
    public static Object[][] readExcelData() throws InvalidFormatException,IOException {
        String filepath=System.getProperty("user.dir")+"/data/test.xlsx";
        Object[][] results = readExcelByPoi.readExcelData(filepath);
        return  results;
    }

    @Test(dataProvider = "testdata")
    public  void test(String keyVa,String testurl,String description)  throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(description);
        ChromeDriver driver =new ChromeDriver();
        driver.get(readProperties.readPro("testurl","syst"));
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
//        baiduSearch.baiduSearch(driver,keyVa);
        driver.findElement(By.id("kw")).click();
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys(keyVa);

        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}





















