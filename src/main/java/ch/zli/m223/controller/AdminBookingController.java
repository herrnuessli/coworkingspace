package ch.zli.m223.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.oracle.svm.core.annotate.Inject;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/bookings")
@Tag(name = "Bookings", description = "handeling of bookings")
@RolesAllowed({"Admin"})
public class AdminBookingController {
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

    @Path("/booking/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Gets booking",
        description = "returns a booking"
    )
    public Booking readBooking(Long id) {
        return bookingService.readBooking(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "updates a booking",
        description = "updates a booking by its id"
    )
    public Booking update(@PathParam("id") Long id, @Valid Booking booking) {
        return bookingService.updateBooking(id, booking);
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
