public class CityHousing{
private final String cityName;
private HousingSociety[] societies;
private int size;

public CityHousing(String cityName, int initialCapacity) {
this.cityName = cityName;
if (initialCapacity < 1) initialCapacity = 2;
societies = new HousingSociety[initialCapacity];
size = 0;
}

public void addSociety(HousingSociety s) {
if (size >= societies.length) {
HousingSociety[] ns = new HousingSociety[societies.length * 2];
for (int i = 0; i < societies.length; i++) ns[i] = societies[i];
societies = ns;
        }
societies[size++] = s;
    }

public HousingSociety findByName(String nm) {
for (int i = 0; i < size; i++) {
if (societies[i].getName().equalsIgnoreCase(nm)) return societies[i];
}
return null;
}

public Plot findFirstAvailableRes1KanalCorner() {
for (int i = 0; i < size; i++) {
Plot p = societies[i].findFirstAvailableRes1KanalCorner();
if (p != null){ 
return p;
}
}
 return null;
}

@Override
public String toString() {
String result = String.format("City: %s societies: %d%n", cityName, size);
for (int i = 0; i < size; i++) {
String societyName = societies[i].getName();
int total = societies[i].totalPlots();
int available = societies[i].totalAvailable();
result = result + String.format(" - %s (plots: %d, avail: %d)%n", societyName, total, available);
}
return result;
}
}

