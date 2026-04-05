import java.util.*;
public class heaps {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            // add at last idx
            arr.add(data);
            int x = arr.size()-1; // x is child index
            int par = (x-1)/2; // par idx
            while(arr.get(par) > arr.get(x)){ // O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){ // private is used as funstions made in this class can use this function. 
        // this is not for functions outside this class.
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            
            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }

        }

        public int remove(){
            int data = arr.get(0);
            // step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step2 - delete last
            arr.remove(arr.size()-1);

            //step3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    public static void heapify(int arr[], int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        if(left<size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if(right <size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp; 
            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]){
        //step1 - build maxHeap
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        //step2 - push largest at end
        for(int i=n-1; i>0; i--){
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;
        public Point(int x, int y, int distSq, int idx){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.idx=idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq-p2.distSq;
        }
    }

    static class Row implements Comparable<Row>{
        int soldier;
        int idx;
        public Row(int soldier, int idx){
            this.soldier=soldier;
            this.idx=idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldier == r2.soldier) return this.idx-r2.idx;
            return this.soldier-r2.soldier;
        }
    }

    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val,  int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.val-this.val;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // pq.add(new Student("A", 4));// O(logn)
        // pq.add(new Student("B", 5));
        // pq.add(new Student("C", 2));
        // pq.add(new Student("D", 12));
        // System.out.println(pq);
        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().name + " -> " + pq.peek().rank);
        //     pq.remove();// O(logn)
        // }

        // Heap pq = new Heap();
        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(5);

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }
        // int[] arr = {1,2,4,5,3};
        // heapSort(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.err.print(arr[i]+" ");
        // }

        // Q. nearby cars problem, full question in the notebook
        // int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        // int k=2;
        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for(int i=0;i<pts.length;i++){
        //     int distSq=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
        //     pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        // }

        // for(int i=0;i<k;i++){
        //     System.out.println("C"+pq.remove().idx);
        // }
        
        // Q. Connect N Ropes
        // int ropes[] = {2,3,3,4,6};
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i=0;i<ropes.length;i++){
        //     pq.add(ropes[i]);
        // }
        // int totalCost = 0;
        // while(pq.size()!=1){
        //     int a=pq.remove(), b=pq.remove();
        //     int sum=a+b;
        //     totalCost+=sum;
        //     pq.add(sum);
        // }
        // System.out.println(totalCost);

        /*Q. We are given an mxn binary matrix of 1's (soldiers) and O's (civilians). The soldiers are
        positioned in front of the civilians. That is, all the 1's will appear to the left of all the O's
        in each row.

        A row i is weaker than a row j if one of the following is true:
        . The number of soldiers in row i is less than the number of soldiers in row j.
        · Both rows have the same number of soldiers and i < j.
        Find the K weakest rows.*/
        // int m=4, n=4, k=2;
        // int army[][]={{1,0,0,0}, {1,1,1,1}, {1,0,0,0}, {1,0,0,0}};
        // PriorityQueue<Row> pq = new PriorityQueue<>();
        // for(int i=0;i<m;i++){
        //     int count=0;
        //     for(int j=0;j<n;j++){
        //         if(army[i][j] == 1) count++;
        //     }
        //     pq.add(new Row(count, i));
        // }
        // for(int i=0;i<k;i++){
        //     System.out.println("Row"+pq.remove().idx);
        // }


        // Q. Sliding Window Maximum
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i], i));
        }
        res[0]=pq.peek().val;
        for(int i=k;i<arr.length;i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-k+1]=pq.peek().val;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
