public class ReserveWord {

    public static String reverseWord(String str){
        String[] strArr = str.trim().split("\\s+");
        StringBuilder strb= new StringBuilder();
        for(int i=strArr.length-1;i>=0;i--){
            strb.append(strArr[i]);
            if(i>0){
                strb.append(" ");
            }
        }
        return strb.toString();
    }
    public static void main(String[] args) {
        //Input: s = "a good   example"
        //Output: "example good a"
        String str = "  a good example  ";
        
        reverseWord(str);
        System.out.println("RESULT : "+ reverseWord(str));
        
    }
}