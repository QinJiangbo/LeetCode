package Interview;

/**
 * @date: 23/03/2017 11:31 AM
 * @author: qinjiangbo@github.io
 */
import java.util.Scanner;

public class LoadBalance {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int maxQps= Integer.valueOf(in.nextLine());
        final String[] rtList = in.nextLine().split(",");
        final int requestNum = Integer.valueOf(in.nextLine());
        final int threadNum = Integer.valueOf(in.nextLine());
        System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
    }
    /**
     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
     * @return
     */
    static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
        //TODO
        int sum = 0; // sum of qps
        for (String rt: rtList) {
            int qps = threadNum * 1000 / Integer.valueOf(rt);
            if (qps > maxQps) { sum = sum + maxQps; }
            else { sum = sum + qps; }
        }
        return requestNum / sum * 1000;
    }
}
