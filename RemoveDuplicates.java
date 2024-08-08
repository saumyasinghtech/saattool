import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//remove duplicate element from unsorted array by brut froce(O(n^2))
public class RemoveDuplicates {
    public static int removeElement(int[] arr){
        //13422
        int result = 0;
        for(int i =0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    result= arr[i];
                }
            }
        }
        return result;
    }
//remove duplicate element from unsorted array by hashMap(O(n))
    public static  List<Integer>  removeByMap(int[] arr){
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                duplicates.add(arr[i]);
            }else{
                set.add(arr[i]);
            }
        }
        return duplicates;
    }
    //remove duplicate element from sorted array
 public static int removeDuplicates(int[] arr){
     int j =1;
     for(int i=1;i<arr.length;i++){
        if(arr[i]!=arr[j-1]){
            arr[j]=arr[i];
            j++;
        }     
        }
        return j;
     //time complexity is O(n) & space complexity is O(1)   
     }
     
   //remove duplicate element from sorted array, at most twice are present in array
   public static int removeDuplicatesTwice(int[] arr){
   /**  int j =2;
    for(int i=2;i<arr.length;i++){
        if(arr[i]!= arr[j-2]){
            arr[j]=arr[i];
            j++;
        }
    }
    return j;*/
    if (arr.length <= 2) return arr.length;
    int c=1;
    int j = 2;  // Start from the third element
    for (int i = 2; i < arr.length; i++) {
        if (arr[i] != arr[j - 2]) {
            arr[j] = arr[i];
            j++;
            c++;
        }
    }
    return c;
   }

    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,1,2,2,3,3,3,4,5,5};
        System.out.println("RESULT : "+ removeDuplicates(arr));
        int k1 = removeDuplicatesTwice(arr);
        System.out.println("Output: " + k1 + ", nums = " + Arrays.toString(Arrays.copyOf(arr, k1)));

        //System.out.println("Second result : "+ removeDuplicatesTwice(arr));
        
        int[] arr4 = {1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 3};
        List<Integer> duplicates = removeByMap(arr4);
        System.out.println("Duplicate elements: " + duplicates);
    }
}