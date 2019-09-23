package SortAlgo;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/22 11:05
 **/
public class BubbleSort {
    public static void main(String[] args) {
        //int [] array = {34,65,12,43,67,5,78,10,3,3,3,70};
        int [] array = {1,5,-2,-4,0};
        new BubbleSort().bubbleSort(array,array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param array
     * @param n 数组长度
     */
    private void bubbleSort(int[] array,int n){
        boolean flag;
        for (int i = 0; i < n-1; i++) {
            flag = false;
            for (int j = n-1; j > i ; j--) {
                if (array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                return;
            }
        }
    }
}
