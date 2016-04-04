import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x);
        System.out.println(x ^ 9);

        int y = 3;
        System.out.println(y & (~ (y - 1)));
    }
}
