package org.acme.model;

import java.time.LocalDate;


public class RentalDTO
{

    private Long id;
    private Long customerId;
    private Long carId;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public RentalDTO() {}

    public RentalDTO(Long id, Long customerId, Long carId, LocalDate rentalDate, LocalDate returnDate) {
        this.id = id;
        this.customerId = customerId;
        this.carId = carId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
