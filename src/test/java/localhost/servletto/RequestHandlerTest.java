package localhost.servletto;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ResponseBody;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestHandlerTest {

    @Test
    public void doRequestsTest() {
        RestAssured.baseURI = "http://localhost:8080/servletto-1.0/request";
        ResponseBody resp = RestAssured.given().put().getBody();
        assertEquals("Wrong server response, received " + resp.asString(), "PUT, total clicks - null", resp.asString());
        resp = RestAssured.given().get().getBody();
        assertEquals("Wrong server response, received " + resp.asString(), "GET, total clicks - null", resp.asString());
        resp = RestAssured.given().post().getBody();
        assertEquals("Wrong server response, received " + resp.asString(), "POST, total clicks - null", resp.asString());
        resp = RestAssured.given().delete().getBody();
        assertEquals("Wrong server response, received " + resp.asString(), "DELETE, total clicks - null", resp.asString());
    }
}