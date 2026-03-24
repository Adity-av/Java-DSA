import java.util.*;
public class arraysPart2 {
    public static void maxSubarraySum(int arr[]){
        int prefixSum[]=new int[arr.length];
        int maxSum=Integer.MIN_VALUE;
        prefixSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int currSum=0;
                currSum=(i==0)?prefixSum[j]:prefixSum[j]-prefixSum[i-1];
                if(currSum>maxSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println(maxSum);
    }
    public static void kadanesMaxSubarraySum(int arr[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            maxSum=Math.max(maxSum,currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        System.out.println(maxSum);
    }
    public static void trapRainWater(int height[]){
        int n=height.length;
        int leftMax[]=new int[n];
        int rightMax[]=new int[n];
        int trappedWater=0;
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        for(int i=0;i<n;i++){
            trappedWater=trappedWater+Math.min(leftMax[i],rightMax[i])-height[i];
        }
        System.out.println(trappedWater);

    }
    public static void buySellStock(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                int profit=prices[i]-buyPrice;
                maxProfit=Math.max(maxProfit,profit);
            }else{
                buyPrice=prices[i];
            }
        }
        System.out.println(maxProfit);
    }
    public static void reappearOrNot(int nums[]){
        HashSet<Integer> set=new HashSet<>();
        boolean duplicate=false;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                duplicate=true;
                break;
            }else{
                set.add(nums[i]);
            }
        }
        System.out.println(duplicate);
    }
    public static void rotatedArr(int arr[],int target){
        int found=-1;
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                found=mid;
                break;
            }else if(arr[mid]<=arr[right]){
                if(target>arr[mid]&&target<=arr[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(target<arr[mid]&&target>=arr[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        System.out.println(found);
    }
    public static void threeSum(int nums[]){
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        set.add(triplet);
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(set);
        System.out.println(result);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[]=new int[6];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        // maxSubarraySum(arr);
        // kadanesMaxSubarraySum(arr);
        // trapRainWater(arr);
        // buySellStock(arr);
        // reappearOrNot(arr);
        // rotatedArr(arr,0);
        threeSum(arr);
        sc.close();
    }
}
