package localhost.servletto;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ResponseBody;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IndexTest {
    @Test
    public void doGetTest() {
        RestAssured.baseURI = "http://localhost:8080/servletto-1.0/index";
        ResponseBody resp = RestAssured.given().get().getBody();
        assertTrue("Wrong server response, received " + resp.asString(), resp.asString().startsWith("<!DOCTYPE html>"));
    }
}