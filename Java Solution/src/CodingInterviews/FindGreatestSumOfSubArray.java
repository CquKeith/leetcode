package CodingInterviews;

/**
 * @author chenmengliang
 * @date 2019/9/18 11:07
 * 最大连续子序列的和
 **/
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        System.out.println(new FindGreatestSumOfSubArray().findGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
    }

    public int findGreatestSumOfSubArray(int[] array) {
        int ans = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            ans = Math.max(ans,sum);
            if (sum < 0){
                sum = 0;
            }
        }


        return ans;
    }
}
