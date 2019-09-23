package CompanyInterviews2020.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenmengliang
 * 约瑟夫环问题
 * 输入n m1
 * n个人 编号1～n 循环遍历 当前排队是m的倍数就输出
 * 例如 6 3
 * 输出 3 6 4 2 5 1
 **/
public class Two {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
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

    private static String solution(int[] input) {
        // TODO Write your code here
        StringBuilder stringBuilder = new StringBuilder();
        int n = input[0];
        int M = input[1];

        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int curIndex = 0;
        while (!list.isEmpty()){
            if (++curIndex == list.size()){
                curIndex = 1;
            }
            if (curIndex % M == 0){
                stringBuilder.append(list.get(curIndex%list.size())).append(" ");
                System.out.print(list.get(curIndex%list.size()));
                list.remove(curIndex);
            }
        }



        return stringBuilder.toString();
    }
}
