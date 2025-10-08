package sp25_bcs_013;


import java.util.Arrays;
public class Screen{
Seat seats[][];
double PRICE_REGULAR;
double PRICE_VIP;
double PRICE_RECLINER;
double PRICE_PREMIUM;
int DEFAULT_NUM_ROWS;
String ScreenName;
int num;
Screen(){}

Screen(String ScreenName,int num){
this.ScreenName=ScreenName;
this.num=num;
this.seats=new Seat[num][];
for(int i=0;i<num;i++){
seats[i]=new Seat[i+1];
for(int j=0;j<seats[i].length;j++){
 seats[i][j]=new Seat(i,j,500,Seat.SeatType.VIP);
}
}
}

public String getScreenName(){
return ScreenName;
}

public int getAvailibleSeatCount(){
int count=0;

for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j].isAvailable==true){
count++;
}
}
}
 return  count;
}

public int getTotalSeatCount(){
int totalseats=0;
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
totalseats++;
}
}
return totalseats;
}


public Seat getSeat(String seatid){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j].id.equals(seatid)){
return seats[i][j];
}
}
}
return null;
}


public Seat getSeat(int row,int column){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j]==seats[row][column]){
return seats[i][j];
}
}
}
return null;
}


public boolean book(String Seatid){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j].id.equals(Seatid)){
 if(seats[i][j].isAvailable){
  seats[i][j].isAvailable=false;
  return true;
}
}
}
}
return false;
}


public boolean cancel(int r,int c){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j]==seats[r][c]){
if(seats[i][j].isAvailable==false){
  seats[i][j].isAvailable=true;
  return true;
}
}
}
}
return false;
}


public void checkRow(int row){
for(int i=row;i==row;i++){
for(int j=0;j<seats[i].length;j++){
 System.out.println("Seat ID: "+seats[i][j].id+ " Availability: "+seats[i][j].isAvailable);
}
}
}

public boolean cancel(String seatid){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j].id.equals(seatid)){
 if(seats[i][j].isAvailable==false){
  seats[i][j].isAvailable=true;
  return true;
}
}
}
}
return false;
}


public boolean book(int r,int c){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j]==seats[r][c]){
  if(seats[i][j].isAvailable==true){
   seats[i][j].isAvailable=false;
   return true;
}

}
}
}
return false;
}

public void checkBounds(int r,int c){
if(r>=0 && r<num && c>=0 && c<num){
System.out.println("valid index");
}
else{
System.out.println("invalid index");
}
}

public int getAvailableSeatCount(Seat.SeatType s){
int count=0;
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j].isAvailable){
if(seats[i][j].seatType==s){
count++;
}
}
}
}
return count;
}

public void setRowType(int row,Seat.SeatType s,double price){
for(int i=row;i==row;i++){
for(int j=0;j<seats[i].length;j++){
 seats[i][j].seatType=s;
 seats[i][j].price=price;
}
}
System.out.println("Row number: "+ row+", SeatType: "+ s+", Price: "+price);
}

public void displayVerbose(){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
 System.out.println(seats[i][j]);
}
}

}

public Seat findFirstAvailable(Seat.SeatType type){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
 if(seats[i][j].seatType==type){
  if(seats[i][j].isAvailable){
   return seats[i][j];
}
}
}
}
return null;
}

public int[] buildDefaultRowLengths(int rownum){
int rowlength[]=new int[rownum];
for(int i=0;i<rownum;i++){
int count=0;
for(int j=0;j<seats[i].length;j++){
count++;
}
rowlength[i]=count;
}
Arrays.toString(rowlength);
return rowlength;
}

public double priceFor(Seat.SeatType type){
if(type==Seat.SeatType.REGULAR){
 return 500;
}
else if(type==Seat.SeatType.PREMIUM){
 return 750;
}
else if(type==Seat.SeatType.VIP){
 return 1000;
}
else if(type==Seat.SeatType.RECLINER){
 return 1200;
}
else{

 return 0;}
}

public int getRowLength(int row){
int count=0;
for(int i=row;i==row;i++){
for(int j=0;j<seats[i].length;j++){
count++;
}
}
return count;
}

public int getRowCount(){
int count=0;
for(int i=0;i<num;i++)
{
count++;
}
return count;
}

public Seat.SeatType seatTypeFor(int r, int c){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(seats[i][j]==seats[r][c]){
return seats[i][j].seatType;
}
}
}
return null;
}

public Seat[] listAvailable(Seat.SeatType type){
int count=0;
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(type==seats[i][j].seatType){
 if(seats[i][j].isAvailable){
 count++;
}
}
}
}
Seat list[]=new Seat[count];
int n=0;
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
if(type==seats[i][j].seatType){
 if(seats[i][j].isAvailable){
  list[n++]=seats[i][j];
}
}
}
}
for(int i=0;i<count;i++){
System.out.println(list[i]);
}
return list;
}

public void displayLayout(){
for(int i=0;i<num;i++){
for(int j=0;j<seats[i].length;j++){
 if(seats[i][j].isAvailable){
  System.out.print(" o ");
}
else{
 System.out.print(" x ");
}
}
System.out.println(" ");
}
}
}