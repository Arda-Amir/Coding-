public class Student{
String name;
Address address;
Levels l;

Student(String name,Address address,Levels l){
this.name=name;
this.address=address;
this.l=l;
}
Student(Student s){
this.name=s.name;
this.address=new Address(s.address.city);
}
@Override
public String toString(){
return "Name: "+name+" Address: "+address+" level: "+l;
}
}