package udemy.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import udemy.exceptions.DomainException;

public class Reservation {
    public Integer roomNumber;
    public Date checkIn;
    public Date checkOut;
    
    //Como vamos precisar somente de um, coloco static
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(){}
    
    //Com RuntimeException não precisarei propagar
    //throws DomainException
    public Reservation (Integer roomNumber, Date checkIn, Date checkOut){
        if(!checkOut.after(checkIn)){
            throw  new DomainException("Check-out date must be after Check-in date");
        }
        
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
    
    //propagando a excessão 
    public void  updateDates(Date checkIn, Date checkOut) throws DomainException{
        Date now = new Date();
        
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if(!checkOut.after(checkIn)){
            throw  new DomainException("Check-out date must be after Check-in date");
        }
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
