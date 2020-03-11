package LeetcodeEveryday;

/**
 * @author chenmengliang
 * @date 2020/3/11 19:36
 * 1013. 将数组分成和相等的三个部分
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *  
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 *
 **/
public class _1013_PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        _1013_PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum = new _1013_PartitionArrayIntoThreePartsWithEqualSum();
        System.out.println(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
        System.out.println(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(new int[]{18,12,-18,18,-19,-1,10,10}));
        System.out.println(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(new int[]{1,-1,1,-1}));
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int item : A) {
            sum += item;
        }
        if (sum % 3 != 0) {
            return false;
        }
        // 每一部分的和都要是target
        int target = sum / 3;
        // 找第一部分
        int len = A.length;
        int currentSum = 0;

        int index = 0;
        while (index < len-2) {
            currentSum += A[index];
            if (currentSum == target) {
                break;
            }
            index++;
        }
        if (index >= len-2) {
            return false;
        }

        index++;
        currentSum = 0;
        while (index < len - 1) {
            currentSum += A[index];
            if (currentSum == target) {
                return true;
            }
            index++;
        }

        return false;
    }
}
