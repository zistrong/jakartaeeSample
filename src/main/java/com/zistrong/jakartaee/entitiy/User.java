package com.zistrong.jakartaee.entitiy;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity()
@Table(
        name = "users"
)
@Cacheable
public class User implements Serializable {

    @Id
    @Column(columnDefinition = "bigint")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;

    @OneToOne
    private Address address;


    private String name;

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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
