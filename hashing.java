import java.util.*;
public class hashing {

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char ch : t.toCharArray()){
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }

    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();
        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }
        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();
        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        // System.out.println(hm);

        // // Get - O(1)
        // int population = hm.get("India");
        // System.out.println(population);

        // System.out.println(hm.get("Indonesia"));

        // // ContainsKey - O(1)
        // System.out.println(hm.containsKey("Indonesia"));

        // // Remove - O(1)
        // System.out.println(hm.remove("Chinaa"));
        // System.out.println(hm);

        // // size
        // System.out.println(hm.size());

        // //isEmpty()
        // hm.clear();
        // System.out.println(hm.isEmpty());

        //iterate on hm
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);
        // for(String  k : keys){
        //     System.out.println(k+"="+hm.get(k));
        // }

        //LinkedHashMap
        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India", 100);
        // lhm.put("China", 150);
        // lhm.put("US", 50);
        // System.out.println(lhm);

        // TreeMap
        // TreeMap<String, Integer> tm = new TreeMap<>();
        // tm.put("India", 100);
        // tm.put("China", 150);
        // tm.put("US", 50);
        // System.out.println(tm);

        // Q. Majority element greater than n/3
        // int arr[] = {1,3,2,5,1,3,1,5,1};
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<arr.length;i++){
        //     map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        // }
        // for(int key : map.keySet()){
        //     if(map.get(key) > arr.length/3){
        //         System.out.println(key);
        //     }
        // }

        // Q. Valid Anagram
        // String s = "race";
        // String t = "care";
        // System.out.println(isAnagram(s, t));

        // HashSet
        // HashSet<String> cities = new HashSet<>();
        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Noida");
        // cities.add("Bengaluru");
        // iterating through iterator method
        // Iterator it = cities.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
        
        // iterating through advanced loops
        // for(String city : cities){
        //         System.out.println(city);
        // }
                
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Delhi");
        // lhs.add("Mumbai");
        // lhs.add("Noida");
        // lhs.add("Bengaluru");
        // lhs.remove("Mumbai");
        // System.out.println(lhs);

        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Delhi");
        // ts.add("Mumbai");
        // ts.add("Noida");
        // ts.add("Bengaluru");
        // ts.remove("Mumbai");
        // System.out.println(ts);

        // Q. count distinct elements
        // int nums[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        // HashSet<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // System.out.println(set.size());

        // Q. Union and Intersection of 2 Arrays
        // int arr1[] = {7,3,9};
        // int arr2[] = {6,3,9,2,9,4};
        // HashSet<Integer> set = new HashSet<>();
        // for(int num : arr1){
        //     set.add(num);
        // }
        // for(int num : arr2){
        //     set.add(num);
        // }
        // System.out.println(set.size()); // union
        // set.clear();
        // for(int num : arr1){
        //     set.add(num);
        // }
        // int count = 0;
        // for(int num : arr2){
        //     if(set.contains(num)){
        //         count++;
        //         set.remove(num);
        //     }
        // }
        // System.out.println(count); // intersection

        // find itinerary for tickets
        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");
        // String start = getStart(tickets);
        // System.out.print(start+"->");
        // for(String key : tickets.keySet()){
        //     System.out.print(tickets.get(start)+"->");
        //     start = tickets.get(start);
        // }
        // System.out.println();


        // largest subarray with 0 sum
        // int arr[] = {15, -2, 2, -8, 1, 7, 10};
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int sum = 0;
        // int len = 0;
        // for(int j=0; j<arr.length; j++){
        //     sum+=arr[j];
        //     if(map.containsKey(sum)){
        //         len = Math.max(len, j - map.get(sum));
        //     }else{
        //         map.put(sum, j);
        //     }
        // }
        // System.out.println(len);

        // no. of subarray whose sum equal to k
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>(); // (sum,count)
        int sum = 0;
        int ans = 0;
        map.put(0,1);
        for(int j=0; j<arr.length; j++){
            sum+=arr[j];
            if(map.containsKey(sum - k)){
                ans+=map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
