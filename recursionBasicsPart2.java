import java.util.*;
public class recursionBasicsPart2 {
    public static int tilingProblem(int n){
        if(n==0 ||n==1){
            return 1;
        }
        //vertical choice
        int fnm1=tilingProblem(n-1);
        //horizontal choice
        int fnm2=tilingProblem(n-2);

        int totalWays=fnm1+fnm2;
        return totalWays;
    }
    public static void removeDuplicates(String str,int idx,StringBuilder newString,boolean map[]){
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar=str.charAt(idx);
        if(map[currChar-'a']==true){
            removeDuplicates(str, idx+1, newString, map);
        }else{
            map[currChar-'a']=true;
            removeDuplicates(str, idx+1, newString.append(currChar), map);
        }
    }
    public static int friendsPair(int n){
        if(n==1 || n==2){
            return n;
        }
        return friendsPair(n-1)+(n-1)*friendsPair(n-2);
    }
    public static void printBinStrings(int n,int lastPlace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinStrings(n-1, 0, str+"0");
        if(lastPlace==0){
            printBinStrings(n-1, 1, str+"1");
        }
    }
    public static void printIndices(int arr[],int key,int idx){
        if(idx==arr.length){
            return;
        }
        if(arr[idx]==key){
            System.out.print(idx+" ");
        }
        printIndices(arr, key, idx+1);
    }
    public static void numToEng(int num,String arr[]){
        if(num==0){
            return;
        }
        numToEng(num/10, arr);
        System.out.print(arr[num%10]+" ");
    }
    public static int strLen(int idx,String str){
        if(str.equals("")){
            return idx;
        }
        return strLen(idx+1, str.substring(1));
    }
    public static int countSubStr(String str,int i,int j,int n){
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        int res=countSubStr(str,i+1,j,n-1)+countSubStr(str,i,j-1,n-1)-countSubStr(str,i+1,j-1,n-2);
        if(str.charAt(i)==str.charAt(j)){
            res++;
        }
        return res;
    }
    public static void towerOfHanoi(int n, String src,String helper,String dest){
        if(n==1){
            System.out.println("Transfer Disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Transfer Disk "+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.print("Enter the number: ");
        // int n=sc.nextInt();
        // System.out.println(tilingProblem(n));
        // String str="appnnacollege";
        // int idx=0;
        // boolean map[]=new boolean[26];
        // StringBuilder newString=new StringBuilder();//or
        // removeDuplicates(str,idx,new StringBuilder(""),new boolean[26]);
        // System.out.println(friendsPair(n));
        // printBinStrings(n,0,"");
        // int arr[]={3,2,4,5,6,2,7,2,2};
        // int key=2;
        // printIndices(arr,key,0);
        // String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        // numToEng(1947,arr);
        // System.out.println(strLen(0,"apnacollege"));
        // String str=sc.next();
        // System.out.println(countSubStr(str,0,str.length()-1,str.length()));
        int n=sc.nextInt();
        towerOfHanoi(n,"S","H","D");
    }
}
