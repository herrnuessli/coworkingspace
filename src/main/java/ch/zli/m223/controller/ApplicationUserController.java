package ch.zli.m223.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import com.oracle.svm.core.annotate.Inject;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.ApplicationUserService;

@Path("/applicationUsers")
@Tag(name = "ApplicationUsers", description = "handeling of applicationUsers")
@RolesAllowed({"User"})
public class ApplicationUserController {
    @Inject
    ApplicationUserService applicationUserService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new applicationUser",
        description = "Creates a new applicationUser and returns the newly added entry."
    )
    public ApplicationUser create(@Valid ApplicationUser applicationUser) {
        return applicationUserService.createApplicationUser(applicationUser);
    }
 
    @Path("/password/{id}")
    @PUT
    @Operation(
        summary = "updates password of applicationUser",
        description = "updates password of applicationUser"
    )
    public ApplicationUser updatePassword(@PathParam("id") Long id, @Valid String newPassword) {
        return applicationUserService.updatePassword(id, newPassword);
    }
}
