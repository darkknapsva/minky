package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Rental;
import org.acme.model.RentalDTO;
import org.acme.service.RentalService;

import java.util.List;

@Path("/rentals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RentalController {


    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GET
    public List<RentalDTO> findAll() {
        return rentalService.findAll();
    }


    @POST
    @Transactional
    public Rental save(Rental rental) {
         rental.persist();
         return rental;
    }


    @GET
    @Path("/{id}")
    public Rental findOne(@PathParam("id")long id) {
        return null;
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Rental update(@PathParam("id")long id, Rental rental) {
        return null;
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id")long id) {

    }
}
