package sp25_bcs_013;


public class CinemaDemo{
public static void main(String[] args){
Cinema cinema = new Cinema("Cinema-1", 2, 3);
System.out.println(cinema);
cinema.book("screen: 1", "001");  
System.out.println("After booking: ");
System.out.println(cinema);
cinema.cancel("screen: 1", "001");
System.out.println("After canceling: ");
System.out.println(cinema);
cinema.displayAllLayouts();
}
}