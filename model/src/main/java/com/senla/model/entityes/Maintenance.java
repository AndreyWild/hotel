package com.senla.model.entityes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "maintenance")
public class Maintenance extends AEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

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
