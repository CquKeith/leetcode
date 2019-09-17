package Company2019InNowcoder.Huawei2016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Keith
 * @date 8/21/2019 16:38
 **/
public class StringSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Set<Character> set = new HashSet<>();
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (Character item:
                 s.toCharArray()) {
                if (set.add(item)){
                    stringBuilder.append(item);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
