import java.util.*;
public class stackPart2 {
    public static boolean isValid(String str){
        Stack<Character> s= new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek()=='(' && ch==')'
                || s.peek()=='[' && ch==']'
                || s.peek()=='{' && ch=='}'){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static boolean isDuplicate(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==')'){
                int count = 0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
    }
    public static void nextGreater(int[] heights){
        Stack<Integer> s=new Stack<>();
        int greater[]=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[i]>heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                greater[i]=-1;
            }else{
                greater[i]=heights[s.peek()];
            }
            s.push(i);
        }
        printArr(greater);
    }
    public static int[] nextSmallerRight(int[] heights){
        Stack<Integer> s=new Stack<>();
        int smallerRight[]=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                smallerRight[i]=heights.length;
            }else{
                smallerRight[i]=s.peek();
            }
            s.push(i);
        }
        return smallerRight;
    }
    public static int[] nextSmallerLeft(int[] heights){
        Stack<Integer> s=new Stack<>();
        int smallerLeft[]=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                smallerLeft[i]=-1;
            }else{
                smallerLeft[i]=s.peek();
            }
            s.push(i);
        }
        return smallerLeft;
    }
    public static int histogram(int[] heights, int[] smallerLeft, int[] smallerRight){
        int[] area=new int[heights.length];
        smallerLeft=nextSmallerLeft(heights);
        smallerRight=nextSmallerRight(heights);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int height=heights[i];
            int width=smallerRight[i]-smallerLeft[i]-1;
            area[i]=height*width;
            int currArea=height*width;
            maxArea=Math.max(currArea, maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        // Stack<Character> s=new Stack<>();
        // // String str="({[]}())";

        // String str1="((a+b))";
        // String str2="(a-b)";
        // // System.out.println(isValid(str));
        // System.out.println(isDuplicate(str1));
        // System.out.println(isDuplicate(str2));
        int heights[]={2,1,5,6,2,3};
        int[] smallerLeft=new int[heights.length];
        int[] smallerRight=new int[heights.length];
        // nextGreater(heights);
        // nextSmallerRight(heights);
        // nextSmallerLeft(heights);
        System.out.println(histogram(heights,smallerLeft,smallerRight));
    }
}
