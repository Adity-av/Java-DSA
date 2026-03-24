public class recursionBasicsPart1 {
    public static void decNums(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        decNums(n-1);
    }
    public static void incNums(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        incNums(n-1);
        System.out.println(n);
    }
    public static int factNums(int n){
        if(n==0){
            return 1;
        }
        int fn=n*factNums(n-1);
        return fn;
    }
    public static int sumNums(int n){
        if(n==1){
            return 1;
        }
        int fn=n+sumNums(n-1);
        return fn;
    }
    public static int fiboNums(int n){
        if(n==0 || n==1){
            return n;
        }
        int fn=fiboNums(n-1)+fiboNums(n-2);
        return fn;
    }
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int firstOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }
    public static int lastOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=lastOccurence(arr, key, i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static int nPower(int x,int n){
        if(n==0){
            return 1;
        }
        return x*nPower(x, n-1);
    }
    public static void main(String[] args) {
        // decNums(8);
        // incNums(8);
        // System.out.println(factNums(5));
        // System.out.println(sumNums(5));
        // System.out.println(fiboNums(0));
        // int key=3;
        // int arr[]={8,3,6,9,5,10,2,5,3};
        // System.out.println(isSorted(arr,0));
        // System.out.println(firstOccurence(arr,key,0));
        // System.out.println(lastOccurence(arr,key,0));
        int x=2,n=10;
        
        System.out.println(nPower(x,n));
        System.out.println(x<<2);
    }
}
