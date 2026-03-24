public class divideAndConquer {
    public static void mergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //kaam
        int mid=si+(ei-si)/2;
        mergeSort(arr, si, mid);//left part
        mergeSort(arr, mid+1, ei);//right part
        merge(arr,si,mid,ei);

    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quickSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //last element
        int pIdx=partition(arr,si,ei);
        quickSort(arr, si, pIdx-1);//left
        quickSort(arr, pIdx+1, ei);//right
    }
    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;//to make place for elements smaller than pivot
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static int searchRotated(int arr[],int target,int si,int ei){
        if(si>ei){
            return -1;
        }
        int mid=si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>=arr[si]){
            if(target>=arr[si] && target<arr[mid]){
                return searchRotated(arr, target,si,mid-1);
            }else{
                return searchRotated(arr, target,mid+1,ei);
            }
        }else{
            if(target>arr[mid] && target<=arr[ei] ){
                return searchRotated(arr, target,mid+1,ei);
            }else{
                return searchRotated(arr, target,si,mid-1);
            }
        }
    }
    public static void sortStringArr(String arr[],int si,int ei){
        //Base case
        if(si>=ei){
            return;
        }
        //kaam
        int mid=si+(ei-si)/2;
        sortStringArr(arr, si, mid);
        sortStringArr(arr, mid+1, ei);
        mergeAgain(arr, si, mid, ei);
    }
    public static void mergeAgain(String arr[],int si,int mid,int ei){
        String temp[]=new String[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=ei){
            if(arr[i].compareTo(arr[j])<0){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }
    public static void printArrStr(String arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int majorityElement(int nums[]){
        int n=nums.length;
        int ele=0;
        int count=0;
        for(int num : nums){
            if(count==0){
                ele=num;
            }
            count+=(num==ele)?1:-1;
        }
        count=0;
        for(int num : nums){
            if(num==ele){
                count++;
            }
        }
        return (count>n/2)?ele:-1;
    }
    private static int countInRange(int[] nums,int num,int lo,int hi){
        int count=0;
        for(int i=lo;i<=hi;i++){
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }
    
    private static int majorityElementRec(int[] nums,int lo,int hi){
        if(lo==hi){
            return nums[lo];
        }
        int mid=lo+(hi-lo)/2;
        int left=majorityElementRec(nums, lo, mid);
        int right=majorityElementRec(nums, mid+1, hi);
        if(left==right){
            return left;
        }
        int leftCount=countInRange(nums, left, lo, hi);
        int rightCount=countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    public static void main(String args[]){
        // int arr[]={4,5,6,7,0,1,2};
        // int target=0;
        // String arr[]={"sun","earth","mars","mercury"};
        // mergeSort(arr,0,arr.length-1);
        // quickSort(arr,0,arr.length-1);
        // System.out.println(searchRotated(arr,target,0,arr.length-1));
        // sortStringArr(arr,0,arr.length-1);
        // printArrStr(arr);
        int nums[]={2,2,1,1,1,2,2};
        // System.out.println(majorityElement(nums));
        System.out.println(majorityElementRec(nums, 0, nums.length-1));
        
    }
}
