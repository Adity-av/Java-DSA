import java.util.*;
public class strings {
    public static boolean palindromeOrNot(String str){
        int n=str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public static float shortestPath(String str){
        int x=0,y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                x++;
            }else if(str.charAt(i)=='S'){
                x--;
            }else if(str.charAt(i)=='E'){
                y++;
            }else{
                y--;
            }
        }
        return (float)Math.sqrt((x*x)+(y*y));
    }
    public static void printSubstring(String str){
        int si=0,ei=5;
        String substr="";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        System.out.println(substr);
    }
    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String stringCompress(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            int c=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                c++;i++;
            }
            if(c>1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // String str="Hello World";
        // System.out.println(palindromeOrNot(str));
        // System.out.println(shortestPath(str));
        // printSubstring(str);
        // String fruits[]={"apple","Mango","banana"};
        // String largest=fruits[0];
        // for(int i=1;i<fruits.length;i++){
        //     if(largest.compareToIgnoreCase(fruits[i])<0){
        //         largest=fruits[i];
        //     }
        // }
        // System.out.println(largest.toLowerCase());
        // StringBuilder sb=new StringBuilder("");
        // for(char ch='a';ch<='z';ch++){
        //     sb.append(ch);
        // }
        // System.out.println(sb);
        // String str="aaabbcccdd";
        // System.out.println(toUpperCase(str));
        // System.out.println(stringCompress(str));
        //h1 q1. Count how many times lowercase vowels occurred in a String entered by the user.
        // Scanner sc=new Scanner(System.in);
        // String line=sc.nextLine();int count=0;
        // for(int i=0;i<line.length();i++){
        //     if(line.charAt(i)=='a'|| line.charAt(i)=='e'||line.charAt(i)=='i'||line.charAt(i)=='o'||line.charAt(i)=='u'){
        //         count++;
        //     }
        // }
        // System.out.println(count);
        // String str="ApnaCollege".replace("l","");
        // System.out.println(str);
        String str1="race";
        String str2="care";
        str1.toLowerCase();
        str2.toLowerCase();
        if(str1.length()!=str2.length()){
            System.out.println("Not an anagram");
        }else{
            char str1CharArray[]=str1.toCharArray();
            char str2CharArray[]=str2.toCharArray();
            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);
            if(Arrays.equals(str1CharArray, str2CharArray)){
                System.out.println("ANAGRAMS!");
            }else{
                System.out.println("Not an anagram");
            }
        }
    }
}
