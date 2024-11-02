package org.acme.repositories;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface CrudImpl<T> {



    List<T> findAll();
    T save(T t);
    T findOne(long id);
    T update(long id, T t);
    void delete(long id);







}
