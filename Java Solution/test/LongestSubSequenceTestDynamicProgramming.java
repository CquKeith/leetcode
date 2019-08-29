import java.util.Stack;

/**
 * @author Keith
 * @date 2019-08-29 19:04
 **/
public class LongestSubSequenceTestDynamicProgramming {
    public static void main(String[] args) {

        int[] sequence = {5, 2, 4, 7, 6, 3, 8, 9};

        new LongestSubSequenceTestDynamicProgramming().dpSolutionByShaBook(sequence);
    }

    /**
     * 沙老师 计算机导论中提到的动态规划解法
     *
     * @param sequence
     */
    private void dpSolutionByShaBook(int[] sequence) {
        //用来记录 以当前元素为最后一个元素，组成最长序列 的上一个元素的索引
        //便于回溯 打印出序列
        int[] traval = new int[sequence.length];

        //存储以当前元素为结尾的序列 最大的长度
        int[] maxLengthArray = new int[sequence.length];

        //记录maxLengthArray中的最大数
        int maxLengthIndex = 0;

        for (int i = 0; i < sequence.length; i++) {
            int item = sequence[i];

            //记录 以item结尾的满足条件的子序列中，item的上一个元素的索引
            traval[i] = -1;

            //以当前元素item结尾 最长的子序列 长度是 元素值小于当前元素的 maxLength的最大值+1
            //记录当前不大于item的元素 以这样的元素为结尾的序列，的最大长度
            int maxIndex = 0;
            int currentMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int temp = sequence[j];
                if (temp >= item) {
                    continue;
                }
                if (maxLengthArray[j] > currentMax) {
                    currentMax = maxLengthArray[j];
                    maxIndex = j;
                    traval[i] = maxIndex;
                }
            }

            maxLengthArray[i] = maxIndex == 0 ? 1 : maxLengthArray[maxIndex] + 1;
            if (maxLengthArray[i] > currentMax){
                maxLengthIndex = i;
            }

        }

        //System.out.println(Arrays.toString(sequence));
        //System.out.println(Arrays.toString(maxLengthArray));
        //System.out.println(Arrays.toString(traval));

        //按顺序打印出最大的序列
        Stack<Integer> stack = new Stack<>();
        while (maxLengthIndex > 0){
            stack.push(sequence[maxLengthIndex]);
            maxLengthIndex = traval[maxLengthIndex];
        }
        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }

    }

}
