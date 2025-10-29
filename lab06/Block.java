public class Block {
private final String name;
private Plot[][] streets;         
private final int streetCount = 5;
private Park[] parks;
private int parkCount;
private CommercialMarket market;

public Block(String name) {
this.name = name;
streets = new Plot[streetCount][];
for (int s = 0; s < streetCount; s++) {
streets[s] = new Plot[10 + s];
}

preloadPlots();
parks = new Park[2];
parkCount = 0;
int pCount = 1;
char fc = name.charAt(0);
if (fc >= 'N' && fc <= 'Z') {
pCount = 2;
}
for (int i = 0; i < pCount; i++) {
String pname = String.format("Park-%s-%d", name, i + 1);
Shape pshape = new Shape(ShapeKind.RECTANGLE, 20 + i * 5, 10 + i * 3);
parks[parkCount] = new Park(pname, pshape);
parkCount++;
}
int shops = 12 + (name.length() % 5);
market = new CommercialMarket(shops);
}

public String getName() {
return name;
}
private void preloadPlots() {
for (int s = 0; s < streetCount; s++) {
PlotType baseType;
ShapeKind shapeKind;
if (s == 0) {
baseType = PlotType.RES_5_MARLA;
shapeKind = ShapeKind.RECTANGLE;
} 
else if (s == 1) {
baseType = PlotType.RES_10_MARLA;
shapeKind = ShapeKind.RECTANGLE;
} 
else if (s == 2) {
baseType = PlotType.RES_1_KANAL;
shapeKind = ShapeKind.TRAPEZOID;
} 
else if (s == 3) {
baseType = PlotType.COMM_SHOP;
shapeKind = ShapeKind.RECTANGLE;
} 
else {
baseType = PlotType.COMM_OFFICE;
shapeKind = ShapeKind.RECTANGLE;
            }

for (int p = 0; p < streets[s].length; p++) {
int plotNo = p + 1;
PlotType finalType;
if (plotNo % 5 == 0) {
finalType = PlotType.PARKING;
                } 
else {
finalType = baseType;
}
Shape sh;
if (shapeKind == ShapeKind.RECTANGLE) {
double width = 10;
double depth = 20;
if (baseType == PlotType.RES_10_MARLA) {
width = 12;
}
if (baseType == PlotType.COMM_SHOP || baseType == PlotType.COMM_OFFICE) {
width = 6;
depth = 4;
}
sh = new Shape(ShapeKind.RECTANGLE, width, depth);
} 
else {
sh = new Shape(ShapeKind.TRAPEZOID, 20, 30, 25);
}

String id;
if (plotNo < 10) {
id = (s + 1) + "-00" + plotNo;
} 
else if (plotNo < 100) {
id = (s + 1) + "-0" + plotNo;
} 
else {
id = (s + 1) + "-" + plotNo;
 }

boolean corner = false;
if (s <= 2 && (plotNo % 4 == 0) && finalType != PlotType.PARKING) {
corner = true;
}
if (corner) {
streets[s][p] = new CornerPlot(id, finalType, sh, 6.0);
} 
else {
streets[s][p] = new Plot(id, finalType, sh);
}
}
}
}

public Plot findPlot(String plotId) {
for (int s = 0; s < streetCount; s++) {
for (int p = 0; p < streets[s].length; p++) {
Plot pl = streets[s][p];
if (pl != null && pl.getId().equals(plotId)) {
return pl;
}
}
}
return null;
}

public boolean bookPlot(String plotId) {
Plot pl = findPlot(plotId);
if (pl == null) return false;
return pl.book();
}

public boolean cancelPlot(String plotId) {
Plot pl = findPlot(plotId);
if (pl == null) return false;
if (!pl.isAvailable()) {
pl.setAvailable(true);
return true;
}
return false;
}

public int totalPlots() {
int total = 0;
for (int s = 0; s < streetCount; s++) {
total = total + streets[s].length;
}
return total;
}

public int availablePlots() {
int count = 0;
for (int s = 0; s < streetCount; s++) {
for (int p = 0; p < streets[s].length; p++) {
if (streets[s][p].isAvailable()) {
count++;
}
}
}
return count;
}

public void printReport() {
System.out.println(String.format("Block %s summary: totalPlots=%d available=%d",name, totalPlots(), availablePlots()));
for (int s = 0; s < streetCount; s++) {
String line = " Street " + (s + 1) + ": ";
for (int p = 0; p < streets[s].length; p++) {
Plot pl = streets[s][p];
String mark = pl.isAvailable() ? "A" : "X";
line = line + pl.getId() + "(" + mark + ") ";
}
System.out.println(line);
}
System.out.println(" Detailed plots:");
for (int s = 0; s < streetCount; s++) {
for (int p = 0; p < streets[s].length; p++) {
System.out.println("  " + streets[s][p].toString());
}
}
System.out.println(" Amenities:");
for (int i = 0; i < parkCount; i++) {
 System.out.println("  " + parks[i].toString());
 }
System.out.println("  " + market.toString());
}

public Plot findFirstAvailableRes1KanalCorner() {
for (int s = 0; s < streetCount; s++) {
for (int p = 0; p < streets[s].length; p++) {
Plot pl = streets[s][p];
if (pl.getClass().getSimpleName().equals("CornerPlot") && pl.getType() == PlotType.RES_1_KANAL && pl.isAvailable()) {
return pl;
}
}
}
return null;
}

public Plot firstAvailableCommShopFacingMarket() {
int s = 3;
if (s >= streetCount) return null;
for (int p = 0; p < streets[s].length; p++) {
Plot pl = streets[s][p];
if (pl.getType() == PlotType.COMM_SHOP && pl.isAvailable()) {
return pl;
}
}
return null;
}

public Shop[] firstNVacantShops(int n) {
return market.firstNVacantShops(n);
}
public Plot[][] getStreets() {
return streets;
}

}
