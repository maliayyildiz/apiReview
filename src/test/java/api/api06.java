package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class api06 {
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
        Response response = given().accept(ContentType.JSON).when().get("http://dummy.restapiexample.com/api/v1/employees");

        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age", hasItems("21","23","61"));
    }
}
