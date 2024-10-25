

package com.store.models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Embedded // Indica para a JPA que ela deve imbutir aqui a classe seguinte
    private PersonalData personalData;

    public Customer(){}

    public Customer(String name, String cpf) {
        this.personalData = new PersonalData(name, cpf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.personalData.getName();
    }

    public String getCpf() {
        return this.personalData.getCpf();
    }

}
