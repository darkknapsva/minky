package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.Car;
import org.acme.repositories.CrudImpl;

import java.util.List;

@ApplicationScoped
public class CarService implements CrudImpl<Car> {

    @Override
    public List<Car> findAll() {
        return Car.listAll();
    }

    @Override
    @Transactional
    public Car save(Car car) {
        car.persist();
        return car;
    }

    @Override
    public Car findOne(long id) {
        return Car.findById(id);
    }

    @Override
    @Transactional
    public Car update(long id, Car car) {
        Car exists = Car.findById(id);
        exists.setModel(car.getModel());
        exists.setLicensePlate(car.getLicensePlate());
        exists.setRentals(car.getRentals());
        exists.persist();
        return exists;
    }

    @Override
    @Transactional
    public void delete(long id) {
        Car.deleteById(id);
    }
}
