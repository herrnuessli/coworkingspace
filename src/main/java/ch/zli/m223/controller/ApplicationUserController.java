package ch.zli.m223.controller;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.oracle.svm.core.annotate.Inject;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.service.ApplicationUserService;

@Path("/applicationUsers")
@Tag(name = "ApplicationUsers", description = "handeling of applicationUsers")
public class ApplicationUserController {
    @Inject
    ApplicationUserService applicationUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "index all applicationUsers.",
        description = "returns a list of all applicationUsers"
    )
    public List<ApplicationUser> index() {
        return applicationUserService.findAll();
    }
}
