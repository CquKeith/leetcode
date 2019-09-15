package Topic.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenmengliang
 * @date 2019/9/15 11:27
 * [217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)
 **/
public class ContainsDuplicate {
    private Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,5,-2,-4,0}));
    }

    /**
     * 如果任何值在数组中出现至少两次，函数返回 true。
     * 如果数组中每个元素都不相同，则返回 false
     * 时间复杂度O(n) 空间复杂度O(n)
     * 但是每次使用contains add 都会重新搜索，会耗费很多时间
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicateLinearMethod(int[] nums) {
        for (int num :
                nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;

    }

    /**
     * 算法二 先排序 如果存在两个相邻的数相等 则说明存在相同的数
     * 时间复杂度O(nlogn) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        //quickSort(nums, 0, nums.length - 1);
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;

    }

    /**
     * 快速排序
     * 分治的思想，先找出一个最中间的数，放在它最终的位置上，它左边都比他小 右边都比他大
     * 然后分别对左右两边执行这样的操作
     * 但是这样的排序 对于基本有序的 性能将为 冒泡；就会超时。使用Arrays.sort最好
     * @param nums
     * @param low
     * @param high
     */
    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotPos = partition(nums, low, high);
            quickSort(nums, low, pivotPos - 1);
            quickSort(nums, pivotPos + 1, high);
        }
    }

    /**
     * @param nums
     * @param low
     * @param high
     * @return 返回 最中间的元素的index
     * 1. 选取第一个数为基准
     * 2. 从后面开始比较，直到找到比pivot小的 将它放在现有的基准的位置，然后换从左边扫描比pivot大的
     */
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            //从右边扫描比pivot小的
            while (low < high && nums[high] >= pivot) high--;

            nums[low] = nums[high];

            while (low < high && nums[low] <= pivot) low++;

            nums[high] = nums[low];

        }
        nums[low] = pivot;
        return low;
    }
}