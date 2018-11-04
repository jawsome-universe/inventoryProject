package Customers;
import Customers.CreateCustomerPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class CustomersPage {

    private By userRoleDisplaying = xpath("//*[@class='dropdown-toggle']");
    private By addCustomerButton = xpath("//*[@id='pageDashboard']/div[3]/a");

    private By createdCustomerRaw = xpath("//*[@class='grid-table__row clearfix ng-scope ng-isolate-scope'][1]");

    private By searchDropdown = xpath("//*[@class='btn-perPage ng-pristine ng-valid ng-not-empty ng-touched']");
    String searchDropdownOption = "//*[@class='btn-perPage ng-pristine ng-valid ng-not-empty ng-touched']/option[text()='%s']"; //Code


    public CustomersPage verifyUserName(){
        $(userRoleDisplaying).shouldHave(Condition.text("Admin"));
        return this;
    }


    //?? really like that?
    public CustomersPage sortCustomersByCode(String code){
        $(searchDropdown).selectOption(code);
        //$(searchDropdown).$(searchDropdownOption).click(); - find value from a drop-down
        //$$(searchDropdown).get(0);  - get 1st element of the list????
        //sleep(200);

        return this;
    }


    public void clickOnAddButton() {
        $(addCustomerButton).waitUntil(Condition.enabled, 6000);
        $(addCustomerButton).click();
        sleep(1000);
    }


    public CustomersPage textIsPresent(String message){
        $(createdCustomerRaw).val(message).is(Condition.visible);
        return this;
    }

    public CustomersPage verifyCreatedCustomerCode(){
        $(createdCustomerRaw).shouldHave(Condition.text(String.valueOf(CreateCustomerPage.code)));
        return this;
    }



}
