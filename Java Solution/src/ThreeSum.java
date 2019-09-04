import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/9/3 22:34
 * 15. 三数之和 https://leetcode-cn.com/problems/3sum/
 **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        int[] array1 = {0, 0, 0, 0};
        int[] array2 = {-2, 0, 0, 2, 2};
        int[] array3 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        ThreeSum threeSum = new ThreeSum();
        long start = System.currentTimeMillis();
        System.out.println(threeSum.threeSum(array3));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));

    }

    /**
     * 算法一：
     * 1. 先排序
     * 2. 依次遍历，left=i+1,right = array.lenth-1
     * 2.1 如果三个位置的数相加<0,则left右移，如果>0,则right左移
     * 2.2 知道left==right
     *
     * @param array
     * @return
     */
    private List<List<Integer>> threeSum(int[] array) {
        List<List<Integer>> ans = new ArrayList<>();

        //assert
        if (null == array || array.length < 3) {
            return ans;
        }

        //排序
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            int left = i + 1;
            int right = array.length - 1;

            //当前值大于0，那么再加上 肯定会更大于0
            if (item > 0) {
                break;
            }

            //跳过值相同的 基准
            if (i > 0 && item == array[i - 1]) {
                continue;
            }


            while (left < right) {

                int sum = item + array[left] + array[right];
                if (sum < 0) {
                    ++left;
                } else if (sum > 0) {
                    --right;
                } else {
                    ans.add(Arrays.asList(item, array[left], array[right]));
                    //跳过连续值相同的
                    do {
                        ++left;
                    } while (left < right && array[left] == array[left - 1]);
                    do {
                        --right;
                    } while (left < right && array[right + 1] == array[right]);
                }


            }
        }

        return ans;
    }
}
