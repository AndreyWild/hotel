package com.senla.model.entityes;

import com.senla.model.entityes.enums.RoomStars;
import com.senla.model.entityes.enums.RoomStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room extends AEntity {

    @Column(name = "number")
    private Integer number;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "room_status")
    @Enumerated(EnumType.STRING)
    private RoomStatus status = RoomStatus.OPEN;

    @Column(name = "price")
    private Double price;

    @Column(name = "stars")
    @Enumerated(value = EnumType.STRING)
    private RoomStars stars = RoomStars.ONE;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "room")
    private List<Order> orders = new ArrayList<>();

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RoomStars getStars() {
        return stars;
    }

    public void setStars(RoomStars stars) {
        this.stars = stars;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Room() {
    }

    public Room(Integer number, Integer capacity, Double price, RoomStars stars) {
        this.number = number;
        this.capacity = capacity;
        this.price = price;
        this.stars = stars;
    }

    public Room(Room room) {
        setId(room.getId());
        this.number = room.getNumber();
        this.capacity = room.getCapacity();
        this.status = room.getStatus();
        this.price = room.getPrice();
        this.stars = room.getStars();
        this.orders = room.getOrders();
    }

    public void addOrdersToRoom(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        } else {
            orders.add(order);
            order.setRoom(this);
        }
    }

    @Override
    public String toString() {
        return id + ". Room: №" + number + ' ' + capacity + "-persons " + status + ' ' + price + "$ " + stars;
    }
}

