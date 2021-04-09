package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class api08 extends TestBase {
    /*
    1) Create a class and name it as you wish :)
2) When
     I send a GET Request to https://jsonplaceholder.typicode.com/todos
   Then
    HTTP Status code should be "200"
    And Content type should be in "JSON" format
    And there should be 200 "title"
    And "dignissimos quo nobis earum saepe" should be one of the "title"s
    And 111, 121, and 131 should be among the "id"s
    And 10th title is "et porro tempora"
    And last title is "ipsam aperiam voluptates qui"
     */
    @Test
    public void test(){
        Response response = given().spec(spec01).when().get();
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", hasSize(200),
                        "title",hasItem("dignissimos quo nobis earum saepe"),
                        "id", hasItems(111,121,131),
                        "title[3]",equalTo("et porro tempora"),
                        "title[-1]",equalTo("ipsam aperiam voluptates qui"));
        //"title[199]",equalTo("ipsam aperiam voluptates qui")
    }
}
