# Distinct Subsequence

```java
public class DistinctSubSequence {

    public static void main(String[] args) {
        System.out.println (solve ("rabbbit","rabbit"));
    }
    public static int solve(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        if (nt == 0) return 1;
        if (ns == 0) return 0;
        //dp[i][j]表示0~i-1的s子串中包含0~j-1的t的个数
        int[][] dp = new int[ns + 1][nt + 1];
        for (int i = 0; i <= ns; i++) dp[i][0] = 1;
        for (int i = 1; i <= nt; i++) dp[0][i] = 0;

        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= nt; j++) {
                dp[i][j] = dp[i - 1][j];//相当于s在i位置的元素不拿
                if (s.charAt(i - 1) == t.charAt(j - 1)) {//相当于s在i位置的元素拿,且他与t对应位相同
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[ns][nt];
    }
}
```



递归求解

```java
public static int solve(String s, String t){
     if(t.length() == 0) return 1;
     if(s.length() == 0) return 0;
     int count = 0;
     for(int i = 0; i < s.length(); i++){
         if(s.charAt(i) == t.charAt(0)){
             count += solve(s.substring(i+1),t.substring(1));
         }
     }
     return count;
}
```

