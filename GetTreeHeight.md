## 题目描述

现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度

### 输入描述:

输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成， 
下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号

### 输出描述:

###### 输出树的高度，为一个整数
作者：_Running_Snail_ 
来源：CSDN 
原文：https://blog.csdn.net/xp406181/article/details/79482248


```java

public class Program
{
    public static void Main()
    {
        var num = int.Parse(Console.ReadLine());

        var sum = 0;
        var arr = new int[num, 1];

        var heightArr = new int[num];
        var childArr = new int[num];
        for (int i = 0; i < num - 1; i++)
        {
            var nums = Console.ReadLine().Split();

            var parent = int.Parse(nums[0]);
            var child = int.Parse(nums[1]);

            if (childArr[parent] < 2)
            {
                childArr[parent]++;

                if (heightArr[parent] == 0) heightArr[parent] = 1;
                heightArr[child] = heightArr[parent] + 1;
                sum = Math.Max(heightArr[child], sum);
            }
            else
            {
                childArr[child] = 999;
                heightArr[child] = 0;
            }
        }


        Console.WriteLine(sum);
    }
}

```

