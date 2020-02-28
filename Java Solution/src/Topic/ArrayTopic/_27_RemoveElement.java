package Topic.ArrayTopic;

/**
 * @author chenmengliang
 * @date 2020/2/28 21:12
 * https://leetcode-cn.com/problems/remove-element/
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 **/
public class _27_RemoveElement {

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;

        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;

        int[] nums3 = {1};
        int val3 = 1;

        System.out.println(removeElement(nums3,val3));

    }

    /**
     * 除去nums中所有的 val
     * 思路：
     *      双指针
     *      前面扫出相同的值，如果不等于val left就往右走，如果相同，就把left的值赋给right 然后再次比较
     *      知道left 越过 right
     * @param nums
     * @param val
     * @return 除去之后数组的长度
     */
    public static int removeElement(int[] nums, int val) {

        if (nums.length <= 0){
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            if (nums[left] == val){
                nums[left] = nums[right];
                right --;
            }else {
                left++;
            }
        }

        return left;
    }

}



