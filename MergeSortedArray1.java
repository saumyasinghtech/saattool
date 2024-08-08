public class MergeSortedArray1 {

    public static void marge(int[] arr1, int m, int[] arr2, int n ){

       /**  int i = m-1;
        int j =n-1;
        int k = m+n-1;
        while(j>=0){
            if(i>=0 && arr1[i]>arr2[j]){
                arr1[k]= arr1[i];
                
                i--;
            }
            else{
                arr1[k] = arr2[j];
                
                j--;
            }
            k--;
        }*/
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }
    }
    public static void main(String[] args) {
        int arr1[] = {2,10,9,33,0,0,0,0};
        int arr2[] = {55,98,25,63};
        int m =4;
        int n = 4;

        marge(arr1,m,arr2,n);
        
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        
    }
}