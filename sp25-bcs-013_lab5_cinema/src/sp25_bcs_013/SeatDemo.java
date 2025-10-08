package sp25_bcs_013;


public class SeatDemo{
public static void main(String[] args){
Seat s1 = new Seat(0, 0, 500, Seat.SeatType.REGULAR);
Seat s2 = new Seat(0, 1, 1000, Seat.SeatType.VIP);
System.out.println(s1);
System.out.println(s2);
s2.Bookseat();
System.out.println("After booking: " + s2);
s2.CancelBooking();
System.out.println("After canceling: " + s2);
}
}