
import java.util.*;

public class test {
    public static void main(String[] args) {

    }
    static void MinInArray(int[] arr){
        int min = arr[0];
        int ind = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min){
                ind = i;
                min = arr[i];
            }
        }
        System.out.println(min);
        System.out.println(ind);
    }
}


