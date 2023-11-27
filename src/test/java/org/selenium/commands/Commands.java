package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        WebElement addressField= driver.findElement(By.name("address"));
        addressField.sendKeys("attingal");
        WebElement cityName=driver.findElement(By.name("city"));
        cityName.sendKeys("trivandrum");
        WebElement stateName=driver.findElement(By.name("state"));
        stateName.sendKeys("kerala");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("659605");
        WebElement userNameField=driver.findElement(By.id("userName"));
        userNameField.sendKeys("nandu");
        WebElement passWord=driver.findElement(By.id("passWord"));
        passWord.sendKeys("123456");
        WebElement confirmPassword=driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("123456");
        WebElement submitButton=driver.findElement(By.name("submit"));
        submitButton.click();

    }
}
