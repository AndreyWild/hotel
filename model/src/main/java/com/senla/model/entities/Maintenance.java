package com.senla.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "maintenances")
public class Maintenance extends AEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    public Maintenance(Maintenance maintenance) {
        setId(maintenance.getId());
        this.name = maintenance.getName();
        this.price = maintenance.getPrice();
    }

    @Override
    public String toString() {
        return id + ". Maintenance: " + name + ' ' + price + '$';
    }
}
