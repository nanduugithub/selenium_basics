package org.selenium.commands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
        WebElement actualUserLoginElement = driver.findElement(By.className("account"));
        String actualId = actualUserLoginElement.getText();
        String expectedLoginId = "nanduvs01@gmail.com";
        Assert.assertEquals(actualId, expectedLoginId, "user login failed");

    }

    @Test
    public void verifyDemoToursRegistration() {
        driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("nandu");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("vs");
        WebElement phoneNum = driver.findElement(By.name("phone"));
        phoneNum.sendKeys("07025985324");
        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys("nanduvs01@gmail.com");
        WebElement addressField = driver.findElement(By.name("address1"));
        addressField.sendKeys("attingal");
        WebElement cityName = driver.findElement(By.name("city"));
        cityName.sendKeys("trivandrum");
        WebElement stateName = driver.findElement(By.name("state"));
        stateName.sendKeys("kerala");
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("659605");
        WebElement userNameField = driver.findElement(By.id("userName"));
        userNameField.sendKeys("nandu");
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("123456");
        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
        confirmPassword.sendKeys("123456");
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();

    }

    @Test
    public void verifyLinkedAndPartialLink() {
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement yourDestination = driver.findElement(By.linkText("your destination"));
        yourDestination.click();
    }

    @Test
    public void verifyPartialLInk() {
        driver.get("https://demo.guru99.com/selenium/newtours/");
        WebElement destination = driver.findElement(By.partialLinkText("destination"));
        destination.click();
    }

    @Test
    public void validateDemoWebShopUserLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        email.sendKeys("nanduvs01@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        password.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        String actualId = actualUserLoginElement.getText();
        String expectedLoginId = "nanduvs01@gmail.com";
        Assert.assertEquals(actualId, expectedLoginId, "user Login failed");
    }

    @Test
    public void validateDemoWebShopSelector() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
        login.click();
        WebElement email = driver.findElement(By.cssSelector("#Email"));
        email.sendKeys("nanduvs01@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
        String actualId = actualUserLoginElement.getText();
        String expectedLoginId = "nanduvs01@gmail.com";
        Assert.assertEquals(actualId, expectedLoginId, "user Login failed");
    }

    @Test
    public void validateTotalNumOfTagInApplication() {
        driver.get("https://demowebshop.tricentis.com/");
        List<WebElement> inputWebElement = driver.findElements(By.tagName("Input"));
        int size = inputWebElement.size();
        System.out.println("total no of input tag in UI is " + size);
    }

    @Test
    public void validateDemoWebShopNavigate() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
        firstName.sendKeys("nandu");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='LastName']"));
        lastName.sendKeys("V S");
        WebElement email = driver.findElement(By.xpath("//input[@name='Email']"));
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
        Assert.assertFalse(isMaleSelected, "checkbox is selected");
        System.out.println("gender male before selected" + isMaleSelected);
        male.click();
        isMaleSelected = male.isSelected();
        Assert.assertTrue(isMaleSelected, "checkbox is not selected");
        System.out.println("gender after selected" + isMaleSelected);
    }

    @Test
    public void verifyIsEnabled() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeButton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
        boolean isSubscribeButtonEnabled = subscribeButton.isEnabled();
        Assert.assertTrue(isSubscribeButtonEnabled, "subscribe button is not enabled");
    }

    @Test
    public void verifyIsDisplayed() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        boolean isVoteButtonDisplayed = voteButton.isDisplayed();
        Assert.assertTrue(isVoteButtonDisplayed, "vote button not displayed");
    }

    @Test
    public void verifyCommunityPoll() {
        driver.get("https://demowebshop.tricentis.com/");
        List<WebElement> communityPoll = driver.findElements(By.xpath("//li[@class='answer']//label[starts-with(@for,'pollanswers')]"));
        for (WebElement obj : communityPoll) {
            String poll = obj.getText();
            if (poll.equals("poor")) {
                System.out.println(obj.getText());
                obj.click();
            }
        }
    }

    @Test
    public void verifyValueSelectFromDropDown() {
        driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        //select.selectByVisibleText("INDIA");
        //select.selectByIndex(23);
        select.selectByValue("ARGENTINA");
        WebElement selectedCountry = select.getFirstSelectedOption();
        System.out.println(selectedCountry.getText());
    }

    @Test
    public void verifyTotalNumberOfDropDownValues() {
        driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropDown);
        List<WebElement> dropDownElements = select.getOptions();
        System.out.println(dropDownElements.size());
    }

    @Test
    public void verifyMultiSelectDropDown() {
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        WebElement multiSelect = driver.findElement(By.xpath("//select[@name='selenium_commands']"));
        Select select = new Select(multiSelect);
        boolean selectedValue = select.isMultiple();
        System.out.println(selectedValue);
        select.selectByVisibleText("Navigation Commands");
        select.selectByVisibleText("Browser Commands");
        List<WebElement> selectedValues = select.getAllSelectedOptions();
        for (WebElement e : selectedValues) {
            System.out.println(e.getText());
        }
        select.deselectByVisibleText("Browser Commands");
    }

    @Test
    public void verifyFileUpload() {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFile.sendKeys("C:\\Users\\user\\IdeaProjects\\selenium_basics\\src\\main\\resources\\selenium.docx");
        WebElement acceptField = driver.findElement(By.xpath("//input[@type='checkbox']"));
        acceptField.click();
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='button']"));
        submitButton.click();
    }

    @Test
    public void verifyTestInSubscribeButton() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeButton = driver.findElement(By.id("newsletter-subscribe-button"));
        String subscribeButtonTest = subscribeButton.getAttribute("value");
        String expectedResult = "Subscribe";
        Assert.assertEquals(subscribeButtonTest, expectedResult, "invalid test found in subscribe button");
    }

    @Test
    public void verifySimpleAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.id("alertButton"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }

    @Test
    public void validateConfirmationAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.id("confirmButton"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement confirmationResult = driver.findElement(By.id("confirmResult"));
        String actualResult = confirmationResult.getText();
        Assert.assertEquals(actualResult, "You selected Cancel", "invalid text found");
    }

    @Test
    public void validatePromptAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.id("promtButton"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("nandu");
        alert.accept();
        WebElement promptResult = driver.findElement(By.id("promptResult"));
        String actualResult = promptResult.getText();
        Assert.assertEquals(actualResult, "You entered nandu", "invalid alert found");

    }

    @Test
    public void validateCustomerDelete() {
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        WebElement customerID = driver.findElement(By.xpath("//input[@type='text']"));
        customerID.sendKeys("1234");
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualResult=alert.getText();
        Assert.assertEquals(actualResult,"Customer Successfully Delete!","not deleted");
        alert.accept();


    }
}

