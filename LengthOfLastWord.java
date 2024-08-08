public class LengthOfLastWord {

    //worise case time complexity = O(n)
    public static int lengthOfWord(String str){
        str = str.trim();
        int length = 0;
        for(int i= str.length()-1;i>=0;i--){
            if(str.charAt(i)!= ' '){
                length++;
            }
            else{
                break;
            }
        }
        return length;
    }
    public static String longestCommanPrifix(String[] str){
        int n = str.length;
        if(n==0){
            return "";
        }
        String s = str[0];
        int res = s.length();
        for(int i =1;i<n;i++){//array of string ,
            String str1 = str[i];
            int j=0;// each string ka ak ak character check krne ke liye
            int count =0;
            while(j<s.length() && j<str1.length()){
                if(s.charAt(j) == str1.charAt(j)){
                    count++;
                }else{
                    break;
                }
                j++;
            }
            if(count < res){
                res= count;
            }
        }
        return str[0].substring(0, res);
    }
    public static void main(String[] args) {
         String str = "Good morning shubham      ";
         String[] str1 ={"saumya", "shubham","spatil"};
         System.out.println("RESULT = "+ lengthOfWord(str));
         System.out.println("COMMON PRIFIX = "+ longestCommanPrifix(str1));
    }
}