package Company2019InNowcoder.Guazi2019AutumnSummary;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-16 20:47
 *
 **/
public class WordReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        System.out.println(wordReverse(test));
    }

    /**
     *
     * @return
     */
    private static String wordReverse(String string){
        String[] list = string.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = list.length-1; i >= 0; i--) {
            ans.append(list[i]).append(" ");
        }
        return ans.toString();
    }
}
