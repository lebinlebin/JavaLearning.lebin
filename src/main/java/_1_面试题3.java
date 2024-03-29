import java.util.ArrayList;
import java.util.List;

/*

 */

public class _1_面试题3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        List<List<Integer>> cartesianProduct = getCartesianProduct(matrix);
        for (List<Integer> combination : cartesianProduct) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> getCartesianProduct(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        List<Integer> currentCombination = new ArrayList<>();
        getCartesianProductRecursive(matrix, 0, currentCombination, result);
        return result;
    }

    private static void getCartesianProductRecursive(int[][] matrix, int rowIndex, List<Integer> currentCombination, List<List<Integer>> result) {
        if (rowIndex == matrix.length) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int num : matrix[rowIndex]) {
            currentCombination.add(num);
            getCartesianProductRecursive(matrix, rowIndex + 1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
/*

 */
