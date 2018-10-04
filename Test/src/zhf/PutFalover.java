package zhf;

import java.util.*;

/**
 * Created by ZHF on 2018/9/3.
 */
public class PutFalover {

    public static boolean CPU = true;
    public static boolean MEM = false;

    //放置虚拟机
    //基于首适应FFT方法和模拟退火方法计算最优值
    //该函数需要的参数是:
    //使用模拟退火算法找最佳的虚拟机放置方式
    //输入参数：
    //map_predict_num_flavors：上一步预测出来的各种虚拟机数量，key是虚拟机名称，value是虚拟机数量
    //map_flavor_cpu_mem：程序输入的虚拟机类型数据，key为虚拟机名称，value是虚拟机类型（包括name，cpu，mem字段）
    //server_mem && server_cpu：程序输入的服务器参数，CPU和内存大小
    //CPUorMEM：是使CPU利用率最高还是使内存利用率最高
    //输出参数：
    //res_servers：存放有计算出的最优服务器中虚拟机存放方式，可通过成员flavors访问每个服务器中存放的虚拟机

    public static ArrayList<Server> put_flavors_to_servers(HashMap<String,Integer> map_predict_num_flavors,
                                                           HashMap<String,Flavor> map_flavor_cpu_mem, int server_mem,
                                                           int server_cpu, boolean CPUorMEM){

        ArrayList<Flavor> vec_flavors = new ArrayList<>();  //vec_flavors中存放的是虚拟机
        Set<Map.Entry<String,Integer>> set = map_predict_num_flavors.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();   //虚拟机名称
            int num = map_predict_num_flavors.get(entry.getKey());
            while (num > 0) {
                vec_flavors.add(map_flavor_cpu_mem.get(entry.getKey()));
            }
        }

        // 模拟退火算法找出最优解
        System.out.println("模拟退火执行中....");
        double min_serve = vec_flavors.size()+1;
        ArrayList<Server> res_serve = new ArrayList<>();
        double T = 100; //模拟退火初始温度
        double Tmin = 1; //模拟退火终止温度
        double r = 0.9999; //温度下降系数
        ArrayList<Integer> dice = new ArrayList<>();
        for (int i=0;i<vec_flavors.size();i++){
            dice.add(i);
        }

        while (T > Tmin) {
            // 投掷骰子，如vector前两个数为3和9，则把vec_flavors[3]和vec_flavors[9]进行交换作为新的flavors顺序
            Collections.shuffle(dice);
            ArrayList<Flavor> new_vec_flavors = new ArrayList<>();
            Collections.swap(vec_flavors,dice.get(0),dice.get(1));

            //把上一步计算出来的虚拟机尝试加入到服务器中

            //先使用一个服务器放置虚拟机
            ArrayList<Server> servers = new ArrayList<>();
            Server fristserver = new Server(server_mem,server_cpu);
            servers.add(fristserver);

            //放置虚拟机的主要逻辑
            //如果当前所有服务器都不放置虚拟机，就新建一个服务器用于存放
            Iterator itor = servers.iterator();
            for (Flavor flavor:new_vec_flavors) {
                Server server = (Server) itor.next();
                while (itor.hasNext()){
                    if (server.put_flavor(flavor)){
                        break;
                    }
                }
                if (!itor.hasNext()){
                    Server new_server = new Server(server_mem,server_cpu);
                    new_server.put_flavor(flavor);
                    servers.add(new_server);
                }
            }

            //计算本次放置虚拟机耗费服务器评价分数
            //如果使用了N个服务器，则前N-1个服务器贡献分数为1，第N个服务器分数为资源利用率
            //模拟退火就是得到取得分数最小的放置方式

            double server_num = 0.0;
            //对于题目关心cpu还是mem，需要分开讨论，资源利用率计算方法不同
            if (CPUorMEM == CPU)
                server_num = servers.size()-1 + servers.get(servers.size()-1).get_cpu_usage_rate();
            else
                server_num = servers.size()-1 + servers.get(servers.size()-1).get_men_usage_rate();

            //如果分数更低则保存结果
            if (server_num < min_serve){
                min_serve = server_num;
                res_serve = servers;
                vec_flavors = new_vec_flavors;
            } //如果分数过高，则以一定概率保存结果，防止优化陷入局部最优解
            else {
                if (Math.exp(min_serve-server_num)/T > Math.random()) {
                    min_serve = server_num;
                    res_serve = servers;
                    vec_flavors = new_vec_flavors;
                }
            }

            T = T*r;
        }
        return res_serve;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map_predict_num_flavors = new HashMap<>();
        map_predict_num_flavors.put("flavor1", 3);
        map_predict_num_flavors.put("flavor2", 4);
        map_predict_num_flavors.put("flavor3", 2);
        map_predict_num_flavors.put("flavor4", 1);
        map_predict_num_flavors.put("flavor5", 2);

        Map<String, Flavor> map_flavor_cpu_mem = new HashMap<>();
        map_flavor_cpu_mem.put("flavor1", new Flavor("flavor1", 1, 1));
        map_flavor_cpu_mem.put("flavor2", new Flavor("flavor2", 1, 2));
        map_flavor_cpu_mem.put("flavor3", new Flavor("flavor3", 1, 4));
        map_flavor_cpu_mem.put("flavor4", new Flavor("flavor4", 2, 2));
        map_flavor_cpu_mem.put("flavor5", new Flavor("flavor5", 2, 4));

        int server_cpu = 56;
        int server_mem = 128;
        boolean CPUorMEM = CPU;

        ArrayList<Server> res = put_flavors_to_servers(map_predict_num_flavors, (HashMap<String, Flavor>) map_flavor_cpu_mem, server_mem, server_cpu, CPUorMEM);
        for (Server server:res) {
            for (Flavor flavor:server.flavors) {
                System.out.println(flavor.getName());
            }
        }
    }
}

//虚拟机的类
class Flavor {
    private String name;
    private int corenum;
    private int memsize;

    public Flavor(String name, int corenum, int memsize) {
        this.name = name;
        this.corenum = corenum;
        this.memsize = memsize;
    }

    public String getName() {
        return name;
    }

    public int getCorenum() {
        return corenum;
    }

    public int getMemsize() {
        return memsize;
    }
}

//服务器的类
class Server{
    private int total_mem;
    private int total_cpu;
    private int free_mem;
    private int free_cpu;

    Server(int mem,int cpu){
        free_mem = mem;
        free_cpu = cpu;
        total_mem = mem;
        total_cpu = cpu;
    }

    public ArrayList<Flavor> flavors;


    public double get_cpu_usage_rate(){
        return 1-free_cpu/(double)total_cpu;
    }

    public double get_men_usage_rate(){
        return 1-free_mem/(double)total_mem;
    }

    public boolean put_flavor(Flavor flavor){
        if (free_cpu >= flavor.getCorenum() && free_mem >= flavor.getMemsize()){
            free_cpu -= flavor.getCorenum();
            free_mem -= flavor.getMemsize();
            flavors.add(flavor);
            return true;
        }
        return false;
    }
}
