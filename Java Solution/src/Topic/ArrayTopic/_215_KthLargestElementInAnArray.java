package Topic.ArrayTopic;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2020/3/17 11:57
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 **/
public class _215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        _215_KthLargestElementInAnArray kthLargestElementInAnArray = new _215_KthLargestElementInAnArray();
        //System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        //System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{1}, 1));
    }

    /**
     * 利用快速排序
     * 每次确定一个元素的最终位置，如果当前位置是倒数第k个，则说明已经找到
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int targetIndex = nums.length - k;
        return quickSort(nums, 0, nums.length-1, targetIndex);
    }

    private int quickSort(int[] nums, int low, int high, int targetIndex) {
        // 这里是小于等于，而不是小于，避免nums=={1}，targetIndex = 0的情况
        if (low <= high) {
            int pivotPos = partition(nums, low, high);
            if (pivotPos == targetIndex) {
                System.out.println(Arrays.toString(nums));
                return nums[pivotPos];
            }
            if (pivotPos > targetIndex) {
                return quickSort(nums, low, pivotPos - 1, targetIndex);
            } else {
                return quickSort(nums, pivotPos + 1, high, targetIndex);
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];

        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                --high;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] <= pivot) {
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

}
