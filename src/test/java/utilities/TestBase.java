package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TestBase {

    protected RequestSpecification spec01;
    protected RequestSpecification spec02;

    @Before
    public void setUp(){
        spec01 =new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com/todos")
                .build();
    }
    @Before
    public void setUp01(){
        spec02 =new RequestSpecBuilder().
                setBaseUri("http://dummy.restapiexample.com/api/v1/employees")
                .build();
    }
}
