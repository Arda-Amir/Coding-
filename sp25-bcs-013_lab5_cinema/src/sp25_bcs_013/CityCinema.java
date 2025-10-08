package sp25_bcs_013;


public class CityCinema{
String cityname;
Cinema cinemas[];
int count=0;

CityCinema(String cityname,int defaultcinemas, int defaultscreens, int defaultrows){
this.cityname=cityname;
this.cinemas=new Cinema[defaultcinemas];
for(int i=0;i<cinemas.length;i++){
cinemas[i]=new Cinema("Cinema "+(i+1)+": ",defaultscreens,defaultrows);
count++;
}
}

public void addCinema(String name,int screens,int row){
if(count==cinemas.length){
Cinema[] temp=new Cinema[cinemas.length+5];
for(int i=0;i<cinemas.length;i++){
temp[i]=cinemas[i];
}
cinemas=temp;
}
cinemas[count]=new Cinema(name,screens,row);
count++;
}

public boolean removeCinema(String name){
for(int i=0;i<count;i++){
if(cinemas[i]!=null && cinemas[i].Cinemaname.equals(name)){
cinemas[i]=cinemas[count-1];
cinemas[count-1]=null;
count--;
return true;
}
}
return false;
}


public Cinema findCinemaByName(String name){
for(int i=0;i<count;i++){
if(cinemas[i].Cinemaname.equals(name)){
 return cinemas[i];
}
}
return null;
}

public boolean book(String cname,String sname,String sid){
for(int i=0;i<count;i++){
if(cinemas[i]!=null){
if(cinemas[i].Cinemaname.equals(cname)){
 return cinemas[i].book(sname,sid);
}
}
}
return false;
}

public boolean cancel(String cname,String sname,String sid){
for(int i=0;i<count;i++){
if(cinemas[i]!=null){
if(cinemas[i].Cinemaname.equals(cname)){
return cinemas[i].cancel(sname,sid);

}
}
}
return false;
}

public int getTotalSeats(){
int num=0;
for(int i=0;i<count;i++){
if(cinemas[i]!=null){
num+=cinemas[i].getTotalSeats();
}
}
return num;
}

public int getAvailableSeats(){
int num=0;
for(int i=0;i<count;i++){
if(cinemas[i]!=null){
num+=cinemas[i].getAvailableSeats();
}
}
return num;
}

public int getAvailableSeats(Seat.SeatType s){
int num=0;
for(int i=0;i<count;i++){
if(cinemas[i]!=null){
 num+=cinemas[i].getAvailableSeats(s);

}
}
return num;
}

public String findFirstAvailableVIPseat(){
for(int i=0;i<count;i++){
Cinema cinema=cinemas[i];
for(int j=0;j<cinema.screens.length;j++){
Screen screen=cinema.screens[j];
Seat seat=screen.findFirstAvailable(Seat.SeatType.VIP);
if(seat!=null){
return cinema.Cinemaname+">"+ screen.getScreenName()+">  Seat:"+seat.getid()+"(VIP "+ seat.getprice()+ "PKR)";
}
}
}
return "No available seats";
}
@Override
public String toString(){
return "CityCinema: "+cityname+" Cinemas: "+count+ " Total Seats: "+getTotalSeats()+" Available seats: "+getAvailableSeats();
}
}