package udemy.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    public Integer roomNumber;
    public Date checkIn;
    public Date checkOut;
    
    //Como vamos precisar somente de um, coloco static
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(){}
    
    public Reservation (Integer roomNumber, Date checkIn, Date checkOut){
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        //Converter milissegundos do getTime
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
    }
    
    public String updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        
        if(checkIn.before(now) || checkOut.before(now)){
            return "Reservation dates for update must be future dates";
        }
        if(!checkOut.after(checkIn)){
            return  "Check-out date must be after Check-in date";
        }
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }
    
    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + duration() + " nights";
    }
}
