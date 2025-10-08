package sp25_bcs_013;


public class Seat{
SeatType seatType;
String id;
double price;
boolean isAvailable;
static int counter=0;
public enum SeatType{RECLINER,VIP,PREMIUM,REGULAR};
Seat(){}
Seat(int x,int y,double price,SeatType seatType){
counter++;
this.id=String.format("%03d",counter);
this.price=price;
this.seatType=seatType;
this.isAvailable=true;
}
public void setprice(double newprice){
price=newprice;
}
public double getprice(){
return price;
}
public void setseatType(SeatType newseattype){
seatType=newseattype;
}
public SeatType getseatType(){
return seatType;
}
public String getid(){
return id;
}
public boolean isAvailable(){
 return isAvailable;
}
public void Bookseat(){
 if(isAvailable==true)
   isAvailable=false;
}
public void CancelBooking(){
if(isAvailable==false){
  isAvailable=true;
}
}
@Override
public String toString(){
return "ID: "+id +" SeatType: "+ seatType+ " Price: "+price+" Available: "+isAvailable;

}
}