import Login.LoginPage;
import Customers.CustomersPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class LoginPageTest {
    static LoginPage loginPage;
    static CustomersPage customerPage;


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        baseUrl = "http://apiato.wp-funnel.com/#!/";
        browser = "chrome";
    }
//test

    @Test
    public void loginTest() {
        loginPage = new LoginPage();
        loginPage.open()
                .clearEmailField()
                .typeEmail("admin@admin.com")
                .clearPasswordField()
                .typePassword("123456")
                .clickOnSignInButton();
        customerPage = new CustomersPage()
                .verifyUserName();

        //Assert.assertEquals


       // we need to check that logged in user is Admin
    }


}
