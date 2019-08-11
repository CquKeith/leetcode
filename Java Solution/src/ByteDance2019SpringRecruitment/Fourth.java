package ByteDance2019SpringRecruitment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/10/2019 3:41 PM
 **/
public class Fourth {

    private void solution(){
        Scanner scanner = new Scanner(System.in);

        //测试用例个数
        int numberOfTest = scanner.nextInt();
        //循环输入并解决每个用例
        while (numberOfTest -- > 0){
            //输入该测试用例视频帧数
            int frameNumOfCurrentTest = scanner.nextInt();
            //特征运动的最大长度
            int maxLength = 0;

            //输入每一帧
            //算法思想：将每组特征和 上一次出现的帧数，当前连续帧数 通过map存起来
            //如 (i,j)->(m,n).
            // 其中(i,j)表示特征，m是上次出现在第几帧，n是当前连续几帧
            Map<Map<Integer,Integer>, Map<Integer,Integer>> mapMapHashMap = new HashMap<>(frameNumOfCurrentTest);
            for (int i = 0; i < frameNumOfCurrentTest; i++) {
                //当前帧的特征数
                int featureNumOfCurrentFrame = scanner.nextInt();
                //存储当前帧的每个特征
//                Map<Integer,Integer> featureMap = new HashMap<>(featureNumOfCurrentFrame);
                for (int j = 0; j < featureNumOfCurrentFrame; j++) {
                    //当前的feature
                    Map<Integer,Integer> featureMap = new HashMap<>(1);
                    featureMap.put(scanner.nextInt(),scanner.nextInt());

                    if (mapMapHashMap.containsKey(featureMap)){
                        Map<Integer,Integer> valueMap = mapMapHashMap.get(featureMap);
                        //取出上次出现在第几帧，当前已经连续多少帧了
                        int lastFrame = valueMap.keySet().iterator().next();
                        int currentContinue = valueMap.values().iterator().next();
                        //如果到当前帧还是连续的
                        if (lastFrame == i-1){
                            lastFrame = i;
                            currentContinue += 1;
                            //更新最大连续的长度
                            maxLength = Math.max(maxLength,currentContinue);
                            valueMap.clear();
                            valueMap.put(lastFrame,currentContinue);
                            //更新当前feature的m n属性
                            mapMapHashMap.put(featureMap,valueMap);
                        }
                    }else {
                        Map<Integer,Integer> valueMap = new HashMap<>(1);
                        valueMap.put(i,1);
                        mapMapHashMap.put(featureMap,valueMap);
                        //更新最大长度
                        maxLength = Math.max(1,maxLength);
                    }
                }
            }
            System.out.println(maxLength);
        }

    }

    public static void main(String args[]) {
        new Fourth().solution();
    }

}
