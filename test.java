import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x: ");
        long x = sc.nextLong();

        if (x >= -128 && x <= 127) System.out.println("* byte");
        if (x >= -32768 && x <= 32767) System.out.println("* short");
        if (x >= -2e31 && x <= (2e31 - 1)) System.out.println("* int");
        if (x >= -2e63 && x <= (2e63 - 1)) System.out.println("* long");
    }
}