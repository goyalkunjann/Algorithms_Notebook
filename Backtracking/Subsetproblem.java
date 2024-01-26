import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public static List<List<Integer>> subsetSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Optional: Sort the input array to generate subsets in a specific order
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                // Skip duplicates to avoid duplicate subsets
                continue;
            }

            if (target - nums[i] < 0) {
                // Skip if the remaining target is negative
                break;
            }

            current.add(nums[i]);
            backtrack(result, current, nums, target - nums[i], i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5};
        int target = 7;
        List<List<Integer>> subsets = subsetSum(nums, target);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
