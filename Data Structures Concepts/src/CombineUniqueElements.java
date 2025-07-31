import java.util.ArrayList;
import java.util.List;

public class CombineUniqueElements {

    public static void main(String[] args) {
        // Static lists A and B
        int[] A = {2, 5, 9, 14, 15, 7, 20, 17, 30};
        int[] B = {14, 2, 9, 13, 37, 8, 7, 28};

        // Combine unique elements into list C
        List<Integer> C = combineUniqueElements(A, B);

        // Print the elements in list C
        System.out.println("Combined Unique Elements from A and B: " + C);
    }

    public static List<Integer> combineUniqueElements(int[] A, int[] B) {
        // List to store combined unique elements
        List<Integer> C = new ArrayList<>();

        // Add all elements from A to C
        for (int a : A) {
            C.add(a);
        }

        // Check if elements in B are already in C
        for (int b : B) {
            if (!C.contains(b)) {
                C.add(b);
            }
        }

        return C;
    }
}
