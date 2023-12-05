package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Commands extends Base {

    @Test
    public void verifySwagLabsUserLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passWordField = driver.findElement(By.id("password"));
        passWordField.sendKeys("secret_sauce");
        WebElement loginButtonField = driver.findElement(By.id("login-button"));
        loginButtonField.click();
        WebElement swagLogo = driver.findElement(By.className("app_logo"));
        String actualswagLogoText = swagLogo.getText();
        String expectedSwagLogoText = "Swag Labs";
        Assert.assertEquals(actualswagLogoText, expectedSwagLogoText, "Invalid Logo found in login page");

    }

    @Test
    public void verifyDemoWebShopUserLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("nanduvs01@gmail.com");
        WebElement passWordField = driver.findElement(By.id("Password"));
        passWordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        WebElement actualUserLoginElement= driver.findElement(By.className("account"));
        String actualId=actualUserLoginElement.getText();
        String expectedLoginId="nanduvs01@gmail.com";
        Assert.assertEquals(actualId,expectedLoginId,"user login failed");

    }
    @Test
    public void verifyDemoToursRegistration(){
        driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("nandu");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("vs");
        WebElement phoneNum= driver.findElement(By.name("phone"));
        phoneNum.sendKeys("07025985324");
        WebElement eMail= driver.findElement(By.id("Email"));
        eMail.sendKeys("nanduvs01@gmail.com");
        WebElement addressField= driver.findElement(By.name("address1"));
        addressField.sendKeys("attingal");
        WebElement cityName=driver.findElement(By.name("city"));
        cityName.sendKeys("trivandrum");
        WebElement stateName=driver.findElement(By.name("state"));
        stateName.sendKeys("kerala");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("659605");
        WebElement userNameField=driver.findElement(By.id("userName"));
        userNameField.sendKeys("nandu");
        WebElement passWord=driver.findElement(By.name("password"));
        passWord.sendKeys("123456");
        WebElement confirmPassword=driver.findElement(By.name("confirmPassword"));
        confirmPassword.sendKeys("123456");
        WebElement submitButton=driver.findElement(By.name("submit"));
        submitButton.click();

    }

    @Test
    public void verifyLinkedAndPartialLink(){
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement yourDestination=driver.findElement(By.linkText("your destination"));
        yourDestination.click();
    }
    @Test
    public void verifyPartialLInk(){
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement destination= driver.findElement(By.partialLinkText("destination"));
        destination.click();
    }
    @Test
    public void validateDemoWebShopUserLogin(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        login.click();
        WebElement email= driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        email.sendKeys("nanduvs01@gmail.com");
        WebElement password=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        password.sendKeys("123456");
        WebElement loginButton= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();
        WebElement actualUserLoginElement= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        String actualId= actualUserLoginElement.getText();
        String expectedLoginId="nanduvs01@gmail.com";
        Assert.assertEquals(actualId,expectedLoginId,"user Login failed");
    }
    @Test
    public void validateDemoWebShopSelector(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login= driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
        login.click();
        WebElement email= driver.findElement(By.cssSelector("#Email"));
        email.sendKeys("nanduvs01@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("123456");
        WebElement loginButton= driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
        loginButton.click();
        WebElement actualUserLoginElement= driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
        String actualId= actualUserLoginElement.getText();
        String expectedLoginId="nanduvs01@gmail.com";
        Assert.assertEquals(actualId,expectedLoginId,"user Login failed");
    }
    @Test
    public void validateTotalNumOfTagInApplication(){
        driver.get("https://demowebshop.tricentis.com/");
        List<WebElement> inputWebElement=driver.findElements(By.tagName("Input"));
        int size= inputWebElement.size();
        System.out.println("total no of input tag in UI is "+size);
    }
@Test
    public void validateDemoWebShopNavigate(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement register=driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement firstName= driver.findElement(By.xpath("//input[@name='FirstName']"));
        firstName.sendKeys("nandu");
        WebElement lastName= driver.findElement(By.xpath("//input[@name='LastName']"));
        lastName.sendKeys("V S");
        WebElement email= driver.findElement(By.xpath("//input[@name='Email']"));
        email.sendKeys("nanduvs01@gmail.com");
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/");
}
@Test
public void verifyIsSelected() {
    boolean isMaleSelected;
    driver.get("https://demowebshop.tricentis.com/register");
    WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
    isMaleSelected = male.isSelected();
    Assert.assertFalse(isMaleSelected,"checkbox is selected");
    System.out.println("gender male before selected" + isMaleSelected);
    male.click();
    isMaleSelected = male.isSelected();
    Assert.assertTrue(isMaleSelected,"checkbox is not selected");
    System.out.println("gender after selected" + isMaleSelected);
}
}
