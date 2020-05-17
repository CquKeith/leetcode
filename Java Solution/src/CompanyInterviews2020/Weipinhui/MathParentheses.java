package CompanyInterviews2020.Weipinhui;

import java.util.*;

/**
 * @date 2020/4/3 19:16
 * 100% 通过
 **/
public class MathParentheses {
    public static Map<Character,Character> map = new HashMap<>();
    public static void main(String[] args) {

        map.put(']','[');
        map.put(')','(');
        map.put('}','{');

        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
        scanner.close();
    }

    public static boolean solution(String string) {

        if (null == string || string.length() == 0) {
            return false;
        }

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            char item = string.charAt(i);

            if (item == '[' || item == '(' || item == '{') {
                list.add(item);
            } else if (map.containsKey(item)){
                if (list.isEmpty()) {
                    return false;
                }
                if (!list.remove(map.get(item))) {
                    return false;
                }

            }
        }

        return list.isEmpty();

    }
}
