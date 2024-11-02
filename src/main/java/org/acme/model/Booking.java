package org.acme.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;
    private LocalDateTime date_time;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anvandare_id", nullable = false)
    @JsonBackReference
    private Anvandare anvandare;

    public Booking() {
    }

    public Booking(LocalDateTime date_time, Anvandare anvandare) {
        this.date_time = date_time;
        this.anvandare = anvandare;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public Anvandare getAnvandare() {
        return anvandare;
    }

    public void setAnvandare(Anvandare anvandare) {
        this.anvandare = anvandare;
    }
}
