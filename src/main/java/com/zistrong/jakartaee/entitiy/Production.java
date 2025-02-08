package com.zistrong.jakartaee.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Production.queryByName", query = "select p from Production p where p.name = :name"),
        @NamedQuery(name = "Production.queryById", query = "select p from Production p where p.id = :id")}
)
public class Production implements Serializable {
    @Id
    private Long id;

    @NotNull
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
