import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/4 10:21
 * [16. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)
 **/
public class ThreeSumClosest {
    public static void main(String[] args) {

        int[] array = {-1, 2, 1, -4};
        int[] array1 = {1,1,1,0};
        int[] array2 = {-3,-2,-5,3,-4};
        int target = -1;
        System.out.println(new ThreeSumClosest().findThreeSumClosest(array2, target));
    }

    /**
     * 思路：类似ThreeSum 先排序 再双指针
     *
     * @param array
     * @param target
     * @return
     */
    private int findThreeSumClosest(int[] array, int target) {

        //不能初始化为最大或最小整数
        //Math.abs(Integer.MAX_VALUE+1) = -2147483648; 会溢出 产生异常现象
        //int closestSum = Integer.MAX_VALUE;
        int closestSum = array[0] + array[1] + array[2];
        //排序
        Arrays.sort(array);
        int i=0,left=0,right=0;
        for (; i < array.length - 2; i++) {
            left = i + 1;
            right = array.length - 1;
            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                if (sum > target) {
                    --right;
                } else if (sum < target) {
                    ++left;
                } else {
                    return sum;
                }
            }
        }


        return closestSum;
    }

}
