package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Car;
import org.acme.service.CarService;

import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController{


    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GET
    public List<Car> findAll() {
        return carService.findAll();
    }

    @POST
    @Transactional
    public Car save(Car car) {
        return carService.save(car);
    }


    @GET
    @Path("/{id}")
    public Car findOne(@PathParam("id") long id) {
        return carService.findOne(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Car update(@PathParam("id")long id, Car car) {
        return carService.update(id,car);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id")long id) {
        carService.delete(id);
    }
}
