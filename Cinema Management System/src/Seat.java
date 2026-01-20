package src;
public class Seat{

    public enum Seattype{
        REGULAR,VIP,PREMIUM,RECLINER;

    }

    private String SeatID;
    private double price;
    private Seattype seattype;
    private boolean isAvailable;



    public Seat(String id,double price,Seattype seattype,boolean available){
        this.SeatID=id;
        this.price=price;
        this.seattype=seattype;
        this.isAvailable=available;
    }



    @Override
    public String toString(){
        return String.format("%s %.2f %s %b",SeatID,price,seattype,isAvailable);

    }

    public boolean bookseat(){
        return isAvailable;
    }

    public String getid(){
        return SeatID;
    }


    public boolean isAvailable(){
        return isAvailable;
    }


    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }


    public double getprice(){
        return price;
    }


    public boolean cancelbooking(){
        return isAvailable;
    }

    public void setprice(double price){
        this.price=price;
    }


    public void setSeattype(Seattype seattype){
        this.seattype=seattype;
    }

    public Seattype getseattype(){
        return seattype;
    }
}


