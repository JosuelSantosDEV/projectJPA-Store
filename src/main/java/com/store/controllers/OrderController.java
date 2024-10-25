
package com.store.controllers;


import com.store.dao.OrderDao;
import com.store.models.Order;
import com.store.utils.JPAUtil;
import com.store.vo.ReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderController {
    public static void create(Order order){
        EntityManager entityManager = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(entityManager);

        entityManager.getTransaction().begin();
        orderDao.save(order);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public  static BigDecimal getTotalValue(){
        return new OrderDao(JPAUtil.getEntityManager()).getTotalValue();
    }

    public  static List<ReportVo> getReportInformation(){
        return new OrderDao(JPAUtil.getEntityManager()).getReportInformation();
    }
    public  static Order findOrderAndCustomerById(Long id){
        EntityManager entityManager = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(entityManager);

        entityManager.getTransaction().begin();
        Order orderFound = orderDao.getOrderFullDatas(id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return orderFound;
    }

    public  static Order findById(Long id){
        EntityManager entityManager = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(entityManager);

        entityManager.getTransaction().begin();
        Order orderFound = orderDao.findOrderById(id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return orderFound;
    }
}
