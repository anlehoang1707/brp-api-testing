package com.example.requests;

import com.example.payloads.Booking;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi extends  BaseApi{

    private static final String apiUrl = baseUrl + "booking";

    public static Response getBookingByRoomId(int roomId,String token) {
        return given().header("Cookie","token=" + token).get(apiUrl + String.format("?roomid=%s",Integer.toString(roomId)));
    }

    public static Response postBooking(String token,Booking payload) {
        return given().header("Cookie","token=" + token).contentType(ContentType.JSON).body(payload).when().post(apiUrl);
    }

    public static Response deleteBooking(int id, String tokenValue) {
        return given().header("Cookie","token=" + tokenValue).delete(apiUrl + Integer.toString(id));
    }
}
