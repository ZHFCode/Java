package zhf;

/**
 * Created by ZHF on 2018/8/4.
 */
public class TestExtend {
    public static void main(String[] args) {
    Son s = new Son();
    s.A();
    }
}
class Parent implements inter{
    void show(){
        System.out.println("ok");
    }
}

class Son extends Parent {

}

interface inter {
    default void A(){
        System.out.println("AAA");
    }
}