import Login.LoginPage;
import Customers.CustomersPage;
import Customers.CreateCustomerPage;

import com.codeborne.selenide.Condition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class CreateCustomerTest {
    static LoginPage loginPage;
    static CustomersPage customerPage;
    static CreateCustomerPage createCustomer;



    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        baseUrl = "http://apiato.wp-funnel.com/#!/";
        browser = "chrome";
        loginPage = new LoginPage();
        loginPage.open()
                .clearEmailField()
                .typeEmail("admin@admin.com")
                .clearPasswordField()
                .typePassword("123456")
                .clickOnSignInButton();
        sleep(500);
    }

    @Test
    public void createCustomerTest1(){
        customerPage = new CustomersPage();
        customerPage.clickOnAddButton();
        createCustomer = new CreateCustomerPage();
        createCustomer
                .typeCustomerName("Customer №" + createCustomer.generateRandomNumber())
                .typeCustomerEmail(createCustomer.generateRandomWord() +"@email.com")
                .typePassword("123456")
                .typeCustomerCode(createCustomer.generateRandomNumber())
                .clickOnSaveButton();
        sleep(3000);


        //Verify that if Name is not added, we will show error message
        //createCustomer.getErrorFromNameField("Name is required").shouldBe(Condition.visible);

       // .shouldHave(Condition.text("Name is required"));

    }

}
