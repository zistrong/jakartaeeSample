package com.zistrong.jakartaee.entitiy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
@Cacheable
public class EmployeeAddress implements Serializable {
    @Id
    @Column(columnDefinition = "bigint")
    private Long id;

    private String name;
}
