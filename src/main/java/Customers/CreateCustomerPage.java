package Customers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class CreateCustomerPage {


    private By customerNameField = xpath("//*[@id='organization-name']");
    private By customerDescriptionField = xpath("//*[@id='organization-description']");
    private By customerEmailField = xpath("//*[@id='organization-email']");
    private By customerPasswordField = xpath("//*[@id='organization-password']");
    private By customerCodeField = xpath("//*[@id='organization-code']");
    private By customerSaveButton = xpath("//*[@ng-click='create()']");

    //Error (UI):
    private By errorName = xpath("//*[text()= 'Name is required']"); //change it
    private By errorEmail = xpath("//*[text()= 'Email is required']");
    private By errorPassword = xpath("//*[text()= 'Password is required']");
    private By errorCode = xpath("//*[text()= 'Code is required']");


    public CreateCustomerPage typeCustomerName(String name) {
        $(customerNameField).setValue("Customer" + name);
        return this;
    }

    public CreateCustomerPage typeDescription(String description) {
        $(customerDescriptionField).setValue(description);
        return this;
    }
    public CreateCustomerPage typeCustomerEmail(String email) {
        $(customerEmailField).setValue(email);
        return this;
    }
    public CreateCustomerPage typePassword(String password) {
        $(customerPasswordField).setValue(password);
        return this;
    }
    public CreateCustomerPage typeCustomerCode(String code) {
        $(customerCodeField).setValue(code);
        return this;
    }

    public void clickOnSaveButton() {
        $(customerSaveButton).waitUntil(Condition.enabled, 5000); //wait 5 sec (Explisit wait)
        $(customerSaveButton).click();
        sleep(300);
    }

    /*
    public CreateCustomerPage addProfile(String key){
        $(element).sendKeys(path to profu=ile file);
        return this;
    }
    */


    //Errors:

    public CreateCustomerPage isNameErrorVisible(String text){
      $(errorName).shouldHave(Condition.text("Name is required"));
      return this;
    }


    public SelenideElement getErrorFromNameField(String message){
        return $(xpath(format(String.valueOf(errorName), message)));
    }

    //setSelection(value) - for checkboxes


    //Generate random number
    public static String generateRandomNumber() {
        String randomString = "";

        for (int i = 0; i < 6; i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt((9 - 1) + 1) + 1;
            randomString += Integer.toString(randomNum);
        }
        return randomString;
    }


    //Generate random word
    public static String generateRandomWord() {
        Random random = new Random();

        char[] word = new char[random.nextInt(8)+5]; // words of length 3 through 10. (1 and 2 letter words are boring.)
        for(int j = 0; j < word.length; j++)
        {
            word[j] = (char)('a' + random.nextInt(26));
        }
        String randomWord = new String(word);
        return randomWord;
    }

}


