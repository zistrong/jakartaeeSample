package com.zistrong.jakartaee.entitiy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
@Cacheable
public class Phone implements Serializable {
    @Id
    @Column(columnDefinition = "bigint")
    private Long id;
    private String name;


    public Phone() {
    }

    public Phone(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
