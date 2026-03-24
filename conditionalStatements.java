import java.util.*;
public class conditionalStatements {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int income=sc.nextInt();
        // int tax;
        // if(income<=500000){
        //     tax=0;
        // }else if(income>500000 && income<1000000){
        //     tax=(int)(income*0.2);
        // }else{
        //     tax=(int)(income*0.3);
        // }
        // System.out.println("Your tax is: "+tax);
        // int a=2,b=3,c=5;
        // if(a>=b && a>=c){
        //     System.out.println("a is largest");
        // }else if(b>=c){
        //     System.out.println("b is largest");
        // }else{
        //     System.out.println("c is largest");
        // }
        // int marks=33;
        // String rc=(marks>=33)?"pass":"fail";
        // System.out.println(rc);
        // double temp=103.5;
        // if(temp>100){
        //     System.out.println("you have a fever");
        // }else{
        //     System.out.println("you don't have a fever");
        // }
        // int num=sc.nextInt();
        // switch(num){
        //     case 1:System.out.println("Monday");
        //         break;
        //     case 2:System.out.println("tuesday");
        //         break;
        //     case 3:System.out.println("wednesday");
        //         break;
        //     case 4:System.out.println("thursday");
        //         break;
        //     case 5:System.out.println("friday");
        //         break;
        //     case 6:System.out.println("saturday");
        //         break;
        //     case 7:System.out.println("sunday");
        //         break;
        //     default:System.out.println("wrong input");
        // }
        int year=sc.nextInt();
        if ((year%4==0 && year%100!=0) ||year%400==0) {
            System.out.println("Leap year");
        }else{
            System.out.println("not a leap year");
        }
        sc.close();
    }
}
