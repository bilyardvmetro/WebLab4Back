package com.weblab4.weblab4back.APIResoucres;

import com.weblab4.weblab4back.JWT.JWTUtil;
import com.weblab4.weblab4back.database.databaseServices.UserService;
import com.weblab4.weblab4back.database.models.User;
import com.weblab4.weblab4back.responseTemplates.AuthResponseTemplate;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthenticationAPIResource {

    @EJB
    private UserService userService;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        if (!userService.register(user.getUsername(), user.getPassword())) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(new AuthResponseTemplate("Username already exists", "",""))
                    .build();
        }
        return Response.ok().build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {

        if (!userService.login(user.getUsername(), user.getPassword())) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(new AuthResponseTemplate("Username doesn't exists or wrong password", "", ""))
                    .build();
        }

        String token = JWTUtil.generateToken(user.getUsername());
        return Response.ok().entity(new AuthResponseTemplate("Login success", user.getUsername(), token)).build();
    }

}