import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Copyright(c) 2009-2018 optile GmbH. All Rights Reserved
 * https://www.optile.net
 *
 * This software is the property of optile GmbH.  Distribution
 * of this software without agreement in writing is strictly prohibited.
 *
 * This software may not be copied, used or distributed unless agreement
 * has been received in full.
 */

/**
 * @author Pritam Patil <pritam.patil@optile.net>
 */
public class ApiMethodsTests {

    @Test
    void getUserDetails() {
        RestAssured.baseURI = "https://reqres.in/api/users/";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "2");

        // Response response = get("https://reqres.in/api/users/2");

        String responseBody = response.getBody().asString();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println("Response - " + responseBody);

    }

    @Test
    void createUser() {
        RestAssured.baseURI = "https://reqres.in/api/users/";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Aadya");
        requestParams.put("job", "student");

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);

    }
}
