package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        WebElement empIdTextBox=driver.findElement(By.id("empsearch_id"));
        sendText(empIdTextBox, ConfigReader.getPropertyValue("empid"));
    }
    @When("clicks n search button")
    public void clicks_n_search_button() {
        WebElement searchBtn=driver.findElement(By.id("searchBtn"));
        doClick(searchBtn);
    }
    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is displayed");
    }

    public static Select clickOnDropDown(WebElement element){
        Select select=new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value){
        clickOnDropDown(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element, String text){
        clickOnDropDown(element).selectByVisibleText(text);
    }

    public static void selectByVIndex(WebElement element, int index){
        clickOnDropDown(element).selectByIndex(index);
    }

    public static void selectByOptions(WebElement element, String text){
        List<WebElement> options= clickOnDropDown(element).getOptions();
        for(WebElement option:options){
            String ddlOptionText=option.getText();
            if(ddlOptionText.equals(text)){
                option.click();
            }
        }
    }

    @When("user selects Job Title")
    public void user_selects_job_title() {
        WebElement jobTitleDdl = driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(jobTitleDdl,"Singer");

        /*WebElement empStatusDdl = driver.findElement(By.id("empsearch_employee_status"));
        selectByOptions(empStatusDdl,"Active");

        WebElement includeDdl = driver.findElement(By.id("empsearch_termination"));
        selectByOptions(includeDdl,"Current and Past Employees");*/
    }



}
