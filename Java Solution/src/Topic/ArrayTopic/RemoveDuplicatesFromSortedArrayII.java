package Topic.ArrayTopic;

/**
 * @author chenmengliang
 * @date 2019/9/10 11:06
 * [80. 删除排序数组中的重复项 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/)
 *
 **/
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[][] nums = {
                //{1,1,1,2,2,3},
                //{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                {0,0,1,1,1,1,2,3,3},
        };
        for (int[] num :
                nums) {
            System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(num));
        }
    }

    /**
     * 原地删除，每个元素最多出现两次
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0){
            return 0;
        }

        int slow = 0;
        boolean isHappenTwice = false;
        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[fast] != nums[slow]){
                isHappenTwice = false;
                nums[++slow] = nums[fast];
            }else{
                if (!isHappenTwice){
                    isHappenTwice = true;
                    nums[++slow] = nums[fast];
                }
            }
        }
        return slow+1;
    }
}
