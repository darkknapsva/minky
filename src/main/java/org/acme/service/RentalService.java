package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.Rental;
import org.acme.model.RentalDTO;
import org.acme.repositories.CrudImpl;
import org.acme.util.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RentalService  {


    public List<RentalDTO> findAll() {
        return Rental.findAll().stream()
                .map(entity -> (Rental) entity)
                .map(Mapper::toRentalDTO)
                .collect(Collectors.toList());
    }


    @Transactional
    public Rental save(Rental rental) {
        rental.persist();
        return rental;
    }


    public Rental findOne(long id) {
        return Rental.findById(id);
    }


    @Transactional
    public Rental update(long id, Rental rental) {

        Rental exists = Rental.findById(id);
        exists.setCar(rental.getCar());
        exists.setCustomer(rental.getCustomer());
        exists.setRentalDate(rental.getRentalDate());
        exists.setReturnDate(rental.getReturnDate());
        exists.persist();
        return exists;
    }


    @Transactional
    public void delete(long id) {
        Rental.deleteById(id);
    }
}
