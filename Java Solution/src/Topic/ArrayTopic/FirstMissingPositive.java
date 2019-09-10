package Topic.ArrayTopic;

import java.util.*;

/**
 * @author chenmengliang
 * @date 2019/9/10 14:31
 * [41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/)
 **/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[][] tests = {
                         {1,2,0},
                         {3,4,-1,1},
                         {7,8,9,11,12},
                         {2,1}
                        };
        for (int[] test:
             tests) {
            System.out.println(new FirstMissingPositive().firstMissingPositiveMine(test));
        }
    }


    /**
     * Set 的解法
     * 因为<=0的肯定不满足，>nums.length()的肯定也不满足,（除了nums.length+1）
     *  4ms 17.99%
     * @param nums
     * @return
     */
    public int firstMissingPositiveSet(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int item :
                nums) {
            if (item <= 0) continue;

            set.add(item);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        return n+1;


    }

        /**
         * 自己想的算法
         * 3ms 击败28%
         * @param nums
         * @return
         */
    public int firstMissingPositiveMine(int[] nums) {

        Arrays.sort(nums);

        int ans = 1;

        for (int item :
                nums) {
            if (item == ans){
                ans += 1;
            }
        }
        
        
        return ans;
        
    }
}
