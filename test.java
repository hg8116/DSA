import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int[] dp = new int[5];

        for(int[] row: arr){
            Arrays.fill(row, 5);
        }
        Arrays.fill(dp, 1);

//        for(int[] row: arr){
//            System.out.println(Arrays.toString(row));
//            System.out.println(Arrays.binarySearch(row, 5));
//        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(5);
        ans.add(10);

        System.out.println(Collections.binarySearch(ans, 5));
    }
}