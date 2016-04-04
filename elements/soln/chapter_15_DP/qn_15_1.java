import java.util.*;

public class qn_15_1 {

    public static class Ref<T> {
        public T value;

        public Ref(T v) {
            value = v;
        }
    }
    
    public static class Rectangle {
        public int left, right, height;
        
        public Rectangle(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }
    
    public static List<Rectangle> drawingSkylines(List<Rectangle> buildings) {
        return computeSkylineInInterval(buildings, 0, buildings.size());
    }
    
    private static List<Rectangle> computeSkylineInInterval(
            List<Rectangle> buildings, int leftEndpoint, int rightEndpoint) {
        if (rightEndpoint - leftEndpoint <= 1) {
            return new ArrayList<Rectange>(buildings.subList(leftEndpoint, rightEndpoint));
        }

        int mid = leftEndpoint + (rightEndpoint - leftEndpoint) / 2;
        
        List<Rectangle> leftSkyline = 
            computeSkylineInterval(buildings, leftEndpoint, mid);
        List<Rectangle> rightSkyline = 
            computeSkylineInterval(buildings, mid, rightEndpoint);

        return mergeSkylines(leftSkyline, rightSkyline);
    }

    private static List<Rectangle> mergeSkylines(List<Rectange> leftSkyline, List<Rectangle> rightSkyline) {
        int i = 0;
        int j = 0;
        List<Rectangle> merged = new ArrayList<Rectangle>();

        while (i < leftSkyline.size() && j < rightSkyline.size()) {
            if (leftSkyline.get(i).right < rightSkyline.get(j).left) {
                merged.add(leftSkyline.get(i++));
            } else if (leftSkyline.get(i).left > rightSkyline.get(j).right) {
                merged.add(rightSkyline.get(j++));
            } else if (leftSkyline.get(i).left <= rightSkyline.get(j).left) {
                Ref<Integer> iWrapper = new Ref<>(i);
                Ref<Integer> jWrapper = new Ref<>(j);
                mergeIntersectSkylines(merged, leftSkyline.get(i), iWrapper,
                                       rightSkyline.get(j), jWrapper);
                i = iWrapper.value;
                j = jWrapper.value;
            } else { // leftSkyline.get(i).left > rightSkyline.get(j).left
                Ref<Integer> iWrapper = new Ref<>(i);
                Ref<Integer> jWrapper = new Ref<>(j);
                mergeIntersectSkylines(merged, rightSkyline.get(j), jWrapper,
                                       leftSkyline.get(i), iWrapper);
                i = iWrapper.value;
                j = jWrapper.value;
            }
        }

        merged.addAll(leftSkyline.subList(i, leftSkyline.size()));
        merged.addAll(rightSkyline.subList(j, rightSkyline.size()));

        return merged;
    }

    private static void mergeIntersectSkylines(List<Rectangle> merged, Rectangle a, Ref<Integer> aIdx,
            Rectangle b, Ref<Integer> bIdx) {
        if (a.right <= b.right) {
            if (a.height > b.height) {
                
                if (a.right != b.right) {
                    merged.add(a);
                    b.left = a.left;
                    aIdx.value++;
                } else { // a.right == b.right
                    bIdx.value++;
                }

            } else if (a.height == b.height) {
                b.left = a.left;
                aIdx.value++;
            } else { // a.height < b.height
                if (a.left != b.left) {
                    merged.add(new Rectangle(a.left, b.left, a.height));
                }
                aIdx.value++;
            }
        } else { // a.right > b.right
            if (a.height >= b.height) {
                bIdx.value++;
            } else {
                if (a.left != b.left) {
                    merged.add(new Rectangle(a.left, b.left, a.height));
                }
                a.left = b.right;
                merged.add(b);
                bIdx.value++;
            }
        }
    }
}
