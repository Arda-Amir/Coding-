public class CornerPlot extends Plot {
private final double secondFrontage;     
private static final double PREMIUM = 0.08; 
    
public CornerPlot(String id, PlotType type, Shape shape, double secondFrontage) {
super(id, type, shape);
this.secondFrontage = secondFrontage;
}

@Override
public long getPrice() {
double base = super.getBasePrice();
double total = base + (base * PREMIUM);
return (long) total;  
}

@Override
public String toString() {
String status;
if (isAvailable()) {
status = "AVAILABLE";
    } 
else {
status = "BOOKED";
    }
return id + " " + getType() + " CORNER area:" + (int)getArea() +"su price:" + getPrice() + " " + status +" dims:" + shape.dimsString() +" secondFront:" + (int)secondFrontage;
}
}