import java.util.*;
public class arraysPart1 {
    public static int linearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static int binSearch(int arr[],int key){
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
    public static void arrReverse(int arr[]){
        int r=arr.length-1;
        for(int i=0;i<arr.length/2;i++){
            arr[i]+=arr[r];
            arr[r]=arr[i]-arr[r];
            arr[i]=arr[i]-arr[r];
            r--;
        }
    }
    public static void printPairs(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+") ");
            }
            System.out.println();
        }
    }
    public static void maxSubarraySum(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int currSum=0;
                for(int k=i;k<=j;k++){
                    currSum+=arr[k];
                }
                if(currSum>maxSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println(maxSum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[5];
        // int key=25;
        // String menu[]={"dosa","chole bhature","samosa","jalebi","bread pakora","cake","momos","burger"};
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        maxSubarraySum(arr);
        // printPairs(arr);
        // arrReverse(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // int index=binSearch(arr,key);
        // if(index!=-1){
        //     System.out.println("Found at index : "+index);
        // }else{
        //     System.out.println("Not Found");
        // }
        // int largest=Integer.MIN_VALUE;

        // for(int i=0;i<arr.length;i++){
        //     if(largest<arr[i]){
        //         largest=arr[i];
        //     }
        // }
        // System.out.println("Largest number is: "+largest);
        // int key=10;
        // int found=linearSearch(arr,key);
        // if(found!=-1){
        //     System.out.println("Found at index: "+found);
        // }else{
        //     System.out.println("Not Found");
        // }
        // int index=0;
        // String key="samosa";
        // for(int i=0;i<menu.length;i++){
        //     if(menu[i].equals(key)){
        //         index=i;
        //         break;
        //     }
        // }
        // if(index!=-1){
        //     System.out.println("Found at index: "+index);
        // }else{
        //     System.out.println("Not  Found");
        // }
        sc.close();
        
    }
}
