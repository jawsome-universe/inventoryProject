package Login;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class LoginPage {

    private By emailField = xpath("//*[@id='exampleInputEmail1']");
    private By passwordField = xpath("//*[@id='exampleInputPassword1']");
    private By signInButton = xpath("//*[contains(@type, 'submit')]");

    //Admin role
    private By userRoleDisplaying = xpath("//*[@class='dropdown-toggle']");


    public LoginPage open() {
        Selenide.open("login");
        return this;
    }

    public LoginPage clearEmailField(){
        $(emailField).clear();
        return this;
    }

    public LoginPage typeEmail(String email) {
        $(emailField).setValue(email);
        return this;
    }

    public LoginPage clearPasswordField(){
        $(passwordField).clear();
        return this;
    }

    public LoginPage typePassword(String password) {
        $(passwordField).setValue(password);
        return this;
    }

    public void clickOnSignInButton() {
        $(signInButton).click();
        sleep(300);
    }



}
