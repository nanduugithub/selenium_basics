package org.selenium.commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    WebDriver driver;
    public void browser(String b){
        if (b.equals("Chrome")){
            driver= new ChromeDriver();

        } else if (b.equals("Edge")) {
            driver=new EdgeDriver();

        } else if (b.equals("Firefox")) {
            driver=new FirefoxDriver();

        }  else {
            throw new RuntimeException("Invalid");
        }
            driver.manage().window().maximize();


    }

    public void closeBrowser(){
        driver.close();
    }
    @BeforeMethod
    public void setup(){
        browser("Chrome");
    }
    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }

}
