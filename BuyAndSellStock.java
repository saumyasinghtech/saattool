public class BuyAndSellStock {

    public static  int buySell(int[] arr){
        int n = arr.length;
         int buy = arr[0];
         int profit =0;
         for(int i=1;i<n;i++){
            if(arr[i]<buy){
                buy = arr[i];
            }
            else if((arr[i]-buy)>profit){
                profit = arr[i]- buy;
            }
         }
         return profit;
    }
    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        System.err.println("Profit : "+ buySell(price));
    }
}