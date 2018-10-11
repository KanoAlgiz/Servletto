package localhost.servletto;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CookieHandlerTest {

    @Test
    public void indexCookieTest() {
        RestAssured.baseURI = "http://localhost:8080/servletto-1.0/index";
        Response resp = RestAssured.given().cookie("visits", "1").when().get();
        Map<String, String> cookies = resp.getCookies();
        assertEquals("Wrong cookie value!", "2", cookies.get("visits"));
        resp = RestAssured.given().cookie("testcookie", "anything").when().get();
        cookies = resp.getCookies();
        assertNull("Wrong cookie value!", cookies.get("testcookie"));
    }

    @Test
    public void buttonCookieTest() {
        RestAssured.baseURI = "http://localhost:8080/servletto-1.0/request";
        Response resp = RestAssured.given().cookie("clicks", "1").when().get();
        Map<String, String> cookies = resp.getCookies();
        assertEquals("Wrong cookie value!", "2", cookies.get("clicks"));
        resp = RestAssured.given().cookie("testcookie", "anything").when().get();
        cookies = resp.getCookies();
        assertNull("Wrong cookie value!", cookies.get("testcookie"));
    }
}