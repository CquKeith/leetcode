import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        //int [] array = {34,65,12,43,67,5,78,10,3,3,3,70};
        int [] array = {1,5,-2,-4,0};
        new QuickSort().quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 分治的思想，每次都先确定一个数
     * 这个数将数组分成两部分：左边都比他小，右边都比他大
     * 然后再分别对左右两部分进行快速排序
     * @param A
     * @param low
     * @param high
     */
    private void quickSort(int[] A,int low,int high){

        if (low < high){
            int pivotpos = partition(A,low,high);
            quickSort(A,low,pivotpos-1);
            quickSort(A,pivotpos+1,high);
        }


    }

    /**
     * 1. 选中第一个数为基准
     * 2. 从右边开始，选取比基准小的值与low的地方交换，
     * 3. 从左边开始，选取比基准大的值与high的地方交换
     *
     * 注意，每次
     * @param A
     * @param low
     * @param high
     * @return
     */
    private  int partition(int A[],int low,int high){
        //选基准
        int pivot = A[low];
        while (low < high){
            //先从右边开始
            //!!!!!!!!!!!!!!注意此处 每次都应该判断一下 low和high的位置
            while (low < high && A[high] >= pivot) {
                --high;
            }
            A[low] = A[high];
            //!!!!!!!!!!!!!!注意此处 每次都应该判断一下 low和high的位置
            while (low < high && A[low] <= pivot){
                ++low;
            }
            A[high] = A[low];
        }

        A[low] = pivot;

        return low;
    }



}
