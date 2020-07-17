## 查找目标字符串在源字符串中第一次出现的索引

题目描述：输入一个字符串，返回该字符串在源串中第一次出现的索引

例：输入abc，源串为 acabcd，返回3



```java
public class Main(String[] args){
    public static void main(String[] args){
        System.out.println(firstIndex("bill", "tsaobill"));
    }
    public static int firstIndex(String t, String s){
        if(t == null || s == null) return -1;
        int j;
        for(int i = 0; i < s.length(); i++){           
            for(int j = 0; j < t.length(); j++){
                if(t.charAt(j) != s.charAt(i)) break;
            }
            if(j == t.length() - 1) return i;
        }
        return -1;
    }
    
}
```

