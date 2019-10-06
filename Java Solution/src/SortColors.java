import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/26 09:29
 * https://leetcode-cn.com/problems/sort-colors/
 * 75 颜色分类
 * 只有0 1 2 三种数的数组，不借助排序库函数，最快的拍好序
 **/
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 算法一
     * 计数排序
     * 扫描两次：
     * 一次统计每个从min～max出现的次数
     * 一次输出
     *
     * @param nums
     */
    public void sortColorsCountSort(int[] nums) {
        //下标0 1 2 记录0 1 2 出现的次数
        int[] range = new int[3];
        for (int item :
                nums) {
            range[item]++;
        }
        int index = 0;
        for (int i = 0; i < range.length; i++) {
            int count = range[i];
            int temp = 0;
            while (temp++ < count) {
                nums[index++] = i;
            }
        }
    }

    /**
     * 只扫描一遍
     * p0监控元素0的右边界
     * p2监控元素2的左边界
     * cur用来扫描
     * nums[cur] == 0, swap(nums[cur],nums[p0])
     * nums[cur] == 2, swap(nums[cur],nums[p2])
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int cur = 0, p0 = 0, p2 = nums.length - 1;

        int temp;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                temp = nums[cur];
                nums[cur] = nums[p0];
                nums[p0] = temp;
                cur++;
                p0++;

            } else if (nums[cur] == 2) {
                temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = temp;
                p2--;
            }else {
                cur++;
            }
        }
    }
}
