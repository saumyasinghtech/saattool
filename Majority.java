import java.util.HashMap;
import java.util.Map;

public class Majority {

    public static int majorityElement(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))//it checked that element is already in map or not
            {
                //if not
                int count = map.get(arr[i]);
                map.put(arr[i],count+1);
            }else{
                //if element matched
                map.put(arr[i],1);
            }
        }
        //itterate the map
        for(Map.Entry<Integer,Integer> result : map.entrySet()){
            if(result.getValue()> arr.length/2){
                return result.getKey();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr[]= {2,2,1,1,1,2,2};
        System.out.println("Hello");
        System.out.println(majorityElement(arr));
    }
}