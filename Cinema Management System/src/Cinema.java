package src;
public class Cinema{
    Screen screens[];
    String cinemaname;
    Seat[][]seats;

    public Cinema(String name,int n){
        this.cinemaname=name;
        screens = new Screen[n];
        for (int i = 0; i < n; i++) {
            screens[i] = new Screen("Screen-" + (i+1)); 
        }
    }


    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append(cinemaname);
        for(int i=0;i<screens.length;i++){
            str.append(screens[i].toString());
            str.append("\n");
            screens[i].displayLayout();
        }
        return str.toString();
    }

   public boolean book(int r,int c){
          {
            if(seats[r][c].isAvailable()){
                seats[r][c].setAvailable(false);
                return true;
            }
            else{
                System.out.println("Seats already booked");
            }
        }
        return false;
    } 

}

