package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {
    @When("user clicks on PIM options")
    public void user_clicks_on_pim_options() {
        WebElement pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(pimTab);
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        WebElement addEmployee=driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployee);
    }
    @When("user enters firstName and middleName and lastName")
    public void user_enters_first_name_and_middle_name_and_last_name() {
        WebElement firstName=driver.findElement(By.id("firstName"));
        sendText(firstName,ConfigReader.getPropertyValue("firstName"));

        WebElement middleName=driver.findElement(By.id("middleName"));
        sendText(middleName,ConfigReader.getPropertyValue("middleName"));

        WebElement lastName=driver.findElement(By.id("lastName"));
        sendText(lastName,ConfigReader.getPropertyValue("lastName"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveBtn=driver.findElement(By.id("btnSave"));
        doClick(saveBtn);
    }

}
