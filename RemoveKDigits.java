 public class RemoveKDigits{
     public static void main(String[] args){
         System.out.println(removeKdigits("1432219",3));
     }   
        public static String removeKdigits(String num, int k) {
        if(num.length() == k)return "0";
        int newLen = num.length() - k;
        char[] res = new char[num.length()];
        int top = 0;
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(k > 0 && top > 0 && res[top - 1] > c){
                top--;
                k--;
            }
            res[top++] = c; 
        }
        
        int offset = 0;
        while(offset < newLen && res[offset] == '0'){
            offset++;
        }
       return offset == newLen ? "0" : new String(res, offset, newLen - offset).replaceAll("\u0000","");
    }
}
