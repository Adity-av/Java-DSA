import java.util.*;
public class hashing {
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
        // int n=arr.length;
        // for(int key : map.keySet()){
        //     if(map.get(key) > n/3){
        //         System.out.println(key);
        //     }
        // }
    }
}
