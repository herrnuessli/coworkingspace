package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.oracle.svm.core.annotate.Inject;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@RolesAllowed({"User"})
@Path("/mybookings")
@Tag(name = "MyBookings", description = "handeling of own bookings")
public class UserBookingController {
    @Inject
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "index all bookings",
        description = "return a list of all bookings"
    )
    public List<Booking> index() {
        return bookingService.findAll();
    }
    
}
