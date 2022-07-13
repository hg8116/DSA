package Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Collections{
    int n;
    int colSize;
    ArrayList<Integer> files = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    Collections(){
        colSize = 0;
    }
//    Collections(int n){
//        this.n = n;
//    }

    public void getInput(int s, int num){
        files.add(s);
        size.add(num);
        colSize += num;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numCol = sc.nextInt();
        Collections[] col = new Collections[numCol];

        for(int i=0; i<numCol; i++){
            col[i] = new Collections();
        }

        for(int i=0; i<n; i++){
            System.out.println("File Info: ");
            int colNum = sc.nextInt();
            int fileName = sc.nextInt();
            int fileSize = sc.nextInt();
//            col[colNum] = new Collections();
            col[colNum].getInput(fileName, fileSize);
        }

        for(int i=0; i<numCol; i++){
            System.out.println("Collection Size: " + col[i].colSize);
        }

        Arrays.sort(col);



    }
}
