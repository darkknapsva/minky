package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Anvandare;
import org.acme.repositories.CrudImpl;

import java.util.List;

@ApplicationScoped
public class AnvandareService implements CrudImpl<Anvandare> {


    @Override
    public List<Anvandare> findAll() {
        return Anvandare.listAll();
    }

    @Override
    public Anvandare save(Anvandare anvandare) {

        anvandare.persist();
        return anvandare;
    }

    @Override
    public Anvandare findOne(long id) {
        return Anvandare.findById(id);
    }

    @Override
    public Anvandare update(long id, Anvandare anvandare) {
        Anvandare exists = Anvandare.findById(id);
        exists.setName(anvandare.getName());
        exists.setBookings(anvandare.getBookings());
        //updatera här
        return exists;
    }

    @Override
    public void delete(long id) {
        Anvandare.deleteById(id);
    }
}
