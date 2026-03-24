import java.util.*;
public class greedyAlgorithms {
    public static int fractionalKnapsack(int[] val, int[] weight, int W){
        double ratio[][]=new double[val.length][2];
        for(int i=0;i<ratio.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity=W;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                finalVal+=val[idx];
                capacity-=weight[idx];
            }else{
                finalVal+=ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }
        return finalVal;
    }
    public static void printAct(int activity[][]){
        for(int i=0;i<activity.length;i++){
            for(int j=0;j<activity[0].length;j++){
                System.out.print(activity[i][j]);
            }
            System.out.println();
        }
    }
    public static int activitySelection(int[] start, int[] end){
        int count=1;
        int[][] activity=new int[end.length][3];
        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        printAct(activity);
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));
        int lastEnd=activity[0][2];
        for(int i=1;i<activity.length;i++){
            if(lastEnd<=activity[i][1]){
                lastEnd=activity[i][2];
                count++;
            }
        }
        return count;
    }
    public static int minAbsoluteDiffPairs(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int res=0;
        for(int i=0;i<A.length;i++){
            res+=(int)Math.abs(A[i]-B[i]);
        }
        return res;
    }
    public static int maxLengthChainOfPairs(int pairs[][]){
        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));
        int chainLen=1;
        int chainEnd=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(chainEnd<pairs[i][0]){
                chainEnd=pairs[i][1];
                chainLen++;
            }
        }
        return chainLen;
    }
    public static int indianCoins(int V, int coins[]){
        int remaining=V;
        int idx=coins.length-1;
        int numberOfCoinsReq=0;
        while(idx>=0 && remaining>0){
            if(coins[idx]<=remaining){
                numberOfCoinsReq++;
                remaining-=coins[idx];
            }else{
                idx--;
            }
        }
        return numberOfCoinsReq;
    }

    static class Job{
        int deadline;
        int profit;
        int id;//0(A), 1(B), 2(C)...
        public Job(int i, int d, int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static void jobSequencingProblem(int jobsInfo[][]){
        ArrayList<Job> jobs=new ArrayList<>();
        int maxDeadline=0;
        for(int[] j : jobsInfo){
            maxDeadline=Math.max(maxDeadline,j[0]);
        }
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit);
        //decending order of profit
        boolean slot[]=new boolean[maxDeadline+1];
        int count=0;
        int maxProfit=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            for(int j=curr.deadline;j>0;j--){
                if(slot[j]==false){
                    slot[j]=true;
                    maxProfit+=curr.profit;
                    count++;
                    break;
                }
            }
        }
        
        System.out.println("total no. of jobs = "+count+", max profit = "+maxProfit);
    }
    public static int chocolaProblem(Integer[] costVer, Integer[] costHor){
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
        int v=0,h=0;
        int vp=1,hp=1;
        int cost=0;
        while(v<costVer.length && h<costHor.length){
            if(costVer[v]>=costHor[h]){
                cost+=(costVer[v]*hp);
                v++;vp++;
            }else{
                cost+=(costHor[h]*vp);
                h++;hp++;
            }
        }
        while(v<costVer.length){
            cost+=(costVer[v]*hp);
            v++;vp++;
        }
        while(h<costHor.length){
            cost+=(costHor[h]*vp);
            h++;hp++;
        }
        return cost;
    }
    public static int maxBalancedStr(String str){
        int j=0,count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='L')j++;
            else j--;
            if(j==0) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int W=50;
        System.out.println(fractionalKnapsack(val,weight,W));
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        System.out.println(activitySelection(start,end));
        int A[]={4,1,8,7};
        int B[]={2,3,6,5};
        System.out.println(minAbsoluteDiffPairs(A,B));
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        System.out.println(maxLengthChainOfPairs(pairs));
        int coins[]={1,2,5,10,20,50,100,500,2000};
        int V=1059;
        System.out.println(indianCoins(V,coins));
        int jobsInfo[][]={{4,40},{1,10},{1,20},{1,30}};
        jobSequencingProblem(jobsInfo);
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        System.out.println(chocolaProblem(costVer,costHor));
        String str="LRRRRLLRLLRL";
        System.out.println(maxBalancedStr(str));
    }
}
