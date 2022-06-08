package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationWebElements {
    WebDriver driver;
    WebDriverWait wait;
    Faker faker = new Faker();
    String firstName = "Muhammad";
    String middleName = faker.name().firstName();
    String lastName = "Waqas";
    String address = faker.address().streetAddress();
    String city = faker.address().city();
    String state = faker.address().state();
    String postCode = faker.address().zipCode();
    String email = "mwaqas7456@gmail.com";
    @FindBy(xpath = "//*[@id='modalHeader']/h1")
    WebElement form;
    @FindBy(id = "first_4")
    WebElement firstNameField;
    @FindBy(id = "middle_4")
    WebElement middleNameField;
    @FindBy(id = "last_4")
    WebElement lastNameField;
    @FindBy(id = "input_23_addr_line1")
    WebElement addressField;
    @FindBy(id = "input_23_city")
    WebElement cityField;
    @FindBy(id = "input_23_state")
    WebElement stateField;
    @FindBy(id = "input_23_postal")
    WebElement postCodeField;
    @FindBy(id = "input_6")
    WebElement emailField;
    @FindBy(id = "input_46")
    WebElement courseNameDropdown;
    @FindBy(id = "input_20")
    WebElement submitButton;
    @FindBy(xpath = "//div[@id='modalHeader']//button[@class='cta-usetemplate'][contains(text(),'Use Template')]")
    WebElement useTemplate;

    public RegistrationWebElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void formAssertion() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName("object"))));
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        String text = driver.findElement(By.id("header_1")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Student Registration Form");
    }

    public void finalFormAssertion() throws InterruptedException {
        Thread.sleep(5000);
        String text = driver.findElement(By.id("header_1")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Student Registration Form");
    }

    public void firstNameFieldAssertion() {
        Assert.assertEquals(true, firstNameField.isDisplayed());
    }

    public void middleNameFieldAssertion() {
        Assert.assertEquals(true, middleNameField.isDisplayed());
    }

    public void lastNameFieldAssertion() {
        Assert.assertEquals(true, lastNameField.isDisplayed());
    }

    public void emailFieldAssertion() {
        Assert.assertEquals(true, emailField.isDisplayed());
    }

    public void firstNameFieldTextInsert() {
        firstNameField.sendKeys(firstName);
    }

    public void middleNameFieldTextInsert() {
        middleNameField.sendKeys(middleName);
    }

    public void lastNameFieldTextInsert() {
        lastNameField.sendKeys(lastName);
    }

    public void addressFieldTextInsert() {
        addressField.sendKeys(address);
    }

    public void cityFieldTextInsert() {
        cityField.sendKeys(city);
    }

    public void stateFieldTextInsert() {
        stateField.sendKeys(state);
    }

    public void postCodeFieldTextInsert() {
        postCodeField.sendKeys(postCode);
    }

    public void emailFieldTextInsert() {

        emailField.sendKeys(email);
    }

    public void courseNameSelection() {
        Select courseName = new Select(courseNameDropdown);
        courseName.selectByValue("Math 101");
    }

    public void submitApplication() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", submitButton);
    }
}
