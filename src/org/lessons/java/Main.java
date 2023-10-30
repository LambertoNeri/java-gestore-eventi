package org.lessons.java;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/01/2023", formatter);
        String dateStr = "";
        int totalSeat = 0;



        System.out.println("Benvenuto nel creatore di eventi Lamberto Inc.");
        System.out.println("Siete pregati di seguire le istruzioni a schermo per creare un nuovo evento: ");
        System.out.println("Step 1) Inserire il titolo dell'evento");
        String title = scanner.nextLine();


        boolean success = false;
            while( success == false ) {
                try {
                    System.out.println("Step 2) Inserire la data nel quale si desidera ogranizzare l'evento (dd/mm/yyyy)");
                    dateStr = scanner.next();
                    date = LocalDate.parse(dateStr, formatter);
                    scanner.nextLine();
                    System.out.println("Step 3) Inserire il numero totale dei posti prenotabili");
                    totalSeat = scanner.nextInt();
                    scanner.nextLine();

                    success = true;
                } catch (DateTimeParseException e) {
                   if (dateStr.contains("-")) {
                       System.out.println("Perfavore inserire la data nel formato utilizzando '/' e non '-' come divisorio" );
                   } else {
                       System.out.println("perfavore inserire la data nel formato (dd/mm/yyyy)");
                   }
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                } catch (InputMismatchException e) {
                    System.out.println("perfavore inerire un numero come totale dei posti prenotabili");
                    scanner.nextLine();
                }
            }

        Event event1 = new Event(title, date, totalSeat);
        System.out.println(event1);

        String choice = "";
        boolean exit = false;

        while(exit == false) {
            System.out.println("Vuoi riservare posti nell'evento? (y/n)");
            choice = scanner.nextLine();
            if (choice.equals("y") || choice.equals("yes")) {
                boolean exit2 = false;
                while (exit2 == false){
                    try {
                        System.out.println("Quanti posti vuoi riservare?");
                        int addReservedSeat = scanner.nextInt();
                        scanner.nextLine();
                        event1.makeReservation(addReservedSeat);
                        System.out.println("Prenotazione completata: hai prenotato " + addReservedSeat + " posti, disponibilità residua: " + (event1.getTotalSeat() - event1.getReservedSeat()));
                        System.out.println("Vuoi cancellare alcuni posti riservati nella tua prenotazione? (y/n)");
                        boolean exit3 = false;
                        String choice3 = scanner.nextLine();
                        while (exit3 == false ) {
                            if (choice3.equals("y") || choice3.equals("yes")) {
                                try {
                                    System.out.println("Quanti posti vuoi cancellare?");
                                    int cancelReservedSeat = scanner.nextInt();
                                    scanner.nextLine();
                                    event1.cancelReservation(cancelReservedSeat);
                                    System.out.println("Cancellazione completata: hai cancellato un totale di " + cancelReservedSeat + " posti, disponibilità residua: " + (event1.getTotalSeat() - event1.getReservedSeat()));
                                    exit3 = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e);
                                } catch (InputMismatchException e) {
                                    System.out.println("perfavore inserisci un numero");
                                    scanner.nextLine();
                                }
                            } else if (choice3.equals("n") || choice3.equals("no")) {
                                System.out.println("Chiusura programma....");
                                exit3 = true;
                            } else {
                                System.out.println("Scelta non valida scrivere scegliere tra 'y' o 'n'");
                                scanner.nextLine();
                            }
                        }
                        exit2 = true;
                    }catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }catch (InputMismatchException e) {
                        System.out.println("perfavore inserisci un numero");
                        scanner.nextLine();
                    }

                }
                exit = true;

            } else if(choice.equals("n") || choice.equals("no")) {
                System.out.println("Chiusura programma....");
                exit = true;
            } else{
                System.out.println("Scelta non valida scrivere scegliere tra 'y' o 'n'");
            }
        }


        scanner.close();











    }
}
