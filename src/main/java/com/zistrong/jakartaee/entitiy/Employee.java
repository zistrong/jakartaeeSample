package com.zistrong.jakartaee.entitiy;

import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Cacheable
public class Employee implements Serializable {

    @Id
    @Column(columnDefinition = "bigint")
    private Long id;

    private String name;

    @OneToOne
    @BatchFetch(BatchFetchType.JOIN)
    private EmployeeAddress employeeAddress;


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

    public EmployeeAddress getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddress employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}
