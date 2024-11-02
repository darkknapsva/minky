package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Booking;
import org.acme.repositories.CrudImpl;

import java.util.List;

@ApplicationScoped
public class BookingService implements CrudImpl<Booking> {


    @Override
    public List<Booking> findAll() {
        return Booking.listAll();
    }

    @Override
    public Booking save(Booking booking) {
        booking.persist();
        return booking;
    }

    @Override
    public Booking findOne(long id) {
        return Booking.findById(id);
    }

    @Override
    public Booking update(long id, Booking booking) {
        Booking exists = Booking.findById(id);
        exists.setAnvandare(booking.getAnvandare());
        exists.setDate_time(booking.getDate_time());
        exists.persist();
        return exists;
    }

    @Override
    public void delete(long id) {
        Booking.deleteById(id);
    }
}
