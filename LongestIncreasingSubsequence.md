# Longest Increasing Subsequence

最长递增子序列，求一个序列中最长的元素为递增的子序列

## 解法一

### 利用 最长公共子序列求

先将原序列排序，然后求原序列和排序后序列的最长公共子序列即可。有关LCS参看Longest Common Subsequence.md

```java
public class LongestCommonSubsequence {
///求最长公共子序列
    public static void main(String[] args){
		System.out.println(getLCS(new int[]{1,2,4,5,6,7,8},new int[]{5,4,2,1,6,7,8}));
	}	

	public static int getLCS(int[] a, int[] b){
		if (a.length == 0 || b.length == 0) {
			return 0;
		}
		int[][] dp = new int[a.length + 1][b.length + 1];
		for (int i = 1; i <= a.length ;i++ ) {
			for (int j = 1; j <= b.length ; j++) {
					dp[i][j] = a[i-1] == b[j-1] ? dp[i-1][j-1] + 1 : Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
	
		return dp[a.length][b.length];
	}
}
```



## 解法二

### 动态规划 ---- time complexity O(n^2)

设dp[i] 为数组A的前缀串A[0 - i] 以ai为结尾的LIS的长度，则状态转移方程：

dp[i] = {max( L(j) ) + 1，j<i 且a[j] < a[i] }。则原数组的LIS为dp[i] 中最大值。

```java
    public static int getLISDP(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = max < dp[i] ? dp[i] : max;
        }
        return max;
    }
```





## 解法三

### 贪心  ---- time complexity O(nlgn)

从头开始扫描数组，用一个缓存数组dp来保存当前前缀串的LIS的最优形态（dp递增，但并不是LIS,**它只是存储的对应长度LIS的最小末尾**, 如dp[i] 是长度为i+1的最有潜质（结尾最小则最有构成更长LIS的潜质）的LIS的末尾元素），

s表示当前前缀串的长度。最后返回s即可。

当扫描到a[i]时，如果a[i] 比缓存数组的dp[s]大，s++，新的dp[s]赋值为a[i]；如果不小则找到dp中大于等于a[i]的最小元素并用a[i]将其替换。

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[s] < nums[i]) {
                dp[++s] = nums[i];
            } else if (dp[s] > nums[i]) {
                int k = getMGT(dp, nums[i], 0, s);
                dp[k] = nums[i];
            }
        }
        return s + 1;
    }
   static int getMGT(int[] a, int k, int low, int hi) {
        int mid;
        while (low < hi - 1) {
            mid = (low + hi) / 2;
            if (a[mid] > k) {
                hi = mid;
            } else {
                low = mid;
            }
        }
        if (a[low] >= k) return low;
        return hi;
    }
}
```



