public class Address{
String city;
Address(String city){
this.city=city;
}
Address(Address a){
this.city=a.city;
}
@Override
public String toString(){
return city;
}
}