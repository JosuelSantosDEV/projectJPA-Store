

package com.store.models;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
    private String author;
    private int pageQuantity;

    public Book(){}

    public Book( String author, int pageQuantity) {
        this.author = author;
        this.pageQuantity = pageQuantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }
}
