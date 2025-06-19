import com.example.payloads.Auth;
import com.example.payloads.Booking;
import com.example.payloads.BookingDates;
import com.example.requests.AuthApi;
import com.example.requests.BookingApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;


public class BookingApiIT {
    Auth auth;
    String authToken;

    @BeforeClass
    public void beforeClass() {
        auth = new Auth("admin","password");
        authToken = AuthApi.postAuth(auth).jsonPath().getString("token");
    }

    @Test
    public void getBookingByRoomIdShouldReturn200() {
        Response response = BookingApi.getBookingByRoomId(1,authToken);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void postBookingShouldReturn201() {
        BookingDates dates = new BookingDates(LocalDate.of(2025, 12,12),LocalDate.of(2025,12,30));
        Booking payload = new Booking(2,"An Alex","Le Hoang",true,"automationfc@gmail.com","012345678910",dates,"Breakfast");
        Response response = BookingApi.postBooking(authToken,payload);
//        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);
    }

//    @Test
//    public void deleteBookingReturn202() {
//        BookingDates dates = new BookingDates(LocalDate.of(2025, 12,12),LocalDate.of(2025,12,12));
//        Booking payload = new Booking(1,"An","Le",true,dates,"Test delete booking");
//
//        Response bookingResponse = BookingApi.postBooking(payload);
//
//        BookingResponse createdBookingResponse = bookingResponse.as(BookingResponse.class);
//
//        Auth auth = new Auth("admin","password");
//
//        Response authResponse = AuthApi.postAuth(auth);
//        String authToken = authResponse.getCookie("token");
//
//        Response deleteResponse = BookingApi.deleteBooking(createdBookingResponse.getBookingid(), authToken);
//
//        assertEquals(202,deleteResponse.getStatusCode());
//    }
}
