import java.util.*;
public class stackPart1 {
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb=new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }
    
    public static void reverseAStack(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top=s.pop();
        reverseAStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int[] stocks,int[] span){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
    }
    public static void nextGreaterElement(int[] arr,int[] nextGreater){
        Stack<Integer> s=new Stack<>();
        int j=arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]>=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[j]=-1;
            }else{
                nextGreater[j]=arr[s.peek()];
            }
            j--;
            s.push(i);
        }
    }
    public static void main(String[] args) {
        // Stack<Integer> s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s,4);
        // reverseAStack(s);
        // printStack(s);
        // String str="abc";
        // System.out.println(reverseString(str));

        // int stocks[]={100,80,60,70,60,85,100};
        // int span[]=new int[stocks.length];
        // stockSpan(stocks,span);
        // for(int i=0;i<span.length;i++){
        //     System.out.println(span[i]+" ");
        // }
        int[] arr={6,8,0,1,3};
        int[] nextGreater=new int[arr.length];
        nextGreaterElement(arr,nextGreater);
        for(int i=0;i<nextGreater.length;i++){
            System.out.println(nextGreater[i]);
        }
    }
}
