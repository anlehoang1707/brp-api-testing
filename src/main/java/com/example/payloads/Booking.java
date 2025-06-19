package com.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking {
    @JsonProperty
    private int roomid;

    @JsonProperty
    private String firstname;

    @JsonProperty
    private String lastname;

    @JsonProperty
    private boolean depositpaid;

    @JsonProperty
    private String email;

    @JsonProperty
    private String phone;

    @JsonProperty
    private BookingDates bookingdates;

    @JsonProperty
    private String additionalneeds;

    public Booking(int roomid, String firstname, String lastname, boolean depositpaid, String email, String phone, BookingDates bookingdates, String additionalneeds) {
        this.roomid = roomid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositpaid = depositpaid;
        this.email = email;
        this.phone = phone;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public int getRoomid() {
        return roomid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
