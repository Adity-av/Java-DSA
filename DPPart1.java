import java.util.*;
public class DPPart1 {
    public static int fib(int n, int f[]){ //O(n) before optimization it was exponential
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){ //fib(n) is already calculated
            return f[n];
        }
        return f[n] = fib(n-1, f)+fib(n-2, f);
    }
    public static int fibTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int countWays(int n, int ways[]){
        if(n<0) return 0;
        if(n==0) return 1;
        if(ways[n]!=-1){ //already calculated
            return ways[n];
        }
        ways[n]=countWays(n-1, ways)+countWays(n-2, ways);
        return ways[n];
    }
    public static int countWaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;//+0 is only for understanding
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        // int f[] = new int[n+1];
        // System.out.println(fib(n, f));
        // System.out.println(fibTabulation(n));
        //climbing stairs (simmple recursion method)
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n,ways));
        System.out.println(countWaysTab(n));
    }
}   
