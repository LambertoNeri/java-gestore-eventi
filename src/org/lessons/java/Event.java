package org.lessons.java;

import org.w3c.dom.Text;

import java.time.LocalDate;

public class Event {
    public static int DEFAULT_RESERVED_SEAT = 0;
    private String title;
    private LocalDate date;
    private int totalSeat;
    private int reservedSeat;

    public Event(String title, LocalDate date, int totalSeat) throws IllegalArgumentException{
        if (dateCheck(date) == false) {
            throw new IllegalArgumentException("La data dell'evento non è valida");
        } else {
            this.date = date;
        }

        if ( positiveSeat(totalSeat) == false ) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere maggiore di 0");
        } else {
            this.totalSeat = totalSeat;
        }

        this.title = title;
        this.reservedSeat = DEFAULT_RESERVED_SEAT;

    }

    // METODI PRIVATI DI CONTROLLO DATA E POSTI TOTALI
    private boolean dateCheck(LocalDate date) {
        boolean isAfter = date.isAfter(LocalDate.now().minusDays(1));
        return isAfter;
    }

    private boolean positiveSeat( int totalSeat) {
        if (totalSeat <= 0 ) {
            return false;
        } else {
            return true;
        }
    }

    //METODI PUBBLICI
    public void makeReservation(int reservedSeat) throws IllegalArgumentException{
        if(dateCheck(date) == false) {
            throw new IllegalArgumentException("L'evento selezionato ha già avuto luogo");
        } else if (reservedSeat <= 0) {
            throw new IllegalArgumentException("il numero inserito di posti da prenotare deve essere maggiore di 0");
        } else if (reservedSeat + this.reservedSeat > totalSeat) {
            throw new IllegalArgumentException("Il numero massimo di posti prenotabili è " + (totalSeat - this.reservedSeat));
        } else {
            this.reservedSeat += reservedSeat;
        }
    }

    public void cancelReservation (int cancelReservedSeat) throws IllegalArgumentException {
        if(dateCheck(date) == false) {
            throw new IllegalArgumentException("L'evento selezionato ha già avuto luogo");
        } else if (reservedSeat - cancelReservedSeat < 0) {
            throw new IllegalArgumentException("Il numero massimo di posti cancellabili è " + (reservedSeat));
        } else {
            this.reservedSeat -= cancelReservedSeat;
        }
    }

    @Override
    public String toString() {
        return date + " - " + title;
    }

    //GETTERS AND SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        dateCheck(date);
        this.date = date;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public int getReservedSeat() {
        return reservedSeat;
    }
}
