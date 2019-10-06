package DesignPattern.SingletonPattern;

/**
 * 枚举实现单例模式
 */
public enum SingletonEnum {
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }


    public static void main(String[] args) {

        //单例测试
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());

        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        secondSingleton.setObjName("secondName");

        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        System.out.println("--------------");


        //反射获取实例测试

        SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
        for (SingletonEnum enumConstant
                :enumConstants) {
            System.out.println(enumConstant.getObjName());
        }


    }

}
