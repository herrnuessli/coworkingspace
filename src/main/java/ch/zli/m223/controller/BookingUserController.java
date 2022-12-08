package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
public class BookingUserController {
    @Inject
    BookingService bookingService;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates new Booking.", 
        description = "Creates a new booking and returns the newly added booking."
    )
    public Booking create(Booking booking) {
        return bookingService.createBooking(booking);
    }

    @Path("/{id}")
    @DELETE 
    @Operation(
        summary = "Deletes a booking",
        description = "Deletes a booking."
    )
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }
}
