package LeetcodeEveryday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2020/3/13 14:31
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 **/
public class _169_MajorityElement {
    public static void main(String[] args) {
        _169_MajorityElement majorityElement = new _169_MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     *
     * @param nums 非空数组
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }

            int fre = map.get(num);
            ans = fre > map.getOrDefault(ans, 0) ? num : ans;

        }
        return ans;
    }
}
