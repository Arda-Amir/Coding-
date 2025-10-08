public class Home{
public static void main(String[] args){
int num[][]={{1,2,3},{4,5,6},{7,8,9}};
int c1=0;
int c2=0;
int c3=0;
for(int j=0;j<1;j++){
for(int i=0;i<3;i++){
c1+=num[i][j];
}
}
for(int j=1;j<2;j++){
for(int i=0;i<3;i++){
c2+=num[i][j];
}
}
for(int j=2;j<3;j++){
for(int i=0;i<3;i++){
c3+=num[i][j];
}
}
System.out.println("column 1: "+c1);
System.out.println("column 2: "+c2);
System.out.println("column 3: "+c3);
}
}
