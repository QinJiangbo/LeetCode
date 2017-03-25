package Interview;

import java.util.*;

/**
 * @date: 25/03/2017 3:06 PM
 * @author: qinjiangbo@github.io
 */
public class Taxi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine()); // how many
        String xAxis = scanner.nextLine(); // taxi x
        String[] xs = xAxis.split(" ");
        String yAxis = scanner.nextLine(); // taxi y
        String[] ys = yAxis.split(" ");
        List<Axis> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Axis(Integer.valueOf(xs[i]), Integer.valueOf(ys[i])));
        }
        String[] gxy = scanner.nextLine().split(" "); // company location
        int gx = Integer.valueOf(gxy[0]), gy = Integer.valueOf(gxy[1]);
        String[] times = scanner.nextLine().split(" "); // time
        int walkTime = Integer.valueOf(times[0]), taxiTime = Integer.valueOf(times[1]);

        int minTime = (Math.abs(gx) + Math.abs(gy)) * walkTime;

        for (Axis axis : list) {
            int walking = (Math.abs(axis.x) + Math.abs(axis.y)) * walkTime;
            int taxing = (Math.abs(gx - axis.x) + Math.abs(gy - axis.y)) * taxiTime;
            minTime = minTime < (walking + taxing) ? minTime : (walking + taxing);
        }

        System.out.println("Shortest time : " + minTime);
    }



}

class Axis{
    int x;
    int y;

    Axis(int x, int y) {
        this.x = x;
        this.y = y;
    }
}