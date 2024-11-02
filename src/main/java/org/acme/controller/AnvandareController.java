package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Anvandare;
import org.acme.repositories.CrudImpl;
import org.acme.service.AnvandareService;

import java.util.List;

@Path("/anvandare")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnvandareController implements CrudImpl<Anvandare> {

    private final AnvandareService anvandareService;

    public AnvandareController(AnvandareService anvandareService) {
        this.anvandareService = anvandareService;
    }

    @GET
    public List<Anvandare> findAll() {
        return anvandareService.findAll();
    }

    @GET
    @Path("/{id}")
    public Anvandare findOne(@PathParam("id") long id) {
        return anvandareService.findOne(id);
    }

    @POST
    @Transactional
    public Anvandare save(Anvandare anvandare) {

        return anvandareService.save(anvandare);
    }
    @PUT
    @Path("/{id}")
    @Transactional
    public Anvandare update(@PathParam("id") long id, Anvandare anvandare) {
        return anvandareService.update(id, anvandare);
    }
    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") long id) {
        anvandareService.delete(id);
    }
}
