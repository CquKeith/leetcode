package CompanyInterviews2020.iQiyi;

import java.util.Scanner;

/**
 * @author Keith
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int max = 0;
        int[] array = new int[n+10];
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
            max = Math.max(max,array[i]);
        }
        long ans;
        if (sum % (n-1) == 0){
            ans = sum/(n-1);
        }else {
            ans = sum/(n-1)+1;;
        }
        System.out.println(Math.max(max,ans));

        scanner.close();
    }
}
/*
    或和异或
首先给出一个长度为k=2^n（其中n为正整数）的序列A={a1，a2…a_{k-1},ak}，我们定义一个值v，这个值是由如下计算方法得到的，首先将A序列的第 i 位和第 i+1 位进行 OR 操作得到新数列A‘，然后再对A’序列操作，将A’ 序列的第 i 位和第 i+1 位进行 XOR 操作得到A‘’，对A‘’按照第一次操作方式进行OR操作，因为序列长度为2^n,所以显然进行n次操作之后就只剩下一个数字了，此时这个数字就是v。

        例如A={1，2，3，4}，第一次操作之后为{1|2=3，3|4=7}，第二次操作后，{3^7=4},所以v=4。

        但是显然事情并没有那么简单，给出A序列后，还有m个操作，每个操作表示为“a b”，表示将A[a]改为b，之后再对A序列求v值。（注意每一次对序列的修改的永久的，即第i次修改是建立在前i-1次修改之上的）


        输入第一行包含两个正整数n，m，分别表示A序列的长度为2^n,操作数量为m。（1<=n<=17,1<=m<=10^5）

        输入第二行包含n个正整数，中间用空格隔开，表示A序列。（0<=ai<=2^30）

        接下来有m行，每行包含两个正整数a，b，表示一次操作，即把A[a]变成b。

        输出
        输出包含m行，第i行表示进行了第i次操作之后，A序列的v值。


        样例输入
        2 4
        1 2 3 4
        1 4
        3 4
        1 3
        1 3
        样例输出
        1
        2
        7
        7
 **/