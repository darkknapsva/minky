package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.LoginAttempt;
import org.acme.model.RegisteredUser;
import org.acme.service.LoginAttemptService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {



    private final LoginAttemptService loginAttemptService;

    @Inject
    public LoginResource(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }


    @POST
    @Path("/login")
    public Response login(RegisteredUser registeredUser){
        return Response.ok(loginAttemptService.login(registeredUser))
                .build();
    }


    @GET
    @Path("/requestaccess")
    public Response requestAccess(@QueryParam("token") String token){
        return Response.ok(loginAttemptService.requestAccess(token))
                .build();
    }



}
