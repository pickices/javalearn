import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {

    public static void main(String[] args) {
        int[][] points = {};
        System.out.println(findMinArrowShots(points));

    }

    public static int findMinArrowShots(int[][] points) {
        if(points.length==0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int min =points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>min){
                count++;
                min = points[i][1];
            }
        }
        return count;
    }
}
