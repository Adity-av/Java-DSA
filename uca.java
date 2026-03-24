import java.util.*;
public class uca {
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        //day 1.Given an array: Return indices of two numbers whose sum = target.
        // int arr[]={2,7,11,15};
        // int target=9;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int i=0;i<arr.length;i++){
        //     int comp=target-arr[i];
        //     if(map.containsKey(comp)){
        //         System.out.println(map.get(comp)+" "+i);
        //         break;
        //     }
        //     map.put(arr[i],i);
        // }

        //day 2.Find the maximum subarray sum.
        // int arr1[]={2,3,-4,5,6,-2,1};
        // int currSum=0;
        // int max=arr1[0];
        // for(int val : arr1){
        //     currSum+=val;
        //     if(currSum<0) currSum=0;
        //     max=Math.max(currSum,max);
        // }
        // System.out.println(max);

        //day 3.Stock Span Problem
        int arr[]={100,80,40,60,70,50,90,110};
        Stack<Integer> s=new Stack<>();
        int span[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                span[i]=i-s.peek();
            }
            s.push(i);
        }
        printArr(span);

    }
}
