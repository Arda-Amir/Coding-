public class Book{
String id;
String name;
Genre genre;
static int counter=0;
Book(String name,Genre genre){
counter++;
this.id=String.format("%03d",counter);
this.name=name;
this.genre=genre;

}
public String toString(){
return "ID: "+id+" Name: "+name+" Genre: "+genre;
}
@Override
public boolean equals(Object o){
Book read=(Book)o;
return this.id.equals(read.id);
}
}