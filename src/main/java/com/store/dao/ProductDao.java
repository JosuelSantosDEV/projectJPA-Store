

package com.store.dao;
import com.store.models.Product;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {

    EntityManager entityManager;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Product product) {
        entityManager.persist(product);
    }

    public void update(Product product) {
        this.entityManager.merge(product);
    }

    public void delete(Product product) {
        product = this.entityManager.merge(product);
        this.entityManager.remove(product);
    }

    public Product findById(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    public List<Product> listProductByCategory(String category) {
        String jpqlQuery = "SELECT p FROM Product p WHERE p.category.name = :category";
        return this.entityManager.createQuery(jpqlQuery, Product.class).setParameter("category", category).getResultList();
    }

    public BigDecimal getPriceByName(String name) {
        String jpqlQuery = "SELECT p.price FROM Product p WHERE p.name = :name";
        return this.entityManager.createQuery(jpqlQuery, BigDecimal.class).setParameter("name", name).getSingleResult();
    }

    public List<Product> getProduct(Long id, String name, BigDecimal price) {
        String jpqlQuery = "SELECT p FROM Product p WHERE 1=1";
        if (id != null) {
            jpqlQuery += "AND p.id = :id";
        }
        if (name != null && !name.trim().isEmpty()) {
            jpqlQuery += "AND p.name = :name";
        }
        if (price != null) {
            jpqlQuery += "AND p.price = :price";
        }
        TypedQuery<Product> query = this.entityManager.createQuery(jpqlQuery, Product.class);
        if (id != null) {
            query.setParameter("id", id);
        }
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (price != null) {
            query.setParameter("price", price);
        }
        return query.getResultList();
    }

    public  List<Product> getProductCriteria(Long id, String name, BigDecimal price) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);
        Predicate andFilters = criteriaBuilder.and();
        if (id != null) andFilters = criteriaBuilder.and(andFilters, criteriaBuilder.equal(from.get("id"), id));
        if (name != null && !name.trim().isEmpty()) {
            andFilters = criteriaBuilder.and(andFilters, criteriaBuilder.equal(from.get("name"), name));
        }
        if (price != null) {
            andFilters = criteriaBuilder.and(andFilters, criteriaBuilder.equal(from.get("price"), price));
        }
        query.where(andFilters);
        return this.entityManager.createQuery(query).getResultList();
    }
}