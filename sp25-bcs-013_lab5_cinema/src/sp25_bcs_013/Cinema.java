package sp25_bcs_013;


public class Cinema{
String Cinemaname;
Screen screens[];
int defaultscreens=0;
int count=0;

Cinema(String Cinemaname,int defaultscreens,int defaultrows){
this.defaultscreens=defaultscreens;
this.Cinemaname=Cinemaname;
this.screens=new Screen[defaultscreens];
for(int i=0;i<screens.length;i++){
screens[i]=new Screen("screen: "+(i+1),defaultrows);
count++;
}
}

public void addScreen(String screenname,int rows){
if(count==screens.length){
Screen[] temp=new Screen[screens.length+5];
for(int i=0;i<screens.length;i++){
temp[i]=screens[i];
}
screens=temp;
}
screens[count]=new Screen(screenname,rows);
count++;
}

public Screen findScreenByName(String sname){
for(int i=0;i<screens.length;i++){
if(screens[i].ScreenName.equals(sname)){
return screens[i];
}
}
return null;
}

public Screen findScreenByIndex(int index){
return screens[index];
}

public boolean book(String screenname,String seatid){
for(int i=0;i<screens.length;i++){
if(screens[i].ScreenName.equals(screenname)){
 return screens[i].book(seatid);
}
}
return false;
}

public boolean cancel(String screenname,String seatid){
for(int i=0;i<screens.length;i++){
if(screens[i].ScreenName.equals(screenname)){
return screens[i].cancel(seatid);
}
}
return false;
}

public int getTotalSeats(){
int total=0;
for(int i=0;i<screens.length;i++){
if(screens[i]!=null){
 total+=screens[i].getTotalSeatCount();
}
}
return total;
}


public int getAvailableSeats(){
int total=0;
for(int i=0;i<screens.length;i++){
if(screens[i]!=null){
total+=screens[i].getAvailibleSeatCount();
}
}
return total;
}


public int getAvailableSeats(Seat.SeatType type){
int total=0;
for(int i=0;i<screens.length;i++){
if(screens[i]!=null){
total+=screens[i].getAvailableSeatCount(type);
}
}
return total;
}

public void displayAllLayouts(){
for(int i=0;i<screens.length;i++){
if(screens[i]!=null){
System.out.println("for screen "+(i+1)+":");
screens[i].displayLayout();
}
}
}

public void displayAllVerbose(){
for(int i=0;i<screens.length;i++){
if(screens[i]!=null){
System.out.println("for screen "+(i+1)+":");
screens[i]. displayVerbose();
}
}
}

@Override
public String toString(){
return "Cinema: "+Cinemaname+" Screens: "+count+" Total seats: "+getTotalSeats()+" Available seats: "+getAvailableSeats();
}
}