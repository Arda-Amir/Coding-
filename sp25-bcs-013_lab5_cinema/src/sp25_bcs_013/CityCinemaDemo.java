package sp25_bcs_013;


public class CityCinemaDemo{
public static void main(String[] args){
CityCinema city = new CityCinema("Karachi", 2, 2, 3);
System.out.println(city);
city.book("Cinema 1: ", "screen: 1", "001");
System.out.println("After booking: ");
System.out.println(city);
System.out.println("First available VIP seat: "+ city.findFirstAvailableVIPseat());
city.cancel("Cinema 1: ", "screen: 1", "001");
System.out.println("After canceling:");
System.out.println(city);
}

}