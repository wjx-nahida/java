import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;
import java.util.Random;

public class demo1
{
    public static void main(String[] argv)
    {
        // System.out.print(argv);

        // 输出结果为3（1 + 2 = 3）
        System.out.println(1 + 2);

        // 1.char和String的加法运算区别
        // 输出结果为x12，因为x为字符串，字符串使用加号连接就会变为字符串拼接
        System.out.println("x" + 1 + 2);

        // 和上面不同，这里的x并不是字符串类型，而是char类型
        // 而char类型在面对加法运算的时候会自动转换为整型
        // x的ASCII码值为120，所以结果为123（1 + 2 + 120 = 123）
        System.out.println(1 + 2 + 'x');


        // 2.短路运算符和非短路运算符
        int a = 1;
        int b = 2;
        // 对于短路运算符（&& 或者 ||），如果只通过前面的条件就可以确定布尔值，那么就不会计算后面的条件
        // 例如demo1中条件 a == 1 已经可以确定demo1的值为true，就不会计算后面的 b++ == 2
        boolean demo1 = (a == 1) || (b++ == 2);
        // 而对于非短路运算符（& 或者 |），会在两端的条件都运行完毕再输出布尔值，不会中途暂停
        boolean demo2 = (a == 1) | (b++ == 2);
        System.out.println(demo1);
        System.out.println(demo2);
        System.out.println(b);

        // 3.if
        int score = 90;
        if(score > 90){
            System.out.println("A");
        }
        else if(score <= 90 && score > 80){
            System.out.println("B");
        }
        else if(score <= 80 && score > 60){
            System.out.println("C");
        }
        else{
            System.out.println("D");
        }
        // 需要注意的是：if里面的语句的结果必须是boolean类型的！不可以是其他数据类型
        // int n = 10;
        // if(n)
        // {

        // }
        // 上述就是典型的错误示范

        // 4.switch
        // 和C语言的switch一样，都是需要使用break避免贯穿
        int nahida1 = 1;
        switch(nahida1){
            case 1: System.out.println("1");
            case 2: System.out.println("2");
            case 3: System.out.println("3"); break;
            case 4: System.out.println("4");
            case 5: System.out.println("5");
            default: System.out.println("other");
        }
        // switch还有另一种写法，不需要break也可以避免贯穿
        int nahida2 = 2;
        switch(nahida2){
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 3 -> System.out.println("3");
            case 4 -> System.out.println("4");
            default -> System.out.println("other");
        }
        // 如果想让多个case语句执行同一个语句，可以这样操作：
        int nahida3 = 4;
        switch(nahida3){
            case 1,2,3,4,5 -> System.out.println("1,2,3,4,5");
            default -> System.out.println("other");
        }

        // 5.块作用域
        int x = 10;
        {
            int y = 20;
            System.out.println(x);
            System.out.println(y);
        }
        System.out.println(x);
        // System.out.println(y);   离开块作用域，内部定义的变量无法在外部使用

        // 6.for / while / do-while
        // 普通for
        for(int i = 0;i < 5;i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr = {1,2,3,4,5};
        // 自动for
        for(int v: arr)
        {
            System.out.print(v);
        }
        System.out.println();
        // while
        int i = 5;
        while(i > 0){
            System.out.print(i + "->");
            i--;
        }
        // do-while
        do {
            System.out.print(i + "->");
            i++;
        }while(i < 5);
        System.out.println();

        // 7.数组
        int[] arr1;
        arr1 = new int[3];
        arr1[1] = 2;
        System.out.println(arr1);
        for(int j = 0;j < arr1.length;j++)
        {
            System.out.print(arr1[j] + " ");
        }

        int[] arr2 = {1,2,3};
        for(int j = 0;j < arr2.length;j++)
        {
            System.out.print(arr2[j] + " ");
        }  
        System.out.println();

        int[][] arr3;
        arr3 = new int[2][3];
        System.out.println(arr3.length);
        System.out.println(arr3[1].length);

        int[][] t = {{1,2,3},{1,2}};
        System.out.println(t[0].length);
        System.out.println(t[1].length);

        int[] arr4 = {3,1,2};
        // 输出整个数组
        System.out.println(Arrays.toString(arr4));
        // 从小到大排序
        Arrays.sort(arr4);
        System.out.println(Arrays.toString(arr4));
        // 获取某个数字的下标
        int temp = Arrays.binarySearch(arr4,3);
        System.out.println(temp);
        // 填充同一个数字
        Arrays.fill(arr4,9);
        System.out.println(Arrays.toString(arr4));
        // 拷贝
        int[] arr5 = Arrays.copyOf(arr4,6);
        System.out.println(Arrays.toString(arr5));
        // 复制arr4的[1,2)
        int[] arr6 = Arrays.copyOfRange(arr4,1,2);
        System.out.println(Arrays.toString(arr6));
        // 克隆
        int[] arr7 = arr4.clone();
        System.out.println(Arrays.toString(arr7));

        for(String arg : argv)
        {
            System.out.println(arg);
        }

        // 8.方法
        System.out.println(Add(1,2));
        Say();
        Function1(1,2);
        Function1(1,1.0);
        System.out.println(Fact(10));

        // 9.可变参数
        System.out.println(AddAll(1,2,3,4,5,6));
        int[] arr8 = {1,2,3,4,5};
        System.out.println(AddAll(arr8));

        // 10.输入输出
        Scanner sc = new Scanner("1020\n 3.14 6.28 hello nahida\n");  
        System.out.println(sc.nextInt());
        System.out.println(sc.next());
        System.out.println(sc.nextDouble());
        System.out.println(sc.next());
        sc.close();

        int temp2 = 10;
        System.out.printf(Locale.US,"%d this is a format from printf%n",temp2);

        Random r = new Random(67);
        System.out.println(r.nextInt(100));
        System.out.println(r.nextDouble(2.0));
        System.out.println(r.nextBoolean());
    }
    public static int Add(int a,int b)
    {
        return a + b;
    }
    public static void Say()
    {
        System.out.println("hello nahida!");
    }
    public static void Function1(int a,int b)
    {
        System.out.println("this function is for int a and int b");
    }
    public static void Function1(int a,double b)
    {
        System.out.println("this function is for int a and double b");
    }
    public static int Fact(int n)
    {
        if(n <= 1)
            return 1;
        return n * Fact(n - 1);
    }

    public static int AddAll(int... nums)
    {
        int result = 0;
        for(int num : nums)
        {
            result += num;
        }
        return result;
    }
}