package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;

public class Hooks extends CommonMethods {
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }
    @After
    public void postCondition(){
        closeBrowser();
    }

    //HOOKS: For defining pre and post steps in any Cucumber framework
    //    : This is always created inside the StepDefinitions folder
    //    : This class cannot be inherited
    //    : Hooks will take care of pre and post conditions irrespective of what goes in between the test steps
}

