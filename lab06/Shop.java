public class Shop{
private final String id;
private final long price;
private boolean booked;

public Shop(String id, long price) {
this.id = id;
this.price = price;
this.booked = false;
}

public boolean book() {
if (booked) {
return false; 
} 
else {
booked = true;
return true;  
}
}

public boolean cancel() {
if (!booked) {
return false; 
} 
else{
booked = false;
return true;  }
}

public boolean isAvailable(){ 
return !booked; 
}

public String getId(){ 
return id; 
}

public long getPrice(){ 
return price; 
}

@Override
public String toString() {
String status;
if (isAvailable()) {
status = "AVAILABLE";
} 
else{
status = "BOOKED";
}
return id + " " + price + " " + status;

}
}

