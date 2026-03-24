import java.util.*;
public class arrayList {

    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    public static int containerWithMostWater(ArrayList<Integer> height){
        int left=0,right=height.size()-1;
        int maxWater=0;
        int currWater=0;;
        while(left<right){
            if(height.get(left)<height.get(right)){
                currWater=(right-left)*height.get(left);
                left++;
            }else{
                currWater=(right-left)*height.get(right);
                right--;
            }
            maxWater=Math.max(currWater,maxWater);
        }
        return maxWater;
    }

    public static boolean pairSum1(ArrayList<Integer> list, int target){
        int left=0,right=list.size()-1;
        while(left<right){
            int sum=list.get(left)+list.get(right);
            if(sum==target){
                return true;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target){
        int lp=0,rp=list.size()-1;
        while(lp<rp){
            int mid=lp+(rp-lp)/2;
            if(list.get(mid)<=list.get(rp)){
                rp=mid;
            }else{
                lp=mid+1;
            }
        }
        rp=(lp-1+list.size())%list.size();
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }else if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%list.size();
            }else{
                rp=(rp-1+list.size())%list.size();
            }
        }
        return false;
    }

    public static boolean monotonicOrNot(ArrayList<Integer> nums){
        boolean inc=true,dec=true;
        for(int i=0;i<nums.size()-1;i++){
            if(nums.get(i)<nums.get(i+1)){
                dec=false;
            }
            if(nums.get(i)>nums.get(i+1)){
                inc=false;
            }
        }
        return inc || dec;
    }

    public static ArrayList<Integer> lonelyNumber(ArrayList<Integer> nums){
        Collections.sort(nums);
        ArrayList<Integer> alone= new ArrayList<>();
        if(nums.get(0)+1!=nums.get(1) && nums.get(0)!=nums.get(1)){
            alone.add(nums.get(0));
        }
        for(int i=1;i<nums.size()-1;i++){
            if(((nums.get(i)-1)!=nums.get(i-1) && (nums.get(i)+1)!=nums.get(i+1)) && (nums.get(i)!=nums.get(i-1) && nums.get(i)!=nums.get(i+1))){
                alone.add(nums.get(i));
            }
        }
        return alone;
    }
    public static void main(String[] args) {
        // ArrayList<Integer> list=new ArrayList<>();
        // ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        // ArrayList<Integer> list=new ArrayList<>();
        // ArrayList<Integer> list2=new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list2.add(3);
        // list2.add(4);
        // mainList.add(list);
        // mainList.add(list2);
        // for(int i=0;i<mainList.size();i++){
        //     ArrayList<Integer> currList=mainList.get(i);
        //     for(int j=0;j<currList.size();j++){
        //         System.out.print(currList.get(j)+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(mainList);


        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);
        // System.out.println(list.size());
        // System.out.println(list.get(3));
        // // list.remove(2);
        // list.set(2,10);
        // System.out.println(list);
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(11));
        // list.add(1,9);
        // System.out.println(list);
        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i)+" ");
        // }
        //find maximum
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<list.size();i++){
        //     if(list.get(i)>max){
        //         max=list.get(i);
        //     }
        // }
        // System.out.println(max);
        // swap(list, 1, 3);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        //Container with most water

        // ArrayList<Integer> height=new ArrayList<>();
        // height.addAll(Arrays.asList(1,8,6,2,5,4,8,3,7));
        // System.out.println(containerWithMostWater(height));

        // pairSum-1
        // ArrayList<Integer> list= new ArrayList<>();
        // list.addAll(Arrays.asList(1,2,3,4,5,6));
        // int target=5;
        // System.out.println(pairSum1(list, target));

        // pairSum-2
        // ArrayList<Integer> list= new ArrayList<>();
        // list.addAll(Arrays.asList(11,15,6,8,9,10));
        // int target=16;
        // System.out.println(pairSum2(list,target));

        // Practice Questions

        // Q1.monotonic or not
        ArrayList<Integer> nums=new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);
        // System.out.println(monotonicOrNot(nums));
        System.out.println(lonelyNumber(nums));


        
    }
}
