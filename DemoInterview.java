/**Find longest common prefix in given array of 
 * strings and return none if no prefix matches Input =
 *  {"flower", "flow", "fly"} Output = fl */

 public class DemoInterview {
 
    public static String longPrifix(String[] str){
        if(str == null || str.length == 0){
             return null;}
             String prix = str[0];
             for(int i =1;i<str.length;i++){
                while(str[i].indexOf(prix) != 0){
                    prix = prix.substring(0,prix.length()-1);
                    if(prix.isEmpty()) {
                        return null;
                    }
                }
             }
             return prix;
    }
    public static void main(String[] args) {

        String[] intStr = {"flower","flow", "fly"};
        String result = longPrifix(intStr);
        System.out.println(result);
        
    }
 }
 /

 Clear Vs Flush
HashMap Vs LinkedHashMap by Nanda, Saroj K
Nanda, Saroj K
11:53
HashMap Vs LinkedHashMap
Explain Life cycle of JSP ? by Nanda, Saroj K
Nanda, Saroj K
11:53
Explain Life cycle of JSP ?
JSON ? by Nanda, Saroj K
Nanda, Saroj K
11:54
JSON ?