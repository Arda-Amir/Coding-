public class CommercialMarket{
private Shop[] shops;
private int size;

public CommercialMarket(int shopCount){
shops = new Shop[shopCount];
size = shopCount;

for (int i = 0; i < shopCount; i++) {
String id = String.format("S%02d", i + 1);             
shops[i] = new Shop(id, PlotType.COMM_SHOP.basePrice());
}
}

public int totalShops() {
return size;
}

public int vacantCount() {
int count = 0;
for (int i = 0; i < size; i++) {
if(shops[i].isAvailable()) {
count++;
}
}
return count;
}

public Shop firstAvailable() {
for (int i = 0; i < size; i++) {
if (shops[i].isAvailable()) {
return shops[i];
}
}
return null;
}

public Shop[] firstNVacantShops(int n) {
int totalVacant = vacantCount();
int take = n;
if (n > totalVacant) {
take = totalVacant;
}

Shop[] result = new Shop[take];
int index = 0;
for (int i = 0; i < size && index < take; i++) {
if (shops[i].isAvailable()) {
result[index] = shops[i];
index++;
}
}
return result;
}

public Shop[] getAllShops() {
return shops;
    }

@Override
public String toString() {
return "Market has " + totalShops() + " shops, " + vacantCount() + " vacant";
}

}

