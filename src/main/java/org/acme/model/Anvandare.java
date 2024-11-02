package org.acme.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "anvandare")
public class Anvandare extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long anvandare_id;

    private String name;


    @OneToMany(mappedBy = "anvandare", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Booking> bookings;

    public Anvandare() {
    }

    public Anvandare(String name) {
        this.name = name;
    }

    public long getAnvandare_id() {
        return anvandare_id;
    }

    public void setAnvandare_id(long user_id) {
        this.anvandare_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
