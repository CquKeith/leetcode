package CompanyInterviews2020.Kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenmengliang
 * 100%
 **/
public class One {
    public static void main(String[] args) {
        One one = new One();
        Scanner scanner = new Scanner(System.in);
        //[0,1,2,1,0,1]
        System.out.println(Arrays.toString(one.DistanceToHigher(new int[]{175, 173, 174, 163, 182, 177})));

        //[0,0,1,1,3,4]
        System.out.println(Arrays.toString(one.DistanceToHigher(new int[]{175, 179, 174, 163, 176, 177})));

    }
    /**
     * 获取队中从前到后每个人与前方身高高于自己的人的最短距离
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组
     */
    public int[] DistanceToHigher (int[] height) {
        // write code here
        if (height.length == 0) {
            return new int[0];
        }
        if (height.length == 1) {
            return new int[]{0};
        }
        int[] ans = new int[height.length];
        ans[0] = 0;
        for (int i = 1; i < height.length; i++) {
            int currentDistanceIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > height[i]) {
                    currentDistanceIndex = j;
                    break;
                }
            }
            ans[i] = i - currentDistanceIndex;
        }
        return ans;

    }
}
