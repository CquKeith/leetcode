package CompanyInterviews2020.ShunFengTongCheng;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenmengliang
 * @date 2019/11/4 15:09
 * 两个递减有序的数组，求第K大的值
 **/
public class ShunfengTongcheng3Test {

    private final int m = 10;
    private final int n = 5;


    private int[] A;
    private int[] B;

    public static void main(String[] args) {
        ShunfengTongcheng3Test tongcheng3Test = new ShunfengTongcheng3Test();

        tongcheng3Test.prepareData();


        System.out.println(Arrays.toString(tongcheng3Test.A));
        System.out.println(Arrays.toString(tongcheng3Test.B));
        int k = 7;


        // test
        List<Integer> list = Arrays.stream(tongcheng3Test.A).boxed().collect(Collectors.toList());
        list.addAll(Arrays.stream(tongcheng3Test.B).boxed().collect(Collectors.toList()));
        // 逆序排序
        list.sort((a, b) -> b - a);
        System.out.println(list);
        System.out.println(list.get(k - 1));

        // test

        System.out.println(tongcheng3Test.topKBig(tongcheng3Test.A, tongcheng3Test.B, k));


    }

    /**
     * 第k大的数
     * 每次先取A的k/2,再去B的k/2,
     * A[0~k/2-1],B[0,k/2-1]
     * 如果A[k/2-1] > B[k/2-1],那么舍弃A[0~k/2-1]，因为A[k/2-1]>B[k/2-1]时，那么按照递减的顺序A[k/2-1] U B[k/2-1]，B[k/2-1]肯定在并集最后
     * 而并集的大小总共才是K
     * 如果A[k/2-1] < B[k/2-1],舍弃B[k/2-1]
     * 如果A[k/2-1] = B[k/2-1],返回A[k/2-1]
     *
     * @param k
     * @return
     */
    private int topKBig(int[] A, int[] B, int k) {

        if (null == A || A.length == 0) {
            return B[k - 1];
        }
        if (null == B || B.length == 0) {
            return A[k - 1];
        }
        if (k == 1) {
            return Math.max(A[0], B[0]);
        }

        // 保证数组A比数组B短
        if (A.length > B.length) {
            return topKBig(B, A, k);
        }


        return findTopKBig(A, 0, A.length - 1, B, 0, B.length - 1, k);

    }

    /**
     * A 比B短
     * @param A
     * @param aStart A的起始
     * @param aEnd   A的结束
     * @param B
     * @param bStart
     * @param bEnd
     * @param k      第K大
     * @return
     */
    private int findTopKBig(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {

        if (aStart > aEnd && (bStart + k - 1 < B.length)) {
            return B[bStart + k - 1];
        }

        if (k == 1) {
            return Math.max(A[aStart], B[bStart]);
        }


        //  取当前A B的第k/2个数，如果超过了有效长度，就取最后一个位置
        int pa = Math.min(k / 2, aEnd - aStart + 1);
        int pb = Math.min(k-pa, bEnd - bStart + 1);

        int m = aStart + pa - 1;
        int n = bStart + pb - 1;

        if (A[m] > B[n]) {
            // 舍弃A[start~m]
            return findTopKBig(A, m+1, aEnd, B, bStart, bEnd, k-pa);
        } else if (A[m] < B[n]) {
            // 舍弃B[start~n]
            return findTopKBig(A, aStart, aEnd, B, n+1, bEnd, k-pb);
        } else {
            return A[m];
        }

    }


    private void prepareData() {
        A = new int[m];
        for (int i = m; i > 0; i--) {
            A[m - i] = i;
        }
        B = new int[n];
        for (int i = n; i > 0; i--) {
            B[n - i] = m / 2 + i;
        }
    }

}
