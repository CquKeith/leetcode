package CompanyInterviews2020.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author chenmengliang
 **/
public class One {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    /**
     * f(1) = 1;
     * f(2) =
     * @param input
     * @return
     */
    private static int solution(int[] input) {

        // TODO Write your code here
        if (input.length == 0){
            return -1;
        }
        if (input.length == 1){
            return 0;
        }
        //找出当前可跳范围内的最大数
        int ans = 0;
        int index = 0;
        int curMaxIndex;
        while (index < input.length){
            int item = input[index];
            int i = 1;
            curMaxIndex = 0;
            while (i <= item && index + i < input.length){
                if(input[index + i] > input[curMaxIndex]){
                    curMaxIndex = index + i;
                }
                i++;
            }
            index = curMaxIndex;
            //System.out.println(index);
            ans ++;
        }
        if (index > input.length){
            ans++;
        }

        return ans;
    }
}
