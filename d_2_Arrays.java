// import java.util.*;
public class d_2_Arrays {
    public static void printSpiralMatrix(int arr[][]){
        int ur=0,lc=0,rc=arr[0].length-1,lr=arr.length-1;
        while((ur<=lr)&&(rc>=lc)){
            for(int i=lc;i<=rc;i++){
                System.out.print(arr[ur][i]+" ");
            }
            ur++;
            for(int i=ur;i<=lr;i++){
                System.out.print(arr[i][rc]+" ");
            }
            rc--;
            if(ur<=lr){
                for(int i=rc;i>=lc;i--){
                    System.out.print(arr[lr][i]+" ");
                }
                lr--;
            }
            if(lc<=rc){
                for(int i=lr;i>=ur;i--){
                    System.out.print(arr[i][lc]+" ");
                }
                lc++;
            }
        }
    }
    public static void diagonalSum(int arr[][]){
        int sum=0;
        int n=arr.length-1;
        for(int i=0;i<=n;i++){
            sum+=arr[i][i];
            if(i!=arr.length-i-1){
                sum+=arr[i][arr.length-i-1];
            }
        }
        System.out.println(sum);
    }
    public static boolean staircaseSearch(int arr[][],int key){
        int row=0;
        int col=arr[0].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col]==key){
                System.out.println("found key at: "+row+","+col);
                return true;
            }else if(arr[row][col]>key){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }
    public static void count7s(int nums[][]){
        int count7=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==7){
                    count7++;
                }
            }
        }
        System.out.println("no. of 7's are : "+count7);
    }
    public static void printSecondRow(int nums[][]){
        int sum=0;
        for(int j=0;j<nums[0].length;j++){
            sum+=nums[1][j];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        // int arr[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        // int key=33;
        // printSpiralMatrix(arr);
        // diagonalSum(arr);
        // boolean found=staircaseSearch(arr,key);
        // System.out.println(found);
        int nums[][]={{1,4,9},{2,2,3}};
        // count7s(nums);
        // printSecondRow(nums);
        int n=nums.length;
        int m=nums[0].length;
        int transposeMatrix[][]=new int[m][n];
        for(int i=0;i<transposeMatrix.length;i++){
            for(int j=0;j<transposeMatrix[0].length;j++){
                transposeMatrix[i][j]=nums[j][i];
            }
        }
        for(int i=0;i<transposeMatrix.length;i++){
            for(int j=0;j<transposeMatrix[0].length;j++){
                System.out.print(transposeMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
