package api.request.impl;

import api.exceptions.InvalidRequestException;
import api.request.HttpRequest;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class GetRequestImpl extends HttpRequest {

    @Override
    public Response request() throws InvalidRequestException {
        Response response;
        try {
            response = given().header("Authorization","Bearer " + getToken()).contentType("application/json").when().get(getUrl());
        } catch (JSONException | IllegalArgumentException e) {
            throw new InvalidRequestException("something wrong with the request.",e);
        }
        return response;
    }
}
