import java.util.*;
public class DPPart6 {
    public static int mcm(int arr[], int i, int j){
        if(i==j) return 0; //single matrix code
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = mcm(arr, i, k); //Ai....Ak => arr[i-1]xarr[k]
            int cost2 = mcm(arr, k+1, j); //Ai+1....Aj => arr[k]xarr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans=Math.min(ans, finalCost);
        }
        return ans; //minCost   
    }
    public static int mcmMem(int arr[], int i, int j, int dp[][]){
        if(i==j) return 0; //single matrix code
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = mcmMem(arr, i, k, dp); //Ai....Ak => arr[i-1]xarr[k]
            int cost2 = mcmMem(arr, k+1, j, dp); //Ai+1....Aj => arr[k]xarr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans=Math.min(ans, finalCost);
        }
        return dp[i][j]=ans; //minCost   
    }
    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        //initialization
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }

        //bottom up
        for(int len=2; len<=n-1; len++){
            for(int i=1;i<=n-len; i++){
                int j = i+len-1; //col
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }

    public static int minPartition(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        int W=sum/2;
        int dp[][] = new int[n+1][W+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(arr[i-1]<=j){ //valid
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }else{ //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
    }

    public static int minJumps(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            int steps = nums[i];
            int ans=Integer.MAX_VALUE;
            for(int j=i+1; j<=i+steps && j<n; j++){
                if(dp[j] != -1){
                    ans=Math.min(ans, dp[j]+1);
                }
            }
            if(ans!=Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3}; //n=5
        int n=arr.length;
        System.out.println(mcm(arr, 1, n-1));
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(mcmMem(arr, 1, n-1, dp));
        System.out.println(mcmTab(arr));
        System.out.println(minPartition(arr));
        int nums[] = {2,3,1,1,4};
        System.out.println(minJumps(nums));
    }
}