package org.lessons.java;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");



        System.out.println("Benvenuto nel creatore di eventi Lamberto Inc.");
        System.out.println("Siete pregati di seguire le istruzioni a schermo per creare un nuovo evento: ");
        System.out.println("Step 1) Inserire il titolo dell'evento");
        String title = scanner.nextLine();
        String dateStr = "";
        LocalDate date = LocalDate.parse("01/01/2023", formatter);
        boolean success = false;
        while (success == false) {
            try {
                System.out.println("Step 2) Inserire la data nel quale si desidera ogranizzare l'evento (dd/mm/yyyy)");
                dateStr = scanner.next();

                date = LocalDate.parse(dateStr, formatter);
                scanner.nextLine();
            } catch (DateTimeParseException e) {
               if (dateStr.contains("-")) {
                   System.out.println("Perfavore inserire la data nel formato utilizzando / e non - come divisorio" );
               }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        System.out.println("Step 3) Inserire il numero totale di posti prenotabili");
        int totalSeat = scanner.nextInt();
        scanner.nextLine();
        Event event1 = new Event(title, date, totalSeat);


    System.out.println(event1);



    }
}
