package HuaweiProgram;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/21/2019 11:17
 **/
public class Hex2Dec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine().substring(2);
            System.out.println(Integer.parseInt(s,16));
        }
    }
}
