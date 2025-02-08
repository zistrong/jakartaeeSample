package com.zistrong.jakartaee.service;


import com.zistrong.jakartaee.entitiy.Production;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@Stateless
public class FirstService implements Serializable {


    @Inject
    private DemoItem demoItem;

    @Inject
    private Demo2Item demo2Item;

    @PersistenceContext(unitName = "jee")
    EntityManager entityManager;

    public String now() {

        Object date =  entityManager.createNativeQuery("select now()").getSingleResult();

        return String.valueOf(date);
    }

    public void save(Production production) {
        entityManager.persist(production);
    }

    public List<Production> getProductions() {
        demoItem.list();
        demo2Item.list();
        return entityManager.createQuery("select a from Production a", Production.class).getResultList();
    }

}
