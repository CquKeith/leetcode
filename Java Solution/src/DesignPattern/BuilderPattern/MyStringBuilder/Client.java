package DesignPattern.BuilderPattern.MyStringBuilder;

/**
 * @author chenmengliang
 * @date 2019/10/6 22:57
 **/
public class Client {
    public static void main(String[] args) {
        MyStringBuilder stringBuilder = new MyStringBuilder();

        final int count = 26;

        for (int i = 0; i < count; i++) {
            stringBuilder.append((char) ('a'+i));
        }
        System.out.println(stringBuilder.toString());
    }
}

