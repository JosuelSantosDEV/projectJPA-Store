

package com.store.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items_ordered")
public class ItemsOrdered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public  ItemsOrdered(){}
    public ItemsOrdered(int quantity, Order order, Product product) {
        this.quantity = quantity;
        this.order = order;
        this.product = product;
        this.unitPrice = product.getPrice();
    }

    public BigDecimal getValue(){
        return this.unitPrice.multiply(new BigDecimal(this.quantity));
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
