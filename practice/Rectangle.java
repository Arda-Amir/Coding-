public class Rectangle{
double length;
double width;
Rectangle(){
this.length=1;
this.width=1;
}
Rectangle(Double length){
this.length=length;
this.width=length;
}
Rectangle (double length,double width){
this.length=length;
this.width=width;
}
public String toString(){
return "Length: "+length+" width: "+width;
}
public double area(){
return length*width;
}
}