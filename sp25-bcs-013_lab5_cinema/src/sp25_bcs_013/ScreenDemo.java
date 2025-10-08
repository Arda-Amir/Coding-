package sp25_bcs_013;

public class ScreenDemo{
public static void main(String[] args){
Screen screen = new Screen("Screen-1", 3);
screen.displayLayout();
screen.book(0, 0);
System.out.println("After booking: ");
screen.displayLayout();

}

}