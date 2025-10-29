public class Shape {
private final ShapeKind kind;
private final double[] dims;

public Shape(ShapeKind kind, double... dims) {
this.kind = kind;
this.dims = dims;
}

public double area() {
if (kind == ShapeKind.RECTANGLE) {
return dims[0] * dims[1];
} 
else if (kind == ShapeKind.TRAPEZOID) {
return ((dims[0] + dims[1]) / 2.0) * dims[2];
} 
else if (kind == ShapeKind.L_SHAPE) {
return (dims[0] * dims[1]) + (dims[2] * dims[3]);
} 
else{
return 0;
}
}

public String dimsString() {
if (kind == ShapeKind.RECTANGLE) {
return "RECT(" + (int)dims[0] + "x" + (int)dims[1] + ")";
} 
else if (kind == ShapeKind.TRAPEZOID) {
return "TRAP(" + (int)dims[0] + "," + (int)dims[1] + "," + (int)dims[2] + ")";
} 
else if (kind == ShapeKind.L_SHAPE) {
return "L(" + (int)dims[0] + "x" + (int)dims[1] + "+" + (int)dims[2] + "x" + (int)dims[3] + ")";
} 
else{
return "UNKNOWN";
}
}

@Override
public String toString(){
return kind + " area:" + (int)area() + " " + dimsString();
}
}
