package CompanyInterviews2020.Maoyan;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/10/29 15:48
 * 给定一个整数数组a，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 **/
public class MaoyanInterview1Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,9,0,0};
        solution(arr);

        //System.out.println(Arrays.toString(solution(arr)));
        //System.out.println(Arrays.toString(arr));

    }

    /**
     *
     * @param arr
     */
    private static void solution(int[] arr){

        int notZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                arr[notZeroIndex] = arr[i];
                notZeroIndex++;
            }
        }
        for (int i = notZeroIndex; i < arr.length; i++) {
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));

    }
    private static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }
}
