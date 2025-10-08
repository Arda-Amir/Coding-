public class Screen{
Seat seats[][];
String name;

Screen(String name,int n){
this.name=name;
seats=new Seat[3][];
for(int i=0;i<seats.length;i++){
 seats[i]=new Seat[2+i];
  for (int j=0;j<seats[i].length;j++){
    seats[i][j]=new Seat(i,j,500,"IMAX");
}

}
}
public String toString(){
StringBuilder str=new StringBuilder();
str.append(name);
for(int i=0;i<seats.length;i++){
for(int j=0;j<seats[i].length;j++){
str.append("\n" +seats[i][j].toString());
}
}
return str.toString();

}
}