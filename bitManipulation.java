// import java.util.*;
public class bitManipulation {
    public static void oddOrEven(int n){
        int bitMask=1;
        if((n&bitMask)==0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }
    public static void getIthBit(int n,int i){
        int bitMask=1<<i;
        if((n & bitMask)!=0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    public static int setIthBit(int n,int i){
        int bitMask=1<<i;
        return n | bitMask;
    }
    public static int clearIthBit(int n,int i){
        int bitMask=~(1<<i);
        return bitMask & n;
    }
    public static int updateIthBit(int n,int i,int newBit){
        // if(newBit==0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }
        n=clearIthBit(n, i);
        int bitMask=newBit<<i;
        return bitMask|n;
    }
    public static int clearLastIBits(int n,int i){
        int bitMask=~0<<i;
        return bitMask&n;
    }
    public static int clearRangeOfBits(int n,int i,int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitMask=a|b;
        return (bitMask & n);
    }
    public static boolean isPowerOf2(int n){
        if((n&(n-1))==0){
            return true;
        }else{
            return false;
        }
    }

    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            int bitMask=n&1;
            if(bitMask==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static int fastExpo(int a,int n){
        int ans=1;
        while(n>0){
            if((n&1)!=0){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int a=sc.nextInt();
        // int i=sc.nextInt();
        // int j=sc.nextInt();
        // int newBit=1;
        // oddOrEven(n);
        // getIthBit(n,i);
        // setIthBit(n,i);
        // System.out.println(clearIthBit(n,i));
        // System.out.println(updateIthBit(n,i,newBit));
        // System.out.println(clearLastIBits(n,i));
        // System.out.println(clearRangeOfBits(n,i,j));
        // System.out.println(isPowerOf2(n));
        // System.out.println(countSetBits(n));
        System.out.println(fastExpo(3,5));
    }
}
