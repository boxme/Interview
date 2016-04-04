import java.util.*;
import java.io.*;

public class qn_11_18 {

    public static String majoritySearch(InputStream sin) {
        Scanner scanner = new Scanner(sin);
        String temp;
        String majority = "";
        int count = 0;
        while (scanner.hasNextLine()) {
            temp = scanner.nextLine();
            if (count == 0) {
                majority = temp;
                count++;
            } else if (majority.equals(temp)) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}
