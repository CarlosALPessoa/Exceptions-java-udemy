package udemy.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import udemy.entities.Reservation;

public class Project {

    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date(dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after Check-in date!");
        } else{
            Reservation reserva = new Reservation(number, checkIn, checkOut);
            System.out.print("Do you want to change the reservation date?(Yes/No)");
            String resp = sc.next();
            
            if(resp == "Yes"){
                System.out.println("Enter date to update the reservation");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date(dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                
                String error = reserva.updateDates(checkIn, checkOut);
                if(error != null){
                    System.out.println("Error in reservation: " + error);
                }
                else{
                    System.out.println("Reservation: "+ reserva);
                }
            }
        }
    }
}
