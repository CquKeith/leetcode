package Topic.ArrayTopic;

/**
 * @author chenmengliang
 * @date 2019/9/10 16:36
 * [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
 **/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[][] tests = {{1,3},{8,9,2,3,4},{4,5,6,7,0,1,2,3}};


        for (int[] test :
                tests) {
            System.out.println(new SearchInRotatedSortedArray().search(test,2));
        }
    }

    /**
     * 官方方法：
     *  1. 通过二分查找找寻旋转节点(最小值的那个节点)
     *  2. 分别对于两边进行二分查找
     *
     *  1ms 击败53.94%
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums,int target){

        //assert
        if (nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int rotateIndex = findRotateIndex(nums);

        //如果taget就是最小值
        if (target == nums[rotateIndex]){
            return rotateIndex;
        }
        //未旋转 必须要考虑 否则下面的判断 就不能正确判断出target在左边还是右边了
        //如 1，3 为旋转，rotateIndex == 0，target == 3 > 1,按理说在左半部分 但是其实是在最右边
        if (rotateIndex == 0){
            return binarySearch(nums,0,nums.length-1,target);
        }



        //target在右半支
        if (target < nums[0]){
            return binarySearch(nums,rotateIndex,nums.length-1,target);

        }else {
            return binarySearch(nums,0,rotateIndex,target);
        }

    }

    /**
     * 1. 寻找旋转的下标，也就是最小的元素
     * @pa二分法ram nums
     * @return
     */
    private int findRotateIndex(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right) >> 1;
            //mid刚好在最大值，mid的下个就是最小值  全序列只有最大值和最小值之间 是下降的 其他都是上升的
            if (mid + 1 < nums.length && nums[mid] > nums[mid+1]){
                return mid+1;
            }else {
                //mid在左边
                if (nums[mid] >= nums[0]){
                    left = mid+1;
                }
                //mid在右边
                else {
                    right = mid - 1;
                }
            }
        }
        return 0;
    }









    //////////////////////////////////////////////////////////////////////////////




    /**
     * 每次将中间值mid取出，如果mid < 右边的数  那么右半部分有序，二分查找 否则继续取出右半部分的mid 重复
     *                   如果mid > 左边的数，那么左半部分有序，二分查找 否则继续取出左半部分的mid 重复
     *
     *     !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *     此方法暂未奏效
     *     因为怎么确认左半部分或者右半部分是不是有序的判定条件还没找到
     *      比如mid在左半部分 那么mid左边比右边小；同样mid在右半部分，依然是mid左边比右边小
     *      通过二分查找找分岔点（最小值处）或许是一种方法
     *
     *     以上问题找到了解决办法：
     *          nums[mid] > nums[0] 说明mid一定在左半部分 因为右半部分的所有值 都是<= nums[0]的
     *      1ms 击败99.83%
     *     !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * @param nums
     * @param target
     * @return
     */
    public int searchMyMethod(int[] nums, int target) {

        return search(nums,0,nums.length-1,target);


    }

    /**
     * 从nums 的 [begin,end]搜索target
     * @param nums
     * @param begin
     * @param end
     * @param target
     * @return
     */
    private int search(int[] nums,int begin,int end,int target) {

        if (end < begin)return -1;

        if (end == begin){
            return nums[begin] == target ? begin:-1;
        }

        int mid = (end + begin) / 2;
        //！！！！！如果当前值已经找到 就直接返回
        if (target == nums[mid])return mid;

        //mid及左边的部分有序，使用二分查找
        //这里不能先判断右半部分 例如 1 2 3 4 0 1 中间是3<4 但是右半部分并不有序 这是由于取mid是靠左取造成的
        if (mid > 0 && nums[mid] > nums[0]) {
            //二分查找左边的部分
            int index = binarySearch(nums, begin, mid-1, target);
            if (index != -1) {
                return index;
            }
            //答案在右边
            return search(nums,mid+1,end,target);

        }else {
            //左边无序，右边肯定有序  二分查找右边的
            int index = binarySearch(nums, mid+1, end, target);
            if (index != -1) {
                return index;
            }
            //答案在左边
            return search(nums,begin,mid-1,target);
        }

    }
    private int binarySearch(int[] arr,int low,int high,int target){
        int ans = -1;
        while (low <= high){
            int mid = (high+low)/2;
            if (arr[mid] == target){
                return mid;
            }

            if (arr[mid] > target){
                high = mid-1;
            }else if (arr[mid] < target){
                low = mid+1;
            }
        }
        return ans;
    }
}
