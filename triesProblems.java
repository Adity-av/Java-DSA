public class triesProblems {
    static class Node{
        Node children[]=new Node[26];
        boolean eow = false;
        int freq;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }
    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans){ // O(L), where L is levels in my trie = longest word length
        if(root == null){
            return;
        }
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static boolean startsWith(String prefix){ // O(L)
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root){
        if(root == null) return 0;

        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static String ans="";
    public static void longestWord(Node root, StringBuilder temp){
        if(root==null) return;// never happens only written for clearity
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                //backtrack
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        // Prefix Problem
        // String arr[] = {"zebra", "dog", "duck", "dove"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);
        // }
        // root.freq = -1;
        // findPrefix(root, "");

        //startsWith Problem
        // String arr[] = {"app", "apple","mango","man","woman"};
        // for(int i=0;i<arr.length;i++){ // write simple insert no need of frequency
        //     insert(arr[i]);
        // }
        // String prefix = "apple";
        // System.out.println(startsWith(prefix));

        //Unique Substrings
        // String str = "app";
        //suffix -> insert in trie
        // for(int i=0;i<str.length();i++){
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNodes(root));

        //Longest word with all Prefix
        String words[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
