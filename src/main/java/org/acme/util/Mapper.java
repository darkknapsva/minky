package org.acme.util;

import org.acme.model.Car;
import org.acme.model.Customer;
import org.acme.model.Rental;
import org.acme.model.RentalDTO;

public class Mapper {




    public static RentalDTO toRentalDTO(Rental rental){

        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalDate(rental.getRentalDate());

        rentalDTO.setReturnDate(rental.getReturnDate());
        rentalDTO.setCarId(rental.getCar().id);
        rentalDTO.setCustomerId(rental.getCustomer().id);
        return rentalDTO;
    }


    public static Rental toRentalEntity(RentalDTO rentalDTO){

        Rental rental = new Rental();
        Car car = Car.findById(rentalDTO.getCarId());
        Customer customer = Customer.findById(rentalDTO.getCustomerId());
        rental.setCar(car);
        rental.setCustomer(customer);
        rental.setRentalDate(rentalDTO.getRentalDate());
        rental.setReturnDate(rentalDTO.getReturnDate());
        return rental;

    }





}




