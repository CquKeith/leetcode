package Huawei2019Autumn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Keith
 * @date 8/21/2019 18:44
 **/
public class Three {
    public static void main(String[] args) {
        new Three().solution();
    }


    private void solution() {
        Scanner scanner = new Scanner(System.in);
        Set<String> setReceivedUsers = new HashSet<>();
        Set<String> setHasSentUsers = new HashSet<>();
        String broadcaster = scanner.next();
        //发送到了几个群
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            String str = scanner.next();
            if (str.isEmpty()) {
                continue;
            }
            String[] list = str.split(",");
            setReceivedUsers.addAll(Arrays.asList(list));
        }


        System.out.println(setReceivedUsers.size());
        System.out.println(setReceivedUsers);
        scanner.close();

    }
}
