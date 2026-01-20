
package src;
public class Screen{
    Seat[][]seats;
    String screenname;

    private static final int DEFAULT_NUM_ROWS=10;
    private static final double PRICE_REGULAR=500;
    private static final double PRICE_PREMIUM=800;
    private static final double PRICE_VIP=1000;
    private static final double PRICE_RECLINER=1500;

    public Screen(String name,int[]rowlengths) {
        this.screenname=name;
        seats=new Seat[rowlengths.length][];
        for(int i=0;i<rowlengths.length;i++){
            seats[i]=new Seat[rowlengths[i]];
            for(int j=0;j<rowlengths[i];j++){
                String id=String.format("%d-%03d", i + 1, j + 1);

                Seat.Seattype type;
                double price;

                if (i == rowlengths.length - 1) {   
                     type = Seat.Seattype.RECLINER;      
                    price =PRICE_RECLINER;
                } else if (i == rowlengths.length - 2) {   
                    type = Seat.Seattype.VIP;
                    price = PRICE_VIP;
                } else if (i >= rowlengths.length / 2) {   
                    type = Seat.Seattype.PREMIUM;
                    price = PRICE_PREMIUM;
                } else {                                   
                    type = Seat.Seattype.REGULAR;
                    price = PRICE_REGULAR;
                }
                seats[i][j] = new Seat(id,price,type,true);
            }
        }
    }

    public Screen(String name, int totalRows) {
        this(name, buildDefaultRowLengths(totalRows));
    }

    public Screen(String name) {
        this(name, new int[]{10, 11, 12, 13, 14});
        this.screenname = name;
    }

    public static int[] buildDefaultRowLengths(int rowCount) {
        int[] lengths = new int[rowCount];
        for (int i = 0; i < rowCount; i++) {
            lengths[i] = 10 + i;
        }
        return lengths;
    }

    public Seat.Seattype Seattypefor(int r,int totalrow){
        if (r == totalrow - 1) {
            return Seat.Seattype.RECLINER;
        } else if (r == totalrow - 2) {
            return Seat.Seattype.VIP;
        } else if (r >= totalrow / 2) {
            return Seat.Seattype.PREMIUM;
        } else {
            return Seat.Seattype.REGULAR;
        }
    }

    private double pricefor(Seat.Seattype type) {
        switch (type) {
            case REGULAR: return 500;
            case PREMIUM: return 750;
            case VIP: return 1000;
            case RECLINER: return 1200;
            default: return 500;
        }
    }

    public boolean book(int r,int c){
        if(checkBounds(r,c)){
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

    public boolean book(String id){
        Seat seat=getSeat(id);
        if(seat.isAvailable()){
            seat.setAvailable(false);
            return true;
        }
        else{
            System.out.println("Seats not found");
        }
        return false;
    }

    public boolean cancel(int r,int c){
        if(checkBounds(r,c)){
            if(!seats[r][c].isAvailable()){
                seats[r][c].setAvailable(true);
                return true;
            }
            else{
                System.out.println("Seats already booked");
            }
        }
        return false;
    }

    public boolean cancel(String id){
        Seat seat=getSeat(id);
        if(!seat.isAvailable()){
            seat.setAvailable(true);
            return true;
        }
        else{
            System.out.println("Seats not found or already book");
            return false;
        }
    }

    public boolean checkRow(int row){
        if(row>=0&&row<seats.length){
            return true;
        }
        System.out.println("Invalid row index:"+row);
        return false;
    }

    public boolean checkBounds(int r,int c){
        if(!checkRow(r)){
            return false;
        }
        if(c>=0&&c<seats[r].length){
            return true;
        }
        System.out.println("invalid seat column index:"+c);
        return false;
    }


    public String getScreenName(){
        return screenname;
    }


    public Seat getSeat(String seatid){
        for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                if(seats[i][j].getid().equals(seatid)){
                    return seats[i][j];
                }
            }
        }
        return null;
    }

    public Seat getSeat(int row, int col) {
        if (checkBounds(row, col)) {
            return seats[row][col];
        }
        return null;
    }


    public int getAvailableSeatCount() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }



    public int getTotalSeatCount() {
        int total = 0;
        for (int i = 0; i < seats.length; i++) {
            total += seats[i].length;
        }
        return total;
    }



    public int getTotalSeatsByType(Seat.Seattype type) {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].getseattype()==type) {
                    count++;
                }
            }
        }
        return count;
    }


    public void displayVerbose() {
        System.out.println("Screen: " +getScreenName());
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.println(seats[i][j]);
            }
        }
    }

    public void displayLayout() {
        System.out.println("--" +getScreenName() + " | Layout --");

        for (int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++){
                Seat seat = seats[i][j];

            String status = seat.isAvailable() ? "A" : "B";

            System.out.printf("[%d-%03d:%s] ", i + 1, j + 1, status);

            System.out.printf("%s",seat.getseattype());
            System.out.println();
        }

        System.out.println("Total: " + getTotalSeatCount() +
                ", Available: " + getAvailableSeatCount());
    }
        }

    @Override
    public String toString() {
        return "Screen: " +getScreenName() +
                "  Total Seats: " + getTotalSeatCount() +
                "  Available: " + getAvailableSeatCount();

    }
}

