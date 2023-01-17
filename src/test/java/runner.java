import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;
public class runner {
    @Test
    public void testPost(){
        baseURI="https://petstore.swagger.io/";
        String jsonString = "{\r\n" +
                "     \"id\": 1010,\r\n" +
                "         \"category\": { \r\n" +
                "   \"id\": 54421,\r\n" +
                "         \"name\": \"oso\" \r\n" +
                "     }, \r\n" +
                "      \"name\": \"oso\", \r\n" +
                "         \"photoUrls\": [ \r\n" +
                "     \"https://petstore/oso.jpg\" \r\n" +
                "     ], \r\n" +
                "     \"tags\": [ \r\n" +
                "         { \r\n" +
                "        \"id\": 246,\r\n" +
                "            \"name\": \"lima\" \r\n" +
                "        }, \r\n" +
                "       { \r\n" +
                "        \"id\": 1357,\r\n" +
                "            \"name\": \"callao\" \r\n" +
                "        } \r\n" +
                "        ], \r\n" +
                "    \"status\": \"available\" \r\n" +
                "}";

        RequestSpecification httpRequestSpecification = RestAssured.given();
        httpRequestSpecification.header("Content-Type","application/json");
        Response response = httpRequestSpecification.body(jsonString).post("v2/pet");
        int statusCode = response.getStatusCode();
        System.out.println("respuest: "+statusCode);
        response.prettyPrint();
    }

    @Test
    public void testGet(){
        baseURI = "https://petstore.swagger.io/";
        String body = given()
                .when()
                .get("v2/pet/1010")
                .then()
                .statusCode(200)
                .extract()
                .body().asString();
        System.out.println(body);
    }

    @Test
    public void testPut(){
        baseURI="https://petstore.swagger.io/";
        String jsonStringreplacement = "{\r\n" +
                "     \"id\": 1010,\r\n" +
                "         \"category\": { \r\n" +
                "   \"id\": 54421,\r\n" +
                "         \"name\": \"nala\" \r\n" +
                "     }, \r\n" +
                "      \"name\": \"nala\", \r\n" +
                "         \"photoUrls\": [ \r\n" +
                "     \"https://petstore/oso.jpg\" \r\n" +
                "     ], \r\n" +
                "     \"tags\": [ \r\n" +
                "         { \r\n" +
                "        \"id\": 246,\r\n" +
                "            \"name\": \"Piura\" \r\n" +
                "        }, \r\n" +
                "       { \r\n" +
                "        \"id\": 1357,\r\n" +
                "            \"name\": \"Ica\" \r\n" +
                "        } \r\n" +
                "        ], \r\n" +
                "    \"status\": \"No available\" \r\n" +
                "}";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        Response replace = request.body(jsonStringreplacement).put("v2/pet");
        Assert.assertEquals(200,replace.getStatusCode());
        replace.prettyPrint();
    }
}
