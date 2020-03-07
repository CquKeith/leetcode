package Topic.BinarySearchTopic;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2020/3/7 13:46
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 **/
public class _34_FindFirstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        _34_FindFirstAndLastPositionInSortedArray findFirstAndLastPositionInSortedArray = new _34_FindFirstAndLastPositionInSortedArray();

        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{1, 2, 2}, 2)));
        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{1, 1, 2}, 1)));
        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3)));
        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{3, 3, 3, 3}, 3)));
        System.out.println(Arrays.toString(findFirstAndLastPositionInSortedArray.searchRange(new int[]{3}, 3)));
    }

    /**
     * 分两次查找，一次用来确定左边界，一次用来确定右边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = findFirstIndex(nums, target);
        if (ans[0] != -1) {
            ans[1] = findSecondIndex(nums, target, ans[0]);
        }

        return ans;
    }

    /**
     * * 二分查找，找到target在nums中第一次出现的index
     * 没有出现过则返回-1
     * 搜索范围[firstIndex,nums.length)
     *
     * @param nums
     * @param target
     * @param firstIndex 第一次出现的index
     * @return
     */
    public int findSecondIndex(int[] nums, int target, int firstIndex) {
        int secondIndex = firstIndex;
        int left = firstIndex, right = nums.length;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            // nums[mid] 一定>= target
            // 因为nums是有序的，而从nums[firstIndex]==target
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                secondIndex = mid;
                left = mid + 1;
            }
        }

        return secondIndex;
    }

    /**
     * 二分查找，找到target在nums中第一次出现的index
     * 没有出现过则返回-1
     * 搜索区间[0,nums.length)
     *
     * @param nums
     * @param target
     * @return
     */
    public int findFirstIndex(int[] nums, int target) {
        int firstIndex = -1;
        int left = 0, right = nums.length;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if ((nums[mid] > target)) {
                right = mid;
            } else {
                firstIndex = mid;
                right = mid;
            }
        }
        return firstIndex;
    }

    /**
     * @param nums
     * @param target
     * @return 数组两个数，第一次和最后一次出现的index
     */
    @Deprecated
    // TODO not work
    public int[] searchRangeOneTimeBinarySearch(int[] nums, int target) {
        int[] ans = new int[2];

        int left = 0, right = nums.length - 1;
        ans[0] = right;
        ans[1] = -1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            // 找到了范围中的一个，接下来要找左边和右边的边界
            if (target == nums[mid]) {
                // 更新范围的值
                ans[0] = Math.min(ans[0], mid);
                ans[1] = Math.max(ans[1], mid);

                // 左边界还不确定（mid左边的值等于target，但是当前的左边界却大于mid-1），left往左走，为了让mid可以往左偏移
                if (mid > 0 && nums[mid - 1] == target && ans[0] > mid - 1) {
                    ans[0] = Math.min(ans[0], mid - 1);
                    if (left > 0) {
                        left--;
                    } else {
                        right--;
                    }
                    continue;
                }
                // 右边界还不确定(mid右边的值等于target，但是当前的右边界却小于mid+1)，right往右走，为了让mid可以往右偏移
                if (mid < nums.length - 1 && nums[mid + 1] == target && ans[1] < mid + 1) {
                    ans[1] = Math.max(ans[1], mid + 1);
                    if (right < nums.length) {
                        right++;
                    } else {
                        left++;
                    }
                    continue;
                }
                // 左右都边界都确定了，就提前退出
                break;

            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 如果没有找到，则全返回-1
        ans[0] = ans[1] == -1 ? -1 : ans[0];


        return ans;
    }
}
