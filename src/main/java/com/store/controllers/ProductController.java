
package com.store.controllers;
import com.store.dao.ProductDao;
import com.store.models.Product;
import com.store.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductController {
    public static void create(Product product){
        EntityManager entityManager = JPAUtil.getEntityManager();

        ProductDao productDao = new ProductDao(entityManager);

        entityManager.getTransaction().begin();
        productDao.save(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static Product findById(Long id){
        return new ProductDao(JPAUtil.getEntityManager()).findById(id);
    }

    public  static List<Product> list(String categoryName){
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(entityManager);

        List<Product> products = productDao.listProductByCategory(categoryName);
        entityManager.close();

        return products;
    }

    public  static BigDecimal getPriceByName(String productName){
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(entityManager);

        BigDecimal price = productDao.getPriceByName(productName);
        entityManager.close();

        return price;
    }
    public static List<Product> getProduct(Long id, String name, BigDecimal price){
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(entityManager);

        List<Product> products = productDao.getProduct(id, name, price);
        entityManager.close();

        return products;
    }
    public static  List<Product> getProductCriteria(Long id, String name, BigDecimal price){
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(entityManager);

        List<Product> products = productDao.getProductCriteria(id, name, price);
        entityManager.close();

        return products;
    }
}

// states EntityManager
// entityManager.getTransaction().begin(); Transient
// entityManager.persist(product);  Managed
// product = entityManager.merge(product); Managed -- Devolve uma referência com estado Managed para o objeto
// entityManager.close(); Detached
// entityManager.clear(); Detached
// entityManager.getTransaction().commit(); DB -- Confirma as operações no banco -- Continua em Managed apenas as operações no banco é realizada
// entityManager.getTransaction().flush(); DB -- Confirma as operações no banco -- Continua em Managed apenas as operações no banco é realizada
// entityManager.remove(product); // Removed