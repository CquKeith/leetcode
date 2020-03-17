package JavaConcurrency;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenmengliang
 * @date 2019/10/29 11:25
 **/
public class ConCurrentHashMapTest {
    public static void main(String[] args) {

        Map<String,String> premiumPhone =
                new ConcurrentHashMap<>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        int i=0;
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
            premiumPhone.put("Sony"+i++,"Sony");
        }

        System.out.println("----------");
        iterator = premiumPhone.keySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
}
