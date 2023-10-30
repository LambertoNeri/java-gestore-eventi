package org.lessons.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Concert extends Event{
    private LocalTime time;
    private BigDecimal price;


    public Concert(String title, LocalDate date, int totalSeat, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(title, date, totalSeat);
        this.time = time;
        this.price = price;
    }

    public LocalDateTime getLocalDateTime() {
        LocalDateTime e = super.getDate().atTime(this.time);
        return e;
    }

    public String getFormattedPrice() {

        return this.price.setScale(2, RoundingMode.HALF_EVEN) + "€";

    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "L'evento: "+getTitle()+"\n si terrà in data: "+getLocalDateTime()+"\n Costo biglietto: "+ getFormattedPrice();
    }
}
