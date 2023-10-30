package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main2 {
    public static void main(String[] args) {
        Concert concerto1 = new Concert("Gino", LocalDate.of(2024, 10, 10), 30, LocalTime.parse("22:30"), new BigDecimal(3.15312312));
        System.out.println(concerto1);
    }




}
