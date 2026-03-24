import java.util.*;
public class loops {
    public static void main(String[] args) {
        //while Loop
        // int counter=0;
        // while(counter<10){
        //     System.out.println("Hello World");
        //     counter++;
        // }
        

        //print numbers from 1 to 10
        // int i=1;
        // while(i<11){
        //     System.out.println(i);
        //     i++;
        // }

        //print numbers from 1 to n
        // int i=1;
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter The Number: ");
        // int n=sc.nextInt();
        // while(i<=n){
        //     System.out.print(i+" ");
        //     i++;
        // }

        //print sum of first n natural numbers
        // int i=1,sum=0;
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // while(i<=n){
        //     sum+=i;
        //     i++;
        // }
        // System.out.println("Sum is: "+sum);

        // print square pattern
        // int n=sc.nextInt();
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //reverse reverse of a number
        // int n=sc.nextInt();
        // int rev=0;
        // while(n>0){
        //     int rem=n%10;
        //     rev=rev*10+rem;
        //     n/=10;
        // }
        // System.out.println(rev);


        // keep entering numbers till user enters a multiple of 10
        // do {
        //     int n=sc.nextInt();
        //     if(n%10==0){
        //         break;
        //     }
        //     System.out.println(n);
        // } while (true);

        //keep entering numbers and if n%10==0 then don't print that number
        // do{
        //     int n=sc.nextInt();
        //     if(n%10==0){
        //         continue;
        //     }
        //     System.out.println(n);
        // }while(true);


        //check if a number is prime or not
        // int n=sc.nextInt();
        // int isPrime=primeOrNot(n);
        // if(isPrime==0){
        //     System.out.println("Not Prime");
        // }else{
        //     System.out.println("Prime");
        // }


        //Loops Question-2 -Write a program that reads a set of integers, and then prints the sum of the even and odd integers.
        // int evenSum=0,oddSum=0,ch=0;
        // do{
        //     int num=sc.nextInt();
        //     if(num%2==0){
        //         evenSum+=num;
        //     }else{
        //         oddSum+=num;
        //     }
        //     System.out.println("Do you want to enter more numbers press 1, to exit press 0");
        //     ch=sc.nextInt();
        // }while(ch==1);
        // System.out.println("Even sum = "+evenSum+" Odd sum = "+oddSum);

        //factorial of a number
        // int n=sc.nextInt();
        // for(int i=n-1;i>=2;i--){
        //     n*=i;
        // }
        // System.out.println(n);

        //multiplication table of  any number
        int n=sc.nextInt();
        int i=1;
        while(i<=10){
            System.out.println(n+"*"+i+"="+n*i);
            i++;
        }
        sc.close();

    }


    public static int primeOrNot(int n){
        if(n<=1){
            return 0;
        }else{
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    return 0;
                }
            }
        }
        return 1;
    }
}
