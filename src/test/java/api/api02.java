package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class api02 {

    @Test
    public void test(){
    /*
 Positive Scenario
 when I send a GET Request to https://restful-booker.herokuapp.com/booking/5
 then status code should be 200
 and content type should be "application/json"
*/
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/5");

       // response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

    }
    @Test
    public void test01(){
              /*
 Negative Scenario
 when I send a GET Request to https://restful-booker.herokuapp.com/booking/1001
 then status code should be 404
 and Response Body contains "Not Found"
 and Response Body does not contain "Mali"
*/
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/1001");

        response.then().assertThat().statusCode(404);

        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("Mali"));

    }
}
