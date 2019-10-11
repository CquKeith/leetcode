package CodingInterviews;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/27 20:43
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 **/
public class InversePairsNum {
    private int ans = 0;

    public static void main(String[] args) {

        int[] array = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        //int[] array = {1, 2, 3, 4, 5, 6, 7, 0};

        //System.out.println(new InversePairsNum().inversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
        System.out.println(new InversePairsNum().inversePairs(array));

        System.out.println(Arrays.toString(array));
    }

    /**
     * 50%
     * O(n2)
     *
     * @param array
     * @return
     */
    public int inversePairsForce(int[] array) {

        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 通过归并排序 来确定逆序对
     *
     * @param array
     * @return
     */
    public int inversePairs(int[] array) {

        mergeSort(array, 0, array.length - 1);
        return ans;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) >> 1;

            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);

        }

    }

    private void merge(int[] array, int low, int mid, int high) {

        int[] helper = new int[high - low + 1];
        System.arraycopy(array,low,helper,0,high - low + 1);

        //int[] helper = Arrays.copyOf(array,array.length);

        int helperMid = mid - low;
        int i = 0;
        int j = helperMid + 1;
        int k = low;
        while (i <= helperMid && j < helper.length){
            if (helper[i] > helper[j]){
                array[k++] = helper[j++];
                ans += helperMid - i + 1;
                ans %= 1000000007;
            }else {
                array[k++] = helper[i++];
            }
        }

        while (i <= helperMid)array[k++] = helper[i++];
        while (j < helper.length) array[k++] = helper[j++];



    }

}
