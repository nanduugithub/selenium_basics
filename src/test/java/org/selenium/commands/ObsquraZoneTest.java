package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ObsquraZoneTest extends BrowerLaunch {

    @Test
    public void verifySingleInputField() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterMessage = driver.findElement(By.xpath("//input[@type='text']"));
        enterMessage.sendKeys("hai all");
        WebElement showMessage = driver.findElement(By.xpath("//button[@id='button-one']"));
        showMessage.click();
        WebElement yourMessage = driver.findElement(By.xpath("//div[@class='my-2']"));
        String actualResult = yourMessage.getText();
        String expectedResult = "Your Message : hai all";
        Assert.assertEquals(actualResult, expectedResult, "message invalid");
    }

    @Test
    public void verifyTwoInputFields() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement valueA = driver.findElement(By.xpath("//input[@id='value-a']"));
        valueA.sendKeys("5");
        WebElement valueB = driver.findElement(By.xpath("//input[@id='value-b']"));
        valueB.sendKeys("10");
        WebElement getTotal = driver.findElement(By.xpath("//button[@id='button-two']"));
        getTotal.click();
        WebElement total = driver.findElement(By.xpath("//div[@id='message-two']"));
        String actualTotal = total.getText();
        String expectedTotal = "Total A + B : 15";
        Assert.assertEquals(actualTotal, expectedTotal, "invalid total");

    }

    @Test
    public void verifySingleCheckBoxDemo() {
        boolean isSelected;
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        isSelected = checkBox.isSelected();
        Assert.assertFalse(isSelected, "checkbox is selected");
        checkBox.click();
        isSelected = checkBox.isSelected();
        Assert.assertTrue(isSelected, "checkbox is not selected");
    }

    @Test
    public void verifyRadioButtonDemo() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement male = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        boolean isButtonSelected = male.isSelected();
        Assert.assertFalse(isButtonSelected, "Male radio button is selected");
        male.click();
        isButtonSelected = male.isSelected();
        Assert.assertTrue(isButtonSelected, "male radio button is not selected");
        WebElement showSelectedValue = driver.findElement(By.xpath("//button[@id='button-one']"));
        showSelectedValue.click();

    }

    @Test
    public void verifyFormWithValidation() {
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstName.sendKeys("nandu");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastName.sendKeys("v s");
        WebElement username = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
        username.sendKeys("nanduvs01@gmail.com");
        WebElement city = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
        city.sendKeys("trivandrum");
        WebElement state = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
        state.sendKeys("kerala");
        WebElement zip = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
        zip.sendKeys("1234");
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
        checkBox.click();
        WebElement submitForm = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitForm.click();
        WebElement actualResultText = driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult = actualResultText.getText();
        String expectedResult = "Form has been submitted successfully!";
        Assert.assertEquals(actualResult, expectedResult, "Form submission unsuccessful");

    }

    @Test
    public void verifyColorSelectFromDropDown() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='single-input-field']"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        WebElement selectedColor = select.getFirstSelectedOption();
        WebElement message = driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult = message.getText();
        String expectedResult = "Selected Color : Yellow";
        Assert.assertEquals(actualResult, expectedResult, "color not selected");
    }

    @Test
    public void verifyTotalNumberOfValuesInDropDown() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colorDropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select = new Select(colorDropDown);
        List<WebElement> dropDownSize = select.getOptions();
        int actualResult = dropDownSize.size();
        int expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult, "invalid size");
    }

    @Test
    public void verifyValuesInColorSelectDropDown() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colourDropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select select = new Select(colourDropDown);
        List<WebElement> element = select.getOptions();
        List<String> actual = new ArrayList<>();
        for (WebElement e : element) {
            String colors = e.getText();
            actual.add(colors);
        }
        List<String> expected = new ArrayList<>();
        expected.add("-- Select --");
        expected.add("Red");
        expected.add("Yellow");
        expected.add("Green");
        Assert.assertEquals(actual, expected, "invalid selection");
    }

    @Test
    public void verifyDropDownWithoutSelect() {
        driver.get("https://selenium.obsqurazone.com/jquery-select.php");
        WebElement stateDropDown = driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']//span[@class='select2-selection__arrow']"));
        stateDropDown.click();
        List<WebElement> DropDownWithoutSelect = driver.findElements(By.xpath("//li[contains(@class,'select2-results__option select2-results__option--selectable')]"));
        for (WebElement dropDownValueElements : DropDownWithoutSelect) {
            String selectedState = dropDownValueElements.getText();
            if (selectedState.equals("California")) {
                dropDownValueElements.click();
                break;
            }
        }
    }
}
