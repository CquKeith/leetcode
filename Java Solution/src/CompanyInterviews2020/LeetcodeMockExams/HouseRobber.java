package CompanyInterviews2020.LeetcodeMockExams;

/**
 * @author chenmengliang
 * @date 2019/9/4 16:30
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 **/
public class HouseRobber {
    public static void main(String[] args) {
        //int[] houses = {2,3,2};
        //int[] houses = {1,2,3,1};
        //int[] houses = {1};
        int[] houses = {1,3,1,3,100};
        System.out.println(new HouseRobber().robDPSolution(houses));
    }

    /**
     *  动态规划解法：
     *      f(k)代表前k个房间 最多抢多少钱
     *      Ai  代表第i个房间有多少钱
     *      k=1 , f(k) = A1
     *      k=2 , f(k) = Math.max(A1,A2)
     *      k=3 , 要么抢第三个房间 加上f(k-2),要么不抢，保持当前的最大值f(k-1)
     *          f(k) = Math.max(f(k-2)+Ak , f(k-1))
     * @param nums 每个房屋的钱 第一个和最后一个相邻 不能偷两个连续相邻的屋子
     * @return 最多偷多少
     *
     */
    private int robDPSolution(int[] nums) {
        //assert
        if (null == nums || nums.length == 0){
            return 0;
        }
        int length = nums.length;

        int[] f = new int[length+1];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i <= length; i++) {
            f[i] = Math.max(f[i-2]+nums[i-1],f[i-1]);
        }

        return f[length];

    }
}
