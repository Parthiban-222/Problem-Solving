import java.util.HashMap;
import java.util.Map;

public class SubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int result = 0;

        for (int left = 0; left < n; left++) {
            int[] runningSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    runningSum[i] += matrix[i][right];
                }

                result += countSubarraysWithSum(runningSum, target);
            }
        }

        return result;
    }

    private int countSubarraysWithSum(int[] arr, int target) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : arr) {
            sum += num;
            count += prefixSumCount.getOrDefault(sum - target, 0);
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubmatrixSumTarget solution = new SubmatrixSumTarget();

        int[][] matrix1 = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int target1 = 0;
        System.out.println(solution.numSubmatrixSumTarget(matrix1, target1));

        int[][] matrix2 = {{1, -1}, {-1, 1}};
        int target2 = 0;
        System.out.println(solution.numSubmatrixSumTarget(matrix2, target2)); 

        int[][] matrix3 = {{904}};
        int target3 = 0;
        System.out.println(solution.numSubmatrixSumTarget(matrix3, target3));
    }
}
