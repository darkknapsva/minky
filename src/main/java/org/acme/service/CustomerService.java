package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.Customer;
import org.acme.repositories.CrudImpl;

import java.util.List;

@ApplicationScoped
public class CustomerService implements CrudImpl<Customer> {



    @Override
    public List<Customer> findAll() {
        return Customer.listAll();
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        customer.persist();
        return customer;
    }

    @Override
    public Customer findOne(long id) {
        return Customer.findById(id);
    }

    @Override
    @Transactional
    public Customer update(long id, Customer customer) {
        Customer exists = Customer.findById(id);
        exists.setName(customer.getName());
        exists.setPhone(customer.getPhone());
        exists.setRentals(customer.getRentals());
        exists.persist();
        return exists;
    }

    @Override
    @Transactional
    public void delete(long id) {
        Customer.deleteById(id);
    }
}
