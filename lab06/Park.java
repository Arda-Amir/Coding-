public class Park{
private String name;
private Shape shape;

public Park(String name, Shape shape) {
this.name = name;
this.shape = shape;
}

public void setName(String newname){
name=newname;
}

public String getName(){
return name;
}
public double getArea() {
return shape.area();
}
@Override
public String toString() {
return name + " area = " + getArea();
}
}

