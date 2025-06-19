package com.example.requests;

import com.example.payloads.Auth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi{
    private static final String apiUrl = baseUrl + "auth/";

    public static Response postAuth(Auth payload) {
        return given().contentType(ContentType.JSON)
                .body(payload).
                when().post(apiUrl + "login");
    }

    public static void main(String[] args) {
        Auth auth = new Auth("admin","password");
        Response testResponse = AuthApi.postAuth(auth);
        System.out.println(testResponse.getStatusCode());
        System.out.println(testResponse.jsonPath().getString("token"));
    }
}

