import java.util.*;
public class patternsPart1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //Star pattern
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //Inverted star pattern
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n-i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //Half Pyramid Pattern
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        //print Character pattern
        // char ch='A';
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //         System.out.print(ch);
        //         ch++;
        //     }
        //     System.out.println();
        // }

        //hw Questions
        //1.Hollow Rectangle Pattern
        // int r=sc.nextInt();
        // int c=sc.nextInt();
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         if(i==0||i==r-1||j==0||j==c-1){
        //             System.out.print("* ");
        //         }else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        //2.Inverted And Rotated Half Pyramid
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=0;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //Inverted Half-Pyramid with Numbers Pattern
        // for(int i=0;i<n;i++){
        //     for(int j=1;j<=n-i;j++){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }

        //Floyd's Triangle pattern
        // int a=1;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //         System.out.print(a+" ");
        //         a++;
        //     }
        //     System.out.println();
        // }

        //0-1 Triangle Pattern
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //         if((i+j)%2==0){
        //             System.out.print("1 ");
        //         }else{
        //             System.out.print("0 ");
        //         }
        //     }
        //     System.out.println();
        // }

        //butterfly pattern
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     for(int j=0;j<2*(n-i-1);j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=0;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // for(int i=n-1;i>=0;i--){
        //     for(int j=0;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     for(int j=0;j<2*(n-i-1);j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=0;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }


        //Solid Rhombus Pattern
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=0;j<n;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //Hollow Rhombus Pattern
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n-i-1;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=0;j<n;j++){
        //         if(i==0||i==n-1||j==0||j==n-1){
        //             System.out.print("* ");
        //         }else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }


        //Diamond pattern
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print("  ");
            }
            for(int j=0;j<i*2+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n-i-1;j++){
                System.out.print("  ");
            }
            for(int j=0;j<i*2+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }


        //Number Pyramid Pattern
        // for(int i=1;i<=n;i++){
        //     for(int j=0;j<n-i;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=0;j<i;j++){
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        //Palindromic Pattern with Numbers Pattern
        // for(int i=1;i<=n;i++){
        //     for(int j=0;j<n-i;j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=i;j>=1;j--){
        //         System.out.print(j+" ");
        //     }
        //     for(int j=2;j<=i;j++){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }
        sc.close();
    }
}
