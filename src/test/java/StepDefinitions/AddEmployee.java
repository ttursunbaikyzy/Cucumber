package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option(){
        doClick(addEmployeePage.pimTab);
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        doClick(addEmployeePage.addEmployee);
    }
    @When("user enters firstName and middleName and lastName")
    public void user_enters_first_name_and_middle_name_and_last_name() {
        sendText(addEmployeePage.firstName,ConfigReader.getPropertyValue("firstName"));
        sendText(addEmployeePage.middleName,ConfigReader.getPropertyValue("middleName"));
        sendText(addEmployeePage.lastName,ConfigReader.getPropertyValue("lastName"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        doClick(addEmployeePage.saveBtn);
    }

}
