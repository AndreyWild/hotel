package com.senla.model.entityes;

import com.senla.model.entityes.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order extends AEntity {

       //todo persist вместо save если нету REMOVE!!!

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_guest")
    private Guest guest;

        //todo persist вместо save если нету REMOVE!!!
//    @ManyToOne(cascade = {CascadeType.PERSIST,
//            CascadeType.MERGE,
//            CascadeType.REFRESH,
//            CascadeType.DETACH},
//            fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY
            /*cascade = CascadeType.REMOVE,
            optional = false*/)
    @JoinColumn(name = "id_room")
//    @Column(nullable=true)
    private Room room;

        //todo persist вместо save если нету REMOVE!!!
//    @OneToMany(cascade = {CascadeType.PERSIST,
//            CascadeType.MERGE,
//            CascadeType.REFRESH,
//            CascadeType.DETACH},
//            fetch = FetchType.LAZY)
    @ManyToMany(fetch = FetchType.LAZY
            /*cascade = CascadeType.ALL*/)
    @JoinTable(name = "ord_maint",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_maintenance"))
    private List<Maintenance> maintenances = new ArrayList<>();

    @Column(name = "check_in", columnDefinition = "DATE")
    private LocalDate checkIn;

    @Column(name = "check_out", columnDefinition = "DATE")
    private LocalDate checkOut;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Order(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Order(Guest guest, Room room) {
        this.guest = guest;
        this.room = room;
    }

    public Order(Guest guest, Room room, List<Maintenance> maintenances) {
        this.guest = guest;
        this.room = room;
        this.maintenances = maintenances;
    }

    public Order(Order order) {
        setId(order.getId());
        this.guest = order.getGuest();
        this.room = order.getRoom();
        this.checkIn = order.getCheckIn();
        this.checkOut = order.getCheckOut();
        this.maintenances = order.getMaintenances();
        this.status = order.getStatus();
    }

    public Order(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void addMaintenanceToOrder(Maintenance maintenance) {
        if (maintenances == null) {
            maintenances = new ArrayList<>();
        } else {
            maintenances.add(maintenance);
        }
    }

    @Override
    public String toString() {
        return super.id +
                ". Order{" +
                "guest=" + guest +
                ", room=" + room +
                ", maintenances=" + maintenances +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", status=" + status +
                '}';
    }
}
