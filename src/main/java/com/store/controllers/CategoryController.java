package com.store.controllers;

import com.store.dao.CategoryDao;
import com.store.models.Category;
import com.store.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryController {
    public static void create(Category category){
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        entityManager.getTransaction().begin();
        categoryDao.save(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public  static  Category  findById(Long id){
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);
        
        Category category = categoryDao.findById(id);
        entityManager.close();
        return category;
    }

    public  static  List<Category>  list(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        List<Category> categories = categoryDao.listCategory();
        entityManager.close();
        return categories;
    }

    public  static  List<Category>  list(String name){
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        List<Category> categories = categoryDao.listCategoryByName(name);
        entityManager.close();
        return categories;
    }
}

