package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class api10 extends TestBase {
    @Test
    public void test(){
        spec01.pathParam("id",123);
        Response response = given().spec(spec01).when().get("/{id}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        System.out.println( json.getInt("userId")); //7
        System.out.println(json.getString("title")); //esse et quis iste est earum aut impedit
        System.out.println(json.getBoolean("completed")); //false
    }

    @Test
    public void test01(){
        Response response = given().spec(spec01).when().get();
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        json.getList("id");
        //123 153 183
        List<Integer> expectedId = new ArrayList<>();
        expectedId.add(123);
        expectedId.add(153);
        expectedId.add(183);
        //birden fazla data validate yapilacaksa containsAll() <collections>
        Assert.assertTrue(json.getList("id").containsAll(expectedId));
        //bir tane data validate yapilacaksa contains()
        Assert.assertTrue(json.getList("id").contains(12));
    }
}
