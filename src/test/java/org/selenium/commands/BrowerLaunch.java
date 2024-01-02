package org.selenium.commands;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BrowerLaunch {
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
        //driver.close();
        driver.quit();
    }
    @BeforeMethod
    public void setup(){
        browser("Chrome");
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE){
            takeScreenshot(result);
        }
        closeBrowser();
    }

    public void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File screenshot=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("./Screenshots/"+result.getName()+".png"));

    }

}
