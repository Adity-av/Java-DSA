import java.util.*;
public class functionsAndMethods {
    public static void sum(int a,int b){
        System.out.println("Addition of a and b is: "+ (a+b));
    }
    public static int multiply(int a,int b){
        return a*b;
    }
    public static int fact(int n){
        for(int i=n-1;i>=1;i--){
            n*=i;
        }
        // System.out.println("Factorial of n is: "+n);
        return n;
    }
    public static void binoCoeff(int n,int r){
        int nFact=fact(n);
        int rFact=fact(r);
        int nMinusR=fact(n-r);
        int bino=nFact/(rFact*(nMinusR));
        System.out.println("the binomial coefficient is: "+bino);
    }
    public static boolean primesInRange(int n){
        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void binToDec(int n){
        int pow=0;
        int dec=0;
        while(n>0){
            int rem=n%10;
            dec+=rem*(int)Math.pow(2,pow);
            pow++;
            n/=10;
        }
        System.out.println(dec);
    }
    public static void decToBin(int n){
        int pow=0;
        int bin=0;
        while(n>0){
            int rem=n%2;
            bin+=rem*(int)Math.pow(10,pow);
            pow++;
            n/=2;
        }
        System.out.println(bin);
    }
    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }else{
            return false;
        }
    }
    public static void isPalindrome(int n){
        int t=n;
        int rev=0;
        while(n>0){
            int rem=n%10;
            rev=rev*10+rem;
            n/=10;
        }
        if(rev==t){
            System.out.println("Palidrome!!!");
        }else{
            System.out.println("Not a palindrome");
        }
    }
    public static void sumOfDigits(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int n=5;
        // int a=sc.nextInt();
        // int b=sc.nextInt();
        // sum(a,b);
        // int prod=multiply(a,b);
        // System.out.println("multiplication of a and b is: "+prod);

        // binoCoeff(5,2);

        // int n= sc.nextInt();
        // for(int i=2;i<n;i++){
        //     boolean check=primesInRange(i);
        //     if(check==true){
        //         System.out.print(i+" ");
        //     }
        // }

        // int n=sc.nextInt();
        // binToDec(n);
        // decToBin(n);

        //practice Questions
        //q1. WAP  to compute average of three numbers
        // int a=10,b=20,c=30;
        // System.out.println("the average of three numbers is = "+(a+b+c)/3);

        //q2. WAP to check wether the given number is even(return true) or not(else return false)
        // int n=sc.nextInt();
        // if(isEven(n)==true){
        //     System.out.println("Even");
        // }else{
        //     System.out.println("Odd");
        // }

        //q3. WAP to check wether the given number is a palindrome or not
        int n=sc.nextInt();
        // isPalindrome(n);
        sumOfDigits(n);
        sc.close();
    }
}