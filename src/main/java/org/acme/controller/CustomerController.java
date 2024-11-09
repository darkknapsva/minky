package org.acme.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Customer;
import org.acme.service.CustomerService;

import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @POST
    @Transactional
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }

    @GET
    @Path("/{id}")
    public Customer findOne(@PathParam("id")long id) {
        return customerService.findOne(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Customer update(@PathParam("id")long id, Customer customer) {
        return customerService.update(id, customer);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id")long id) {
        customerService.delete(id);
    }
}
