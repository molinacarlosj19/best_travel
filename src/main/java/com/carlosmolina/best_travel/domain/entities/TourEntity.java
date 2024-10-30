package com.carlosmolina.best_travel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity(name = "tour")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany (
            mappedBy = "tour",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<ReservationEntity> reservations;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany (
            mappedBy = "tour",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<TicketEntity> tickets;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customer;

    public void addTicket(TicketEntity ticket) {
        if(Objects.isNull(this.tickets)) this.tickets = new HashSet<>();
        this.tickets.add(ticket);
    }

    public void removeTicket(UUID id) {
        if(Objects.isNull(this.tickets)) this.tickets = new HashSet<>();
        this.tickets.removeIf(ticket ->ticket.getId().equals(id));
    }

    public void updateTickets(){
        this.tickets.forEach(ticket ->ticket.setTour(this));
    }

    public void addReservation(ReservationEntity reservation) {
        if(Objects.isNull(this.reservations)) this.reservations = new HashSet<>();
        this.reservations.add(reservation);
    }

    public void removeReservation(UUID idReservation) {
        if(Objects.isNull(this.reservations)) this.reservations = new HashSet<>();
        this.reservations.removeIf(reservation -> reservation.getId().equals(idReservation));
    }

    public void updateReservations(){
        this.reservations.forEach(reservation -> reservation.setTour(this));
    }
}




