public class Plot {
protected final String id;         
protected final PlotType type;
protected final Shape shape;
protected boolean booked;
protected final double area;
protected final long basePrice;

public Plot(String id, PlotType type, Shape shape) {
this.id = id;
this.type = type;
this.shape = shape;
this.booked = false;
this.area = shape.area();
this.basePrice = type.basePrice();
}

public boolean book() {
if (!booked) {
booked = true;
return true;  
} 
else {
return false; 
 }
}
public boolean cancelBooking() {
if (booked) {
 booked = false;
 return true;  
 } 
else {
return false; 
}
}

public boolean isAvailable() {
return !booked; 
}

public void setAvailable(boolean available) {
this.booked = !available;
}

public String getId() { 
 return id; 
}

public PlotType getType() { 
return type; 
}

public double getArea() { 
return area; 
}

public long getBasePrice() { 
return basePrice; 
}

public long getPrice() {
return basePrice; 
}

@Override
public String toString() {
String availability = isAvailable() ? "AVAILABLE" : "BOOKED";
return id + " " + type + " area:" + (int) area + " su price:" + getPrice() + " PKR " + availability + " dims:" + shape.dimsString();
}
}
