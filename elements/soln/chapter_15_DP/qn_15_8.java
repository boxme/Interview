import java.util.*;

// Largest rectange under the skyline
public class qn_15_8 {
    
    public int solution(int[] buidingHeights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[buildingHeights.length];
        int[] right = new int[buildingHeights.length];

        for (int i = 0; i < buildingHeights.length; ++i) {
            while (!stack.isEmpty() && buildingHeights[i] <= buildingHeights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = buildingHeight.length - 1; i >= 0; --i) {
            while(!stack.isEmpty() && buildingHeights[i] <= buildingHeights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? buildingHeight.length - 1 : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < buildingHeights.length; ++i) {
            int area = buildingHeights[i] * (right[i] - left[i] + 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
