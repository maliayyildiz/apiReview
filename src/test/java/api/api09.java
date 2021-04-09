package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class api09 extends TestBase {
    /*
    store this uri in TestBase class as spec02 and use it from testbase
When
    I send a GET request to REST API URL
   http://dummy.restapiexample.com/api/v1/employees
       And accept type is "application/JSON"
   Then
    HTTP Status Code should be 200
    And Response format should be "application/JSON"
    And there should be 24 profile_image
    And "61" should be one of the employee_age
    And "320800", "162700", "205500" and  should be among the employee salary
  */
    @Test
    public void test(){
        Response response = given().spec(spec02).when().get();
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("data.profile_image", hasSize(24),
                        "data.employee_age", hasItem("61"),
                        "data.employee_salary", hasItems("320800", "162700", "205500"));
    }

    @Test
    public void test01(){
        Response response = given().spec(spec02).when().get();
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        System.out.println(json.getList("data.profile_image").size());//24

       assertEquals(24,json.getList("data.profile_image").size());
       assertTrue(json.getString("data.employee_age").contains("61"));
        List<String> expectedSalary = new ArrayList<>();
        expectedSalary.add("320800");
        expectedSalary.add("162700");
        expectedSalary.add("205500");
       assertTrue(json.getList("data.employee_salary").containsAll(expectedSalary));

    }
}
