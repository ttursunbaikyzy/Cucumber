package API;

import APIStepDefinitions.GenerateTokenSteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzE0NDYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxNDY0NiwidXNlcklkIjoiNTI2OCJ9.QAhyEAoP5bf-vXyXK0UF1-l7g4OMiMRe6Kz-QnXgfqU";
    static String employeeID;

    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employeeID);

        // hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        // verify the response
        response.then().assertThat().statusCode(200);

        String tempEmpId=response.jsonPath().getString("employee.employee_id");

        // we have 2 emp id, one is global and second is local
        Assert.assertEquals(employeeID,tempEmpId);

    }

    @Test
    public void acreateEmployee(){
        // prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", GenerateTokenSteps.token).body("{\n" +
                        "    \"emp_firstname\": \"nickou\",\n" +
                        "    \"emp_lastname\": \"boujevic\",\n" +
                        "    \"emp_middle_name\": \"f\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"2017-05-20\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"Napper\"\n" +
                        "}");

        // hitting the endpoint
        Response response = preparedRequest.when().post("/createEmployee.php");
        // it will print the output in the console
        response.prettyPrint();
        // verifying the assertions
        response.then().assertThat().statusCode(201);

        // we are capturing employee id from the response
        employeeID=response.jsonPath().getString("Employee.employee_id");
        System.out.println(employeeID);

        //verifying the firstname in the response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("nickou"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("boujevic"));

        // verify the response headers
        response.then().assertThat().header("Content-Type","application/json");

        System.out.println("My test case is passed");

    }

    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "    \"employee_id\": \""+employeeID+"\",\n" +
                        "    \"emp_firstname\": \"Lily\",\n" +
                        "    \"emp_lastname\": \"Pretty\",\n" +
                        "    \"emp_middle_name\": \"n\",\n" +
                        "    \"emp_gender\": \"F\",\n" +
                        "    \"emp_birthday\": \"2015-01-20\",\n" +
                        "    \"emp_status\": \"non employed\",\n" +
                        "    \"emp_job_title\": \"CEO\"\n" +
                        "}");

        // hitting the endpoint
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        // for verification
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employeeID);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        // if you want to verfiy the body of the response
        // you can do that using hamcrest matchers


    }

}
