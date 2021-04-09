package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;



import static io.restassured.RestAssured.given;

public class api07 extends TestBase {
    /*
		 When
			 I send a GET request to REST API URL
			 https://jsonplaceholder.typicode.com/todos/123
	     Then
		     HTTP Status Code should be 200
		     And "Server" in Headers should be "cloudflare"
		     And response content type is “application/JSON”
		     And "userId" should be 7,
		     And "title" should be "esse et quis iste est earum aut impedit"
			 And "completed" should be false
	*/
    @Test
    public void test(){
         spec01.pathParam("id",123);

        Response response = given().spec(spec01).when().get("/{id}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", equalTo(7),
                        "title",equalTo("esse et quis iste est earum aut impedit"),
                        "completed",equalTo(false));

        Assert.assertEquals("cloudflare",response.getHeader("Server"));

    }
}
