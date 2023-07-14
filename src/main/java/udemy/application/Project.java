package udemy.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import udemy.entities.Reservation;
import udemy.exceptions.DomainException;

public class Project {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date(dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reserva = new Reservation(number, checkIn, checkOut);

            System.out.println("Enter date to update the reservation");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date(dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.updateDates(checkIn, checkOut);

            System.out.println("Reservation: "+ reserva);
        }catch(ParseException e){
            System.out.println("Invalid date format");
        }catch(DomainException e){
            System.out.println("Error in Reservation: " + e.getMessage());
        }
        //causando uma uppercasting
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
        
        sc.close();
    }
}
