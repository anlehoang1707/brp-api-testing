package api.request.impl;

import api.exceptions.InvalidRequestException;
import api.request.HttpRequest;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class PostRequestImpl extends HttpRequest {

    @Override
    public Response request() throws InvalidRequestException {
        Response response;
        try {
            response = given().header("Authorization","Bearer " + getToken()).body(getPayload()).contentType("application/json").when().post(getUrl());
        } catch (JSONException | IllegalArgumentException e) {
            throw new InvalidRequestException("something wrong with the request.",e);
        }
        return response;
    }
}
