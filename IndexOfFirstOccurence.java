public class IndexOfFirstOccurence {
        public static int indexOfFirstOccurence(String haytext, String niddletext){
            int heylen = haytext.length();
            int niddlen = niddletext.length();
            if(heylen < niddlen){
                return -1;
            }
            for(int i =0;i<= heylen-niddlen;i++){
                int j=0;
                while(j< niddlen && haytext.charAt(i+j) == niddletext.charAt(j)){
                    j++;
                }
                if(j == niddlen){
                    return i;
                }
            }
            return -1;
        }
    public static void main(String[] args) {
        String str1 = "tsadbutsad";
        String sub = "sad";
        System.out.println("RESULT "+indexOfFirstOccurence(str1, sub));
    }
}