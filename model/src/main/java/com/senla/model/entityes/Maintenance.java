package com.senla.model.entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "maintenance")
public class Maintenance extends AEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Maintenance() {
    }

    public Maintenance(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Maintenance(Maintenance maintenance) {
        setId(maintenance.getId());
        this.name = maintenance.getName();
        this.price = maintenance.getPrice();
    }

    @Override
    public String toString() {
        return id +". Maintenance: " + name + ' ' + price + '$';
    }
}
