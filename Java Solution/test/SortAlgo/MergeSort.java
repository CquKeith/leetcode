package SortAlgo;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/10/10 16:08
 * 归并排序
 **/
public class MergeSort {
    public static void main(String[] args) {
        int [] array = {1,5,-2,-4,0};

        new MergeSort().mergeSort(array,0,array.length-1);

    }

    /**
     * 分治思想
     * 每次分两半，先mergeSort左边，在mergeSort右边
     * 最后合并
     * @param A
     * @param low
     * @param high
     */
    private void  mergeSort(int[] A,int low,int high){
        if (low < high){
            int mid = (low + high) >> 1;
            mergeSort(A,low,mid);
            mergeSort(A,mid+1,high);

            merge(A,low,mid,high);

            System.out.println(Arrays.toString(A));

        }
    }

    /**
     * merge 两个部分
     * 从low～mid，mid+1～high
     * 两个都是有序的，现在将两个合并成一个整体有序的
     *
     * 算法思想：
     *    1. 借助一个辅助数组B，首先将原数组拷贝过去
     *    2. 逐个确定原数组A中每个位置的数据：
     *      a. 两个指针p q，分别用来遍历B数组的两半
     *      b. 每次选取p q中最小的 作为A当前的元素
     *      c. 最后在统一将左半部分或者右半部分剩余的（只会剩左半部分或者右半部分中的一个）追加到数组A中
     *
     * @param A
     * @param low
     * @param mid
     * @param high
     */
    private void merge(int[] A, int low, int mid, int high) {
        //借助一个辅助数组
        int[] B = Arrays.copyOf(A,A.length);

        int i,j,k;
        for (i = low, j = mid+1,k=low; i <= mid && j<= high; k++) {
            if (B[j]< B[i]){
                A[k] = B[j++];
            }else {
                A[k] = B[i++];
            }
        }
        //统一复制左边或者右边剩下的数据
        while (i<=mid)A[k++]=B[i++];
        while (j<=high)A[k++]=B[j++];

    }


}
