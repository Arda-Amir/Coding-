public class Seat{
String id;
String seattype;
boolean isAvailible;
double price;
static int counter=0;

Seat(int row,int col,double price,String seattype){
counter++;
this.id=String.format("%03d",counter);
this.price=price;
this.seattype=seattype;
}
public String toString(){
return "ID: "+id+" Seattype: "+seattype+" Price: "+price+" Availability: "+isAvailible;
}
}