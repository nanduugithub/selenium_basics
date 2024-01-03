package testngcommands;

import automationcore.Base;
import dataprovider.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ExcelUtility;

import java.util.ArrayList;

public class LoginPageTest extends Base {
    @Test(priority = 5)
    public void verifyLoginPageTitle(){
        WebElement loginField= driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        String actualPageTitle= driver.getTitle();
        ArrayList<String>data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH,Constants.LOGIN_PAGE);
        String expectedResult= data.get(1);
        Assert.assertEquals(actualPageTitle,expectedResult, Messages.TITLE_MISMATCH);
    }
    @Test(priority = 6)
    public void verifyUserLogin(){
        WebElement loginField= driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        WebElement emailField= driver.findElement(By.xpath("//input[@class='email']"));
        emailField.sendKeys("nanduvs01@gmail.com");
        WebElement passwordField= driver.findElement(By.xpath("//input[@class='password']"));
        passwordField.sendKeys("123456");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement loggedAccount= driver.findElement(By.xpath("//a[@class='account']"));
        String actualResult=loggedAccount.getText();
        String expectedResult="nanduvs01@gmail.com";
        Assert.assertEquals(actualResult,expectedResult,Messages.LOGIN_FAILED);
    }

    @Test(priority = 7,dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
    public void verifyUserLoginWithInvalidValidation(String username,String  password)  {
        WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        emailField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement actualMessage = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        String actualMessageText = actualMessage.getText();
        String expectedMessageText = data.get(6);
        Assert.assertEquals(actualMessageText, expectedMessageText, Messages.LOGIN_FAILED_WARNINGMESSAGE_NOTFOUND);
}

}

