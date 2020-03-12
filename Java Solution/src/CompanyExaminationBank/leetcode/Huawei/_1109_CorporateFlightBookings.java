package CompanyExaminationBank.leetcode.Huawei;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2020/3/12 18:42
 * 1109. 航班预订统计
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 *  
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *  
 *
 * 提示：
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 **/
public class _1109_CorporateFlightBookings {
    public static void main(String[] args) {
        _1109_CorporateFlightBookings corporateFlightBookings = new _1109_CorporateFlightBookings();

        int[][] bookings = {
                {1,2,10},
                {2,3,20},
                {2,5,25},
        };

        System.out.println(Arrays.toString(corporateFlightBookings.corpFlightBookings(bookings, 5)));
    }

    /**
     *
     * @param bookings
     * @param n 一共几个航班
     * @return 每个航班的y预定数
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] bookingNum = new int[n];
        for (int[] booking : bookings) {
            for (int j = booking[0]; j <= booking[1]; j++) {
                bookingNum[j-1] += booking[2];
            }
        }

        return bookingNum;
    }
}
