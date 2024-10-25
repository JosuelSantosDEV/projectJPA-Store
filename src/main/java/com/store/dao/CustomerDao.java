

package com.store.dao;

import com.store.models.Customer;

import javax.persistence.EntityManager;

public class CustomerDao {
    private final EntityManager entityManager;

    public CustomerDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void save(Customer customer){
        this.entityManager.persist(customer);
    }
    public Customer findById(Long id){
        return this.entityManager.find(Customer.class, id);
    }
}
