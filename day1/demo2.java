// 自测题作答

// 1.B

// 2.C

// 3.C

// 4.C

// 5.B

// 6.A

// 7.C

// 8.A

// 9.B

// 10.B

// 11.对，因为5/2属于整数相除，结果仍为整数，但是5/2.0属于小数除法，结果为小数

// 12.C

// 13.C

// 14.B

// 15.A

// 16.B

// 17.B

// 18.B

// 19.B

// 20.B

// 21.AD

// 22.B

// 23.D

// 24.A

// 25.C

// 26.B

// 27.B

// 28.BCD

// 29.B

// 30.B

// 31.12

// 32.4

// 33.B

// 34.3 3.5 1

// 35.0 0 0 0 0 2 4 

// 36.9

// 37.abc

// 38.120

// 39.2 3

// 40.2.0    2.5

// 41.2

// 42.4 8 12

// 43.javac用来编译java程序，java用来反汇编
//   .java文件编译后就是.class文件，这个过程叫做JVM

// 44. 1.String后面缺少`[]`（从数组变为了变量）
//     2.变量命名不能以数字开头，应该改为：score3
//     3.使用了final关键字的变量在经过一次赋值后，其数值不能再次变动
// 修改完代码：
// public class test {
//     public static void main(String[] args) {
//         int score3 = 95;
//         final double PI;
//         PI = 3.14;
//         System.out.println(score3);
//     }
// }

// 45.java中的if条件判断只能填写boolean类型的表达式，这样可以避免死循环

// 46.基本类型的定义是在栈上，而引用类型是在堆上

import java.util.Arrays;
import java.util.Locale;
public class demo2 
{
    public static void main(String[] argv)
    {
        // 47.
        for(int i = 0;i < 101;i++)
        {
            if(isPrime(i))
                System.out.println(i);
        }
        // 48.
        int[] arr1 = {1,2,3,4};
        System.out.println(Arrays.toString(reverse(arr1)));
        // 49.
        int[][] arr2 = {{34,56,78,65},{35,78,44,86},{24,57,86,23}};
        Do(arr2);
        // 50.实际输出：pass end
        // 修改方法1：
        int score = 60;
        switch(score){
            case 60: System.out.print("pass ");break;
            default: System.out.print("end");
        }
        // 修改方法2：
        switch(score){
            case 60 -> System.out.print("pass ");
            default -> System.out.print("end");
        }
    }
    // 47.
    // 关键思路：素数只能和它与1取模为0，利用这点判断
    public static boolean isPrime(int n)
    {
        int temp = n - 1;
        while(temp > 1)
        {
            if(n % temp == 0)
                return false;
            temp -= 1;
        }
        return true;
    }
    // 48.
    // 关键思路：创建一个和传入的数组一样大的数组
    // 然后遍历传入的数组，依次往前插入元素
    public static int[] reverse(int[] a)
    {
        int[] reverseArray = Arrays.copyOf(a,a.length);
        int count = reverseArray.length;
        for(int temp : a)
        {
            reverseArray[--count] = temp;
        }
        return reverseArray;
    }
    // 49.
    // 关键思路：遍历每一行，利用智能for找到最大值和总和，最后将行数据统一输出
    public static void Do(int[][] score)
    {
        for(int i = 0;i < score.length;i++)
        {
            int max = 0;
            int total = 0;
            for(int s : score[i])
            {
                if(s > max)
                    max = s;
                total += s;
            }
            System.out.printf(Locale.US,"for row%d: max score = %d and total score = %d%n",i,max,total);
        }
    }
}
