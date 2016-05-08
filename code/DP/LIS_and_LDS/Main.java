import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

class UVa11456{}

class Main {
    private int[] cars;
    private int[] LIS, LDS;
    private int num_cars;
       
       void run() throws Exception {
	   IntegerScanner scanner = new IntegerScanner(System.in);
	   PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	   int test_cases = scanner.nextInt();

	   while (test_cases-- > 0) {
	       num_cars = scanner.nextInt();
	       cars = new int[num_cars];
	       LIS = new int[num_cars];
	       LDS = new int[num_cars];

	       for (int i = 0; i < num_cars; ++i)
	           cars[i] = scanner.nextInt();

	       /* Initialize the base case*/
	       Arrays.fill(LIS, 1);
	       Arrays.fill(LDS, 1);

	       int answer = 0;

	       /* LIS[i] is longest increasing sequence starting with i*/
	       for (int i = num_cars-2; i >= 0; --i)
	           for (int j = num_cars-1; j > i; --j)
	               if (cars[i] < cars[j])
	                   LIS[i] = Math.max(LIS[i], LIS[j] + 1);

	       /*LDS[i] is longest decreasing sequence starting with i*/
	       for (int i = num_cars-2; i >= 0; --i)
	           for (int j = num_cars-1; j > i; --j)
	               if (cars[i] > cars[j])
	                   LDS[i] = Math.max(LDS[i], LDS[j] + 1);

	       /*LIS[i] longest increasing sequence ending with i*/
	       for (int i = 1; i < num_cars; ++i)
	           for (int j = 0; j < i; ++j)
	               if (cars[i] > cars[j])
	                   LIS[i] = Math.max(LIS[i], LIS[j] + 1);
	       
	       /*LDS[i] longest decrease sequnce ending with i*/
               for (int i = 1; i < num_cars; ++i)
                   for (int j = 0; j < i; ++j)
                       if (cars[i] < cars[j])
                           LDS[i] = Math.max(LDS[i], LDS[j] + 1);

               for (int i = 0; i < num_cars; ++i)
	           answer = Math.max(answer, LIS[i] + LDS[i] - 1);

               pw.println(answer);
           }
           pw.close();
        }
	
	public static void main(String[] args) throws Exception{
		Main program = new Main();
		program.run();		
	}
}

class CompareCars implements Comparator<Integer> {
    @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
}

class IntegerScanner {
    BufferedInputStream bis;
    IntegerScanner(InputStream is) {
        bis = new BufferedInputStream(is, 1000000);
    }

    public int nextInt() {
        int result = 0;
        try {
            int cur = bis.read();
            if (cur == -1) return -1;

            while (cur < 48 || cur > 57) {
                cur = bis.read();
            }

            while (cur >= 48 && cur <= 57) {
                result = result * 10 + (cur - 48);
                cur = bis.read();
            }
            return result;
        }
        catch (IOException ios) {
            return -1;
        }
    }
}
