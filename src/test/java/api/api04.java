package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class api04 {
    @Test
    public void test(){
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking");

     //   response.prettyPrint();

        //all headers
        System.out.println(response.headers());
// specific header
        System.out.println(response.header("Server"));


    }
}
