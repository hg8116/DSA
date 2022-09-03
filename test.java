import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class test {
    static int maxNum(int n){
        int num = 0;
        for (int i=0; i<n; i++){
            num = num * 10 + 9;
        }

        return num;
    }

    static int mixNum(int n){
        int num = 1;
        for (int i=0; i<n-1; i++){
            num = num * 10;
        }

        return num;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(maxNum(n));
        System.out.println(mixNum(n));
    }
}