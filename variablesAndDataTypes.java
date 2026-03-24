import java.util.Scanner;

public class variablesAndDataTypes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int a=sc.nextInt();
        // int b=sc.nextInt();
        float radius=sc.nextFloat();
        // int sum=a*b;
        float area=3.14f*radius*radius;
        System.out.println(area);
        sc.close();
    }
}
