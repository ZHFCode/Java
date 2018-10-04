package dianxin;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by ZHF on 2018/9/12.
 */
public class Singlton {
    public static void main(String[] args) {
        TEST test = TEST.getInstance();
        TEST test1 = TEST.getInstance();
        test1.a = 200;
//        System.out.println(test.equals(test1));
        Object o = new Object();
        System.out.println(o.getClass());

    }
}

class TEST{
    public int a = 100;
    private TEST(){}
    private static TEST instance = null;
    public static TEST getInstance(){
        if (instance == null) {
            instance = new TEST();
        }
        return instance;
    }

    @Override
    public boolean equals(Object obj) {
        TEST t = (TEST) obj;
        return this.a == t.a;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
