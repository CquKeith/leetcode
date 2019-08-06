import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Keith
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {6,0};
        int target = 6;
        System.out.println(Arrays.toString(twoSumHashMapSolution(nums, target)));

    }

    /**
     * 方法一 暴力解法
     * 双层循环
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 方法二、两遍Hashmap的方法
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumHashMapSolution(int[] nums,int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //下面判断 complement是否在nums中
            // 注意，这个complement不能是nums[i]本身，这样的话就不是两个数的和了
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i){
                return new int[]{i,hashMap.get(complement)};
            }
        }
        //如果执行到这里还没返回，就抛出异常
        throw new IllegalArgumentException("No two sum solution");
    }
}
