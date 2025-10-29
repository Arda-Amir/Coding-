public class CityDemo{ 
public static void main(String[] args){
CityHousing lahore = new CityHousing("Lahore", 1);
HousingSociety lda = new HousingSociety("LDA Avenue 1", 3);
lda.preloadDefaultABC();
lahore.addSociety(lda);
System.out.println(lahore.toString());
System.out.println("\n--- Booking Test ---");
boolean booked = lda.book("A", "3-007");
System.out.println("Booking plot A > 3-007: " + (booked ? "SUCCESS" : "FAILED"));
boolean cancelled = lda.cancel("A", "3-007");
System.out.println("Cancel booking: " + (cancelled ? "SUCCESS" : "FAILED"));
Block blockA = lda.findBlockByName("A");
if (blockA != null) {
blockA.printReport();
}
}

}

