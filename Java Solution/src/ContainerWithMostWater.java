/**
 * @author Keith
 * @date 2019-09-02 14:11
 * [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
 **/
public class ContainerWithMostWater {
    public static void main(String[] args) {

        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(heights));

    }


    /**
     * 从两头开始往中间走
     * 每次操作，谁的值最小，谁往中间走
     * @param height
     * @return
     */
    private int maxArea(int[] height) {
        int maxSqure = 0;
        int left=0,right = height.length-1;
        while (left < right){
            //更新最大的面积
            maxSqure = Math.max(maxSqure,(right-left)*Math.min(height[left],height[right]));

            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }

        }
        return maxSqure;

    }

}
