

package com.store.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable // Indica que essa classe pode ser imbutida em uma entidade. Pode ser usada como id composto
public class PersonalData implements Serializable {
    private String name;
    private String cpf;

    public PersonalData(){}
    public PersonalData(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;

    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }


}
