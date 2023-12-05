package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObsquraZoneTest extends Base{

    @Test
    public void verifySingleInputField(){
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterMessage= driver.findElement(By.xpath("//input[@type='text']"));
        enterMessage.sendKeys("hai all");
        WebElement showMessage= driver.findElement(By.xpath("//button[@id='button-one']"));
        showMessage.click();
        WebElement yourMessage= driver.findElement(By.xpath("//div[@class='my-2']"));
        String expectedResult=yourMessage.getText();
        String actualResult="your message : hai all";
        Assert.assertEquals(actualResult,expectedResult,"message invalid");
    }
    @Test
    public void verifyTwoInputFields(){
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement valueA= driver.findElement(By.xpath("//input[@id='value-a']"));
        valueA.sendKeys("5");
        WebElement valueB= driver.findElement(By.xpath("//input[@id='value-b']"));
        valueB.sendKeys("10");
        WebElement getTotal= driver.findElement(By.xpath("//button[@id='button-two']"));
        getTotal.click();
        WebElement total= driver.findElement(By.xpath("//div[@id='message-two']"));
        String actualTotal=total.getText();
        String expectedTotal="Total A+B:15";
        Assert.assertEquals(actualTotal,expectedTotal,"invalid total");

    }
    @Test
    public void verifySingleCheckBoxDemo(){
        boolean isSelected;
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        isSelected=checkBox.isSelected();
        Assert.assertFalse(isSelected,"checkbox is selected");
        checkBox.click();
        isSelected=checkBox.isSelected();
        Assert.assertTrue(isSelected,"checkbox is not selected");
    }
    @Test
    public void verifyRadioButtonDemo(){
       driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
       WebElement male= driver.findElement(By.xpath("put[@id='inlineRadio1']"));
       boolean isButtonSelected=male.isSelected();
       Assert.assertFalse(isButtonSelected,"radio button selected");
       male.click();
       WebElement showSelectedValue= driver.findElement(By.xpath("//button[@id='button-one']"));
       showSelectedValue.click();
       isButtonSelected=male.isSelected();
       Assert.assertTrue(isButtonSelected,"radio button not selected");
    }
    @Test
    public void verifyFormWithValidation(){
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        WebElement firstName= driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstName.sendKeys("nandu");
        WebElement lastName= driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastName.sendKeys("v s");
        WebElement username= driver.findElement(By.xpath("validationCustomUsername"));
        username.sendKeys("nandu123");
        WebElement city= driver.findElement(By.xpath("//input[@id='validationCustom03']"));
        city.sendKeys("trivandrum");
        WebElement state= driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        state.sendKeys("kerala");
        WebElement zip= driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        zip.sendKeys("1234");
        WebElement chechBox= driver.findElement(By.xpath("//input[@id='invalidCheck']"));
        chechBox.click();
        WebElement submitForm= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitForm.click();
        WebElement actualResultText= driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult=actualResultText.getText();
        String expectedResult="form has been submitted successfully!";
        Assert.assertEquals(actualResult,expectedResult,"Form submission unsuccessful");



    }
}
