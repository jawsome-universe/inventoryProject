import Login.LoginPage;
import Customers.CustomersPage;
import Customers.CreateCustomerPage;

import com.codeborne.selenide.Condition;
import com.sun.tools.corba.se.idl.constExpr.Not;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class CreateCustomerTest {
    static LoginPage loginPage;
    static CustomersPage customerPage;
    static CreateCustomerPage createCustomer;
    static String code;


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
    public void createCustomerTest(){
        customerPage = new CustomersPage();
        customerPage.clickOnAddButton();
        createCustomer = new CreateCustomerPage();
        createCustomer
                .typeCustomerEmail("testemail@test.test")
                .typePassword("123456")
                .typeCustomerCode()
                .clickOnSaveButton();
        sleep(100);
        createCustomer.getErrorFromNameField("Name is required").shouldBe(Condition.visible);

       // .shouldHave(Condition.text("Name is required"));

    }

}
