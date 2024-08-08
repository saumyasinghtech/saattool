public class RemoveElement {

    public static int removeEle(int arr[],int val){
        
        int index = 0;
       
        for(int i=0;i<arr.length;i++){
            if(arr[i]!= val){
                arr[index]=arr[i];
               
                index++;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,2,6,2,7};
        int val= 2;
        removeEle(arr, val);
        System.out.println("RESULT : "+removeEle(arr, val));
        for (int num : arr) {
            System.out.print(num + " ,");
        }

       
    }
}