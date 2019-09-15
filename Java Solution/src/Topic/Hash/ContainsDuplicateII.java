package Topic.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenmengliang
 * @date 2019/9/15 13:51
 * [219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii/)
 **/
public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1,2,1},0));
    }

    /**
     * 算法 维持一个长度是k的set 循环清零，在set中搜索 是否具有相等的元素
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))return true;

            //add必须要放在remove之前，否则如果k==0，remove成0之后，add了 又超过k了
            set.add(nums[i]);

            if (set.size() >= k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
