public class HousingSociety{
private final String name;
private Block[] blocks;
private int size;

public HousingSociety(String name, int initialCapacity) {
this.name = name;
if (initialCapacity < 1){ 
initialCapacity = 3;
}
blocks = new Block[initialCapacity];
size = 0;
}

public String getName(){ 
return name; 
}

public void preloadDefaultABC() {
addBlock(new Block("A"));
addBlock(new Block("B"));
addBlock(new Block("C"));
}

public boolean addBlock(Block b) {
if (size >= blocks.length) {
Block[] nb = new Block[blocks.length * 2];
for (int i = 0; i < blocks.length; i++) nb[i] = blocks[i];
blocks = nb;
}
blocks[size++] = b;
return true;
}

public Block findBlockByName(String bname) {
for (int i = 0; i < size; i++) {
if (blocks[i].getName().equals(bname)){ 
return blocks[i];
}
}
return null;
}

public boolean book(String blockName, String plotId) {
Block b = findBlockByName(blockName);
if (b == null){ 
return false;
}        
return b.bookPlot(plotId);
}

public boolean cancel(String blockName, String plotId) {
Block b = findBlockByName(blockName);
if (b == null){
 return false;
 }       
return b.cancelPlot(plotId);
}

public int totalPlots() {
int t = 0;
for (int i = 0; i < size; i++) t += blocks[i].totalPlots();
return t;
}

public int totalAvailable() {
int c = 0;
for (int i = 0; i < size; i++) c += blocks[i].availablePlots();
return c;
}

public void printReport() {
System.out.println("=== Society: " + name + " ===");
System.out.println(" Blocks: " + size + " Total plots: " + totalPlots() + " Available: " + totalAvailable());
for (int i = 0; i < size; i++) {
blocks[i].printReport();
}
}

public Plot findFirstAvailableRes1KanalCorner() {
for (int i = 0; i < size; i++) {
Plot p = blocks[i].findFirstAvailableRes1KanalCorner();
if (p != null) return p;
}
return null;
}

public Plot firstAvailableCommShopFacingMarket() {
for (int i = 0; i < size; i++) {
Plot p = blocks[i].firstAvailableCommShopFacingMarket();
if (p != null) return p;
}
return null;
}

public Shop[] firstNVacantShopsInBlockC(int n) {
Block b = findBlockByName("C");
if (b == null) return new Shop[0];
return b.firstNVacantShops(n);
}

}

