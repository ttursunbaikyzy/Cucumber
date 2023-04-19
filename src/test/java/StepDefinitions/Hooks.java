package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;

public class Hooks extends CommonMethods {
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }

    // Scenario class holds te complete information of your tests execution in Cucumber Framework
    @After
    public void postCondition(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()){
            pic=takeScreenshot("failed/"+scenario.getName());
        }else {
            pic=takeScreenshot("passed/"+scenario.getName());
        }

        // attach the screenshot in my report
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
    }

    //HOOKS: For defining pre and post steps in any Cucumber framework
    //    : This is always created inside the StepDefinitions folder
    //    : This class cannot be inherited
    //    : Hooks will take care of pre and post conditions irrespective of what goes in between the test steps
}

