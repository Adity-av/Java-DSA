import java.util.*;
public class flowchart {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        float a=sc.nextFloat();
        a=a+a*18/100;
        float b=sc.nextFloat();
        b=b+b*18/100;
        float c=sc.nextFloat();
        c=c+c*18/100;
        System.out.println(a+b+c);
        sc.close();
    }
}