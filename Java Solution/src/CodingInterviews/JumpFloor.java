package CodingInterviews;

/**
 * @author chenmengliang
 * @date 2019/9/18 10:46
 **/
public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(new JumpFloor().jumpFloorRecursive(10));
    }

    /**
     * f(0) = 0
     * f(1) = 1
     * f(2) = 2
     * f(n) = f(n-1) + f(n-2)
     * @param target
     * @return
     */
    public int jumpFloorRecursive(int target) {
        if (target <= 2){
            return target;
        }
        else return jumpFloorRecursive(target-1)+jumpFloorRecursive(target-2);
    }
    public int jumpFloorDP(int target){
        if (target <= 2){
            return target;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
