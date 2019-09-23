package SortAlgo;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/22 11:05
 **/
public class InsertSort {
    public static void main(String[] args) {
        //int [] array = {34,65,12,43,67,5,78,10,3,3,3,70};
        int [] array = {1,5,-2,-4,0};
        new InsertSort().insertSort(array,array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 折半插入
     * @param array
     * @param n 数组长度
     */
    private void insertSort(int[] array,int n){

    }
}
