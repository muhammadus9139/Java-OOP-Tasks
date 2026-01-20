package src;
public class CityCinema{
    String cityname;
    Cinema cinemas[];

   public CityCinema(String name,int n){
        this.cityname=name;
        cinemas=new Cinema[n];
        for(int i=0;i<cinemas.length;i++){
            cinemas[i]=new Cinema("Cinema:"+i,50);
        }
    }


    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append(cityname);
        for(int i=0;i<cinemas.length;i++){
            str.append("++++++++++++++++++++++++++++++++++++++");
            str.append("\n"+cinemas[i].toString());
        }
        return str.toString();
    }
}
