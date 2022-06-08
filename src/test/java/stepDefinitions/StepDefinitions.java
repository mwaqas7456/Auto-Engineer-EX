package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationWebElements;

import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;
    RegistrationWebElements registrationWebElements;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Given("User visits the website and registration form is opened up")
    public void user_visits_the_website_and_registration_form_is_opened_up() throws InterruptedException {
        driver.get("https://www.jotform.com/form-templates/class-registration-3");

        registrationWebElements = new RegistrationWebElements(driver);
        registrationWebElements.formAssertion();
    }

    @When("first name, middle name, last name and email field are present")
    public void first_name_middle_name_last_name_and_email_field_are_present() {
        registrationWebElements = new RegistrationWebElements(driver);
        registrationWebElements.firstNameFieldAssertion();
        registrationWebElements.middleNameFieldAssertion();
        registrationWebElements.lastNameFieldAssertion();
        registrationWebElements.addressFieldTextInsert();
        registrationWebElements.emailFieldAssertion();
    }

    @When("user insert values at first name, middle name, last name and email field")
    public void user_insert_values_at_first_name_middle_name_last_name_and_email_field() {
        registrationWebElements = new RegistrationWebElements(driver);
        registrationWebElements.firstNameFieldTextInsert();
        registrationWebElements.lastNameFieldTextInsert();
        registrationWebElements.cityFieldTextInsert();
        registrationWebElements.stateFieldTextInsert();
        registrationWebElements.postCodeFieldTextInsert();
        registrationWebElements.emailFieldTextInsert();
    }

    @When("select course Math101")
    public void select_course_math101() {
        registrationWebElements = new RegistrationWebElements(driver);
        registrationWebElements.courseNameSelection();
    }

    @When("clicks submit application")
    public void clicks_submit_application() throws InterruptedException {
        registrationWebElements = new RegistrationWebElements(driver);
        registrationWebElements.submitApplication();
    }

    @Then("user registration form is present")
    public void user_registration_form_is_present() throws InterruptedException {
        registrationWebElements = new RegistrationWebElements(driver);
        registrationWebElements.finalFormAssertion();
    }
}
