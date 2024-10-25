
package com.store.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findCategoryByName", query = "SELECT c FROM Category c WHERE c.name = :name")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public  Category(){}
    public Category(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
