
package com.store.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_value")
    private BigDecimal totalValue = BigDecimal.ZERO;
    private LocalDate date = LocalDate.now();
    @ManyToOne(fetch = FetchType.LAZY) // Todos os relacionamentos *ToOne são EAGER, fazem un join com a entidade relacionada
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemsOrdered> items = new ArrayList<>();

    public Order(){}

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addItem(ItemsOrdered itemsOrdered){
        itemsOrdered.setOrder(this);
        this.items.add(itemsOrdered);
        this.totalValue = this.totalValue.add(itemsOrdered.getValue());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ItemsOrdered> getItems() {
        return items;
    }
}
