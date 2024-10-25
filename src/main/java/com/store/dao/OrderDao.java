
package com.store.dao;

import com.store.models.Order;
import com.store.vo.ReportVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDao {

    private final EntityManager entityManager;

    public OrderDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void save(Order order){
        this.entityManager.persist(order);
    }
    public BigDecimal getTotalValue(){
        String jpqlQuery = "SELECT SUM(ord.totalValue) FROM Order ord";
        return entityManager.createQuery(jpqlQuery, BigDecimal.class).getSingleResult();
    }
    public List<ReportVo> getReportInformation(){
        String jpqlQuery = "SELECT new com.store.vo.ReportVo(product.name, SUM(item.quantity), MAX(order_.date)) " +
                "FROM Order order_ " +
                "JOIN order_.items item JOIN item.product product " +
                "GROUP BY product.name " +
                "ORDER BY item.quantity DESC";
        return entityManager.createQuery(jpqlQuery, ReportVo.class).getResultList();
    }
    public  Order getOrderFullDatas(Long id){
        String jpqlQuery = "SELECT ord FROM Order ord JOIN FETCH ord.customer JOIN FETCH ord.items ord_item JOIN FETCH ord_item.product WHERE ord.id = :id"; // JOIN FETCH para evitar o LazyInitializationException
        return entityManager.createQuery(jpqlQuery, Order.class).setParameter("id", id).getSingleResult();
    }
    public  Order findOrderById(Long id){
        String jpqlQuery = "SELECT ord FROM Order ord WHERE ord.id = :id";
        return entityManager.createQuery(jpqlQuery, Order.class).setParameter("id", id).getSingleResult();
    }

}
