
package com.store.controllers;

import com.store.dao.CustomerDao;
import com.store.models.Customer;
import com.store.utils.JPAUtil;

import javax.persistence.EntityManager;

public class CustomerController {
    public static void create(Customer customer){
        EntityManager entityManager = JPAUtil.getEntityManager();
        CustomerDao customerDao = new CustomerDao(entityManager);

        entityManager.getTransaction().begin();
        customerDao.save(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static Customer findById(Long id){
        return new CustomerDao(JPAUtil.getEntityManager()).findById(id);
    }
}
