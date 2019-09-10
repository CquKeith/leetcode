package Topic.ArrayTopic;

/**
 * @author chenmengliang
 * @date 2019/9/10 10:06
 * [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
 **/
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 1, 2},
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        };
        for (int[] num :
                nums) {
            System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(num));
        }
    }

    /**
     * 数组是排序过的，删除重复的元素
     * 算法：
     *      双指针：快指针和慢指针
     *          慢指针指向当前不重复子序列的最后一个元素
     *          快指针作为工作指针遍历数组
     *      fast指向的元素 如果等于 slow指向的元素 就一直往前走
     *          直到遇到与slow不一样的值，将fast作为slow的下一个值
     * @param nums
     * @return 删除了重复元素的新数组的长度
     */
    public int removeDuplicates(int[] nums) {

        if (null == nums || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]){
                //将fast作为slow之后的值
                nums[++slow] = nums[fast];
            }
        }


        return slow+1;
    }
}
