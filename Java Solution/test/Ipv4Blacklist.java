import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/10/14 11:04
 **/
public class Ipv4Blacklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(isInBlacklist(scanner.nextLine(),scanner.nextLine()));

    }

    /**
     *
     * @param ipStr 需要验证的IPv4地址
     * @param blackListStr IP黑名单地址，可能是IPv4，也可能是CIDR
     * @return
     */
    private static int isInBlacklist(String ipStr,String blackListStr) {

        if (ipStr.equals(blackListStr))return 1;


        // 将需要验证的IP转成10进制
        String[] ipStrArray = ipStr.split("\\.");
        long ipLong = Long.parseLong(ipStrArray[0]) << 24 |
                              Long.parseLong(ipStrArray[1]) << 16 |
                              Long.parseLong(ipStrArray[2]) << 8 |
                              Long.parseLong(ipStrArray[3]);

        //取出黑名单的子网掩码
        int netCount = Integer.parseInt(blackListStr.contains("/")?blackListStr.split("/")[1]:"0");

        //如果黑名单不是CIDR格式的 TODO


        // 将黑名单地址转成10进制
        String[] blStrArray = blackListStr.split("/")[0].split("\\.");
        long blLong = Long.parseLong(blStrArray[0]) << 24 |
                              Long.parseLong(blStrArray[1]) << 16 |
                              Long.parseLong(blStrArray[2]) << 8 |
                              Long.parseLong(blStrArray[3]);

        if (netCount == 0){
            while (blLong % 10 == 0){
                blLong >>= 1;
                netCount++;
            }
        }
        int mask = 0xFFFFFFFF << (32 - netCount);



        return (mask & blLong) == (mask & ipLong) ? 1 : 0;
    }
}
