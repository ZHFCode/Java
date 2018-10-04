package kuaishou;

/**
 * Created by ZHF on 2018/9/26.
 */

public class Test {
    static    User user = new User("zhangsan");
    // 1.下面代码的运行结果
    public static  void changeName(User user){
        user.name = "lisi";
    }
    //2下面代码的运行结果
    public static void chg(User user){
        user = new User("wangwu");
    }
    public static void main(String[] args) {
        changeName(user);
        System.out.println(user.name);
        chg(user);
        System.out.println(user.name);
    }
}
class User{
    public String name;
    User(String name){
        this.name = name;
    }
}

