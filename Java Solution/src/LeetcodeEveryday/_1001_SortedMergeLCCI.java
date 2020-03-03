package LeetcodeEveryday;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2020/3/3 13:05
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 **/
public class _1001_SortedMergeLCCI {
    public static void main(String[] args) {
        //int[] A = new int[]{1, 2, 3, 0, 0, 0};
        //int m = 3;
        //int[] B = new int[]{2, 5, 6};
        //int n = 3;

        int[] A = new int[]{2, 0};
        int m = 1;
        int[] B = new int[]{1};
        int n = 1;

        _1001_SortedMergeLCCI sortedMergeLCCI = new _1001_SortedMergeLCCI();

        sortedMergeLCCI.merge(A, m, B, n);

        System.out.println(Arrays.toString(A));

    }

    /**
     * @param A
     * @param m A数组中元素的和数
     * @param B
     * @param n B数组中元素的个数
     */
    public void merge(int[] A, int m, int[] B, int n) {
        // 如果A是空数组，则B直接深拷贝给A即可
        if (m == 0) {
            System.arraycopy(B, 0, A, 0, n);

            // 浅拷贝不会更改A数组的元素
            //A = B;
            return;
        }
        if (n == 0) {
            return;
        }

        // 保证A数组长
        if (A.length < B.length) {
            merge(B, n, A, m);
            return;
        }

        //solution1(A, m, B, n);
        solution2(A, m, B, n);
        //solution3(A, m, B, n);
    }

    /**
     * 将B追加在A后面之后 再次排序
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void solution1(int[] A, int m, int[] B, int n) {
        System.arraycopy(B, 0, A, m, n);
        Arrays.sort(A);
    }

    /**
     * 选择排序，利用A和B已经有序
     * 创建新的数组C，将A和B的元素转移到新的数组中
     * 最后将C深拷贝给A
     * 缺点：空间复杂度较高O(m+n)
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void solution2(int[] A, int m, int[] B, int n) {

        int[] temp = new int[m + n];
        int i = 0, j = 0;
        int index = 0;

        while (i < m && j < n) {
            if (A[i] < B[j]) {
                temp[index++] = A[i++];
            }else {
                temp[index++] = B[j++];
            }
        }
        // 拷贝剩下的
        while (i < m) {
            temp[index++] = A[i++];
        }
        while (j < n) {
            temp[index++] = B[j++];
        }

        System.arraycopy(temp, 0, A, 0, temp.length);
    }

    /**
     * 不借助额外的空间实现merge
     * 既然A和B都是有序的（加入是升序），A的长度也够merge之后的
     * 也就是说，需要把A中元素之后的0全部占满就可以了
     * 所以，可以倒着来，从A和B都倒着遍历，选最大的放在A的最后，这样就不用在插入之前必须后移了
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void solution3(int[] A, int m, int[] B, int n) {

        // 挨个比较，将最大的依次放到A的结尾
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m -= 1;
            }else {
                A[m + n - 1] = B[n - 1];
                n -= 1;
            }
        }
        // 如果B的元素还没比较晚，则说明B中的元素现在是最小的，所以按照B中的顺序，依次放在A的前面即可
        while (n > 0) {
            A[n-1] = B[n-1];
            n -= 1;
        }


    }

}
