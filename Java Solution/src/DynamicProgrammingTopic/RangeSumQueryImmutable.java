package DynamicProgrammingTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2019/9/5 19:26
 * [303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable/)
 **/
public class RangeSumQueryImmutable {

    //前index个数的和是value
    private int[] cache;

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable(nums);

        int[][] tests = {
                            {0,2},{2,5},{0,5}
                        };

        for (int[] test :
                tests) {
            System.out.println(obj.sumRangeRecursive(test[0],test[1]));
        }


    }

    /**
     * 初始化memo 计算所有前k项的和
     * @param nums
     */

    public RangeSumQueryImmutable(int[] nums) {
        if (null == nums || 0 == nums.length){
            return;
        }
        cache = new int[nums.length];
        cache[0] = nums[0];
        /* memo方法用到的*/
        for (int i = 1; i < nums.length; i++) {
            cache[i] = cache[i-1]+nums[i];
        }

        //System.out.println(cache.values());

    }

    /**
     * [i,j]的和
     * @param i
     * @param j
     * @return
     */
    public int sumRangeRecursive(int i, int j) {

        return i == 0? cache[j] : cache[j] - cache[i-1];
    }


}
