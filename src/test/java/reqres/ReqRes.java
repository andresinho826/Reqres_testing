package reqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReqRes {

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test(groups = "createUsers")
    public void create(){
        RestAssured.given().contentType(ContentType.JSON).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").post("users").then().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = "deleteusers")
    public void deleteUsers(){
        RestAssured.when().delete("users/2").then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
