package com.sp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SeleniumMainTest {

    @Test
    public  void test(String keyVa,String testurl)  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        ChromeDriver driver =new ChromeDriver();
        driver.get(testurl);
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
//        Dimension size = new Dimension(320,480);
//        driver.manage().window().setSize(size);
        driver.findElement(By.id("kw")).click();
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys(keyVa);
        //cookies 的添加 获得 删除
        Cookie c1 = new Cookie("BDUSS","klpVE5wQ2p2SGR1SDNDWUVtYXdLdWxUamtWTn56MHpnfmplSjlSZXM2eTJLaWhkSVFBQUFBJCQAAAAAAAAAAAEAAABWqTQ3ztLDx7XEMzMxMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAALadAF22nQBdM");
        driver.manage().addCookie(c1);
        driver.get(testurl);
        System.out.println(driver.manage().getCookieNamed("BDUSS"));
        driver.get(testurl);
        driver.manage().deleteAllCookies();
        driver.get(testurl);
//        List<WebElement> els = driver.findElements(By.cssSelector("input[type=checkbox]"));
//        els.get(els.size()-1);
//        for (WebElement e1:els)
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();
//        alert.accept();
        Thread.sleep(3000);
        driver.quit();
    }
}
