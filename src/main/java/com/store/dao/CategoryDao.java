package com.store.dao;

import com.store.models.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    EntityManager entityManager;

    public CategoryDao (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public  void save(Category category){
        this.entityManager.persist(category);
    }
    public  void update(Category category){
        this.entityManager.merge(category);
    }
    public  void delete(Category category){
        category = this.entityManager.merge(category);
        this.entityManager.remove(category);
    }
    public  Category findById(Long id){
        return  this.entityManager.find(Category.class, id);
    }
    public List<Category> listCategory(){
        String jpqlQuery = "SELECT c FROM Category c";
        return  this.entityManager.createQuery( jpqlQuery, Category.class).getResultList();
    }
    public List<Category> listCategoryByName(String name){
        return  this.entityManager.createNamedQuery( "Category.findCategoryByName", Category.class).setParameter("name", name).getResultList();
    }
}
