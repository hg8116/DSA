
import java.util.*;

public class test {
    public static long subarraySum(List<Integer> arr, int n){
        long res = 0, temp = 0;
        for(int i=0; i<n; i++){
            temp = 0;
            for(int j=1; j<n; j++){
                temp = temp + arr.get(j);
                res += temp;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] temp = {1, 2, 3};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.print(subarraySum(arr, 3));
    }
}


