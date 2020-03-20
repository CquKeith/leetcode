package LeetcodeEveryday;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2020/3/20 00:06
 * 面试题40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 **/
public class MinimumSmallKNumber {

    public static void main(String[] args) {
        MinimumSmallKNumber minimumSmallKNumber = new MinimumSmallKNumber();

        int[] test = {0, 0, 0, 2, 3, 3, 5, 2, 0, 0, 1, 8, 0, 8, 11, 14, 7, 2, 8, 14, 11, 3, 16, 9, 21, 17, 22, 27, 16, 3, 30, 0, 28, 4, 19, 34, 10, 10, 4, 18, 26, 27, 37, 21, 32, 33, 38, 36, 3, 11, 35, 4, 33, 30, 42, 12, 7, 13, 9, 32, 37, 6, 15, 38, 13, 17, 65, 58, 34, 14, 64, 50, 15, 58, 42, 13, 23, 44, 36, 31, 20, 16, 42, 7, 68, 22, 38, 56, 61, 32, 89, 85, 26, 37, 42, 18, 77, 37, 1, 98, 9, 21, 14, 79, 62, 24, 19, 37, 103, 108, 18, 96, 85, 107, 11, 52, 87, 99, 108, 75, 99, 62, 85, 97, 87, 31, 84, 54, 5, 35, 112, 58, 101, 3, 111, 59, 63, 67, 11, 24, 131, 128, 23, 116, 134, 125, 120, 103, 141, 52, 116, 81, 67, 10, 99, 90, 70, 67, 23, 30, 115, 111, 14, 20, 65, 66, 79, 1, 131, 79, 99, 108, 143, 128, 27, 3, 147, 133, 17, 92, 24, 16, 140, 11, 127, 120, 178, 130, 31, 39, 67, 191, 99, 74, 38, 195, 38, 8, 161, 8, 2, 79, 181, 170, 157, 96, 112, 114, 48, 159, 139, 98, 205, 87, 126, 111, 4, 55, 3, 201, 205, 1, 160, 197, 151, 27, 72, 61, 177, 105, 48, 62, 160, 221, 102, 210, 30, 64, 182, 99, 148, 87, 235, 166, 82, 30, 103, 190, 129, 191, 170, 222, 19, 224, 66, 148, 195, 35, 100, 231, 205, 224, 66, 85, 48, 57, 86, 67, 3, 217, 196, 175, 203, 123, 245, 275, 160, 110, 243, 108, 81, 40, 89, 136, 130, 109, 175, 202, 230, 280, 223, 79, 117, 237, 191, 56, 252, 267, 71, 39, 74, 30, 15, 209, 220, 229, 128, 84, 1, 228, 115, 165, 171, 268, 133, 200, 20, 89, 125, 7, 111, 96, 190, 316, 245, 292, 56, 56, 292, 221, 153, 191, 305, 136, 86, 69, 264, 146, 93, 339, 308, 283, 302, 176, 309, 223, 225, 76, 53, 17, 166, 245, 195, 341, 29, 28, 265, 123, 151, 19, 301, 191, 101, 332, 322, 147, 47, 73, 86, 122, 3, 242, 139, 268, 225, 345, 211, 169, 306, 376, 210, 130, 68, 341, 332, 75, 185, 45, 317, 301, 331, 62, 105, 178, 2, 10, 372, 15, 395, 184, 49, 233, 253, 93, 342, 228, 14, 180, 170, 171, 302, 264, 150, 31, 403, 249, 77, 112, 53, 317, 238, 265, 234, 57, 120, 49, 21, 110, 407, 372, 58, 14, 154, 72, 327, 53, 407, 364, 424, 96, 42, 77, 400, 265, 89, 370, 350, 12, 71, 252, 79, 50, 451, 334, 124, 43, 406, 244, 337, 432, 305, 397, 390, 349, 59, 340, 214, 464, 190, 435, 160, 380, 339, 372, 11, 409, 440, 10, 160, 395, 390, 327, 345, 245, 385, 429, 260, 124, 0, 326, 470, 171, 183, 335, 279, 271, 120, 77, 469, 66, 350, 357, 216, 256, 214, 345, 275, 169, 445, 423, 92, 65, 333, 296, 7, 241, 434, 350, 305, 176, 484, 70, 335, 64, 310, 447, 340, 355, 131, 51, 392, 150, 383, 516, 48, 446, 389, 56, 404, 5, 211, 434, 131, 133, 341, 203, 242, 130, 75, 496, 319, 115, 276, 540, 52, 32, 136, 340, 12, 46, 392, 399, 554, 449, 452, 461, 412, 502, 251, 281, 342, 408, 511, 81, 465, 397, 191, 408, 420, 550, 513, 270, 319, 83, 184, 233, 294, 351, 414, 329, 317, 443, 482, 542, 372, 330, 109, 309, 32, 594, 160, 176, 460, 27, 194, 574, 572, 147, 605, 155, 591, 176, 417, 402, 18, 484, 10, 145, 496, 334, 379, 141, 455, 121, 95, 516, 186, 592, 262, 219, 16, 512, 578, 214, 627, 71, 8, 126, 433, 601, 245, 382, 300, 52, 447, 226, 606, 565, 109, 461, 606, 403, 209, 508, 9, 26, 561, 183, 140, 293, 143, 78, 557, 66, 262, 486, 42, 534, 243, 236, 317, 572, 346, 519, 183, 593, 50, 543, 324, 647, 538, 89, 482, 484, 283, 213, 363, 180, 659, 175, 232, 58, 529, 27, 101, 658, 142, 423, 277, 580, 101, 701, 14, 669, 639, 67, 615, 470, 38, 419, 635, 439, 514, 24, 267, 688, 495, 405, 81, 247, 149, 251, 237, 574, 66, 285, 677, 710, 107, 524, 9, 315, 265, 252, 663, 541, 615, 291, 388, 528, 53, 89, 342, 359, 553, 252, 470, 486, 565, 120, 284, 712, 505, 272, 540, 80, 398, 399, 714, 517, 68, 702, 301, 29, 463, 639, 129, 328, 261, 64, 217, 493, 658, 184, 396, 49, 274, 393, 479, 730, 589, 330, 654, 566, 396, 672, 762, 112, 585, 40, 247, 530, 405, 577, 178, 673, 626, 379, 461, 409, 175, 328, 605, 333, 630, 127, 679, 86, 665, 193, 537, 100, 540, 89, 588, 18, 358, 144, 782, 594, 512, 265, 483, 313, 764, 384, 354, 327, 31, 16, 754, 482, 691, 181, 533, 11, 718, 751, 726, 802, 837, 121, 325, 652, 193, 135, 244, 680, 551, 205, 370, 624, 16, 250, 471, 684, 767, 34, 43, 21, 65, 202, 699, 745, 212, 843, 158, 635, 309, 340, 336, 770, 857, 269, 22, 291, 422, 534, 205, 855, 774, 469, 187, 879, 399, 283, 563, 469, 285, 525, 828, 282, 323, 690, 736, 515, 102, 47, 833, 103, 879, 369, 718, 83, 263, 531, 76, 622, 847, 767, 806, 734, 712, 37, 532, 295, 33, 327, 3, 417, 734, 365, 381, 404, 713, 318, 921, 793, 338, 863, 774, 235, 289, 58, 856, 827, 932, 773, 242, 877, 741, 864, 128, 410, 567, 237, 805, 837, 385, 199, 73, 506, 163, 933, 328, 749, 745, 223, 164, 319, 917, 736, 414, 681, 621, 892, 169, 538, 454, 749, 832, 802, 371, 0, 383, 326, 749, 296, 75, 44, 288, 113, 739, 310, 376, 386, 808, 633, 683, 931, 864, 129, 400, 298, 286, 626, 416, 840, 960, 413};


        //System.out.println(Arrays.toString(minimumSmallKNumber.getLeastNumbers(new int[]{3, 2, 1}, 2)));
        //System.out.println(Arrays.toString(minimumSmallKNumber.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
        //System.out.println(Arrays.toString(minimumSmallKNumber.getLeastNumbers(new int[]{3, 1, 2, 1}, 1)));
        //System.out.println(Arrays.toString(minimumSmallKNumber.getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 8)));
        System.out.println(Arrays.toString(minimumSmallKNumber.getLeastNumbers(test, 666)));
    }

    /**
     * 快排
     * 先找出第k小的index，然后返回arr[0,index]
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {

        if (k >= arr.length) {
            return arr;
        }
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        // 要找到最终位置 下标是k-1
        int end = quickSort(arr, 0, arr.length - 1, k-1);
        return Arrays.copyOf(arr, end + 1);
    }

    private int quickSort(int[] arr, int low, int high, int k) {

        if (low <= high) {

            if (high == k - 1) {
                return high;
            }

            int pivotPos = partition(arr, low, high);
            if (pivotPos == k) {
                return pivotPos;
            } else if (pivotPos < k) {
                return quickSort(arr, pivotPos + 1, high, k);
            }else {
                return quickSort(arr, low, pivotPos - 1, k);
            }

        }

        return -1;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;


    }
}
