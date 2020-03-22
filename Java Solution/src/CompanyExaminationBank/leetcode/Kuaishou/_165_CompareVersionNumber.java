package CompanyExaminationBank.leetcode.Kuaishou;

/**
 * @author chenmengliang
 * @date 2020/3/22 17:34
 * 165. 比较版本号
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *  
 *
 * 示例 1:
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 *
 * 示例 2:
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 *
 * 示例 3:
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 *
 *  示例 4：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 *
 * 示例 5：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 *  
 * 提示：
 *
 * 版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
 * 版本字符串不以点开始或结束，并且其中不会有两个连续的点。
 *
 **/
public class _165_CompareVersionNumber {
    public static void main(String[] args) {
        _165_CompareVersionNumber compareVersionNumber = new _165_CompareVersionNumber();
        System.out.println(compareVersionNumber.compareVersion("0.1","1.1"));
        System.out.println(compareVersionNumber.compareVersion("1.0.1","1"));
        System.out.println(compareVersionNumber.compareVersion("7.5.2.4","7.5.3"));
        System.out.println(compareVersionNumber.compareVersion("1.01","1.001"));
        System.out.println(compareVersionNumber.compareVersion("1.0","1.0.0"));
    }

    /**
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] version1List = version1.split("\\.", -1);
        String[] version2List = version2.split("\\.", -1);
        int i = 0, j = 0;
        // 先比较公共长度的version
        while (i < version1List.length && j < version2List.length) {

            int version1Seg = Integer.parseInt(version1List[i]);
            int version2Seg = Integer.parseInt(version2List[j]);

            if (version1Seg > version2Seg) {
                return 1;
            } else if (version1Seg < version2Seg) {
                return -1;
            }

            i++;
            j++;
        }
        // 两个都比较完还没分出大小，就是相等
        if (i == version1List.length && j == version2List.length) {
            return 0;
        }
        // 其中一个已经结束，另外一个还没结束
        // 已经结束的，剩下的version一定为0，还没结束的，只要遇到非零的，就说明较大
        while (i < version1List.length) {
            // 1的比较大
            if (Integer.parseInt(version1List[i]) > 0) {
                return 1;
            }
            i++;
        }
        while (j < version2List.length) {
            if (Integer.parseInt(version2List[j]) > 0) {
                return -1;
            }
            j++;
        }
        // 还没结束的一个version后面全是0，那么两个version就相等
        return 0;

    }
}
