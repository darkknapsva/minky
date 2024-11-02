package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Booking;
import org.acme.repositories.CrudImpl;

import org.acme.service.BookingService;

import java.util.List;

@Path("/booking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingController implements CrudImpl<Booking> {


    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @GET
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GET
    @Path("/{id}")
    public Booking findOne(@PathParam("id") long id) {
        return bookingService.findOne(id);
    }

    @POST
    @Transactional
    public Booking save(Booking booking) {
        System.out.println(booking.getAnvandare());
        System.out.println(booking.getDate_time());
        return bookingService.save(booking);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Booking update(@PathParam("id") long id, Booking booking) {
        return bookingService.update(id, booking);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") long id) {
        bookingService.delete(id);
    }

}
