package Topic.ArrayTopic;

import java.util.*;

/**
 * @author chenmengliang
 * @date 2020/3/22 14:49
 * 93. 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 **/
public class _93_RestoreIpAddress {
    public static void main(String[] args) {
        _93_RestoreIpAddress restoreIpAddress = new _93_RestoreIpAddress();
        System.out.println(restoreIpAddress.restoreIpAddresses("25525511135"));
    }

    /**
     * 挨个加4个.进去
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();

        if (len < 4 || len > 12) {
            return list;
        }
        // 存放树每层的结果
        Deque<String> path = new ArrayDeque<>();

        int splitTimes = 0;
        int begin = 0;
        dfs(s, len, splitTimes, begin, path, list);


        return list;
    }

    /**
     *
     * @param s 原始字符串
     * @param len 原始字符串长度
     * @param splitTimes 当前已经拆分了几次了
     * @param begin 本次dfs起始index（在s中）
     * @param path 保存每层dfs的结果
     * @param list 结果的list
     */
    private void dfs(String s, int len, int splitTimes, int begin, Deque<String> path, List<String> list) {
        if (begin == len) {
            if (splitTimes == 4) {
                list.addAll(Collections.singleton(String.join(".", path)));
            }
            return;
        }
        // 剪枝
        // 剩下的长度len-begin
        // 剩下4-splitTimes段
        // 每段按照最小长度1和最大长度3来判定 剩下的长度是否合适
        if (len - begin < (4-splitTimes) || (len - begin) > 3 * (4 - splitTimes)) {
            return;
        }

        // 从begin开始，在begin之后添加小数点
        for (int i = 0; i < 3; i++) {

            // 接下来要取子串，s[begin,begin+i] 方式右边界出界
            if (begin + i >= len) {
                break;
            }
            // 当前这段，转成数值类型，并判断是否是合法的ip段
            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {

                path.addLast(String.valueOf(ipSegment));

                dfs(s, len, splitTimes + 1, begin + i + 1, path, list);

                // 回溯
                path.removeLast();
            }

        }


    }

    /**
     * 取子串[left,right]
     * 并判断是否是合法的ip段：
     *  不能超过255、长度如果大于1的话不能以0开头，etc.
     * @param s
     * @param left
     * @param right
     * @return 合法的ip段，就返回ip段对应的数值，否则返回-1
     */
    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        int value = 0;
        for (int i = left; i <= right; i++) {
            value = value * 10 + s.charAt(i) - '0';
        }
        if (value > 255) {
            return -1;
        }

        return value;
    }

}
