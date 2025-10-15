public class Shape{
ShapeType type;
Shape(ShapeType type ){
this.type=type;
}
public double area(double width,double height){
if(type==ShapeType.RECTANGLE){
return width*height;
}
return 0;
}

public double area(double front,double back,double depth){
if(type==ShapeType.TRAPEZOID){
return ((front+back/2)*depth);
}
return 0;
}

public double area(double width1,double width2,double depth1,double depth2){
if(type==ShapeType.L_SHAPE){
return ((width1*depth1)+(width2*depth2));
}
return 0;
}
}