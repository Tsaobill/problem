题目：


度度熊有一个N个数的数组，他想将数组从大到小排好序，但是萌萌的度度熊只会下面这个操作：
任取数组中的一个数然后将它放置在数组的最后一个位置。
问最少操作多少次可以使得数组从小到大有序？ 
输入描述:
首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)


输出描述:
输出一个整数表示最少的操作次数。

输入例子:
4
19 7 8 25

输出例子:
2

---------------------




思路：

  1.题目要求的是最少次数排好序，因此，理想情况的移动规则是第一次将倒数第二小的数移到最后，接着将第三小的数移到最后面，依次移动，最后原数组按照从小到大排好序，这样移动的次数也是最少。
  2.先把数组排好序，然后从小到大检测相邻的一对数的各自原始位置，如果a<b,但是原数组中a在b的后面，那就必须将b移到最后的位置，然后更新b的原始位置，移动后b在数组的最后面的位置。因为是从小到大检测的，小的数必然会被先移到后面，符合移动规则。
  3.具体实现时，采用HashMap，key为数组的数，value为当前位置，实际把一个数移到最后一位，不需要实际移位操作，只需要把value置为数组末尾位置，就代表移到最后了。此时设想数组为动态数组，数组大小可以变化。





```java
package baidu;
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
 
public class test4_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			HashMap<Integer, Integer> map = new HashMap<>();
			int i;
			for (i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
				map.put(a[i], i);   //将数组的值作为key，值得位置作为value存储在hashmap中
			}
			Arrays.sort(a);
			int sum = 0;
			for (int j = 0; j < n - 1; j++) {
				if (map.get(a[j + 1]) < map.get(a[j])) {
					map.put(a[j + 1], i++); //将a[j+1]移动到数组最后面，此时a[j+1]在数组中的位置为i,i++存储下一个逆序数
					sum++;
				}
			}
			System.out.println(sum);
		}
 
	}
}

```

