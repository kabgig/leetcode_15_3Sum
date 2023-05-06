import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// -4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                for (int k = 0; k < nums.length; k++) {
                    if (j != i && k != i && j != k) {
                        if (nums[j] + nums[i] + nums[k] == 0) {
                            boolean isUnique = checker(nums[j], nums[i], nums[k], triplets);
                            if (isUnique)
                                triplets.add(
                                        new ArrayList<>(
                                                Arrays.asList(nums[j], nums[i], nums[k])));
                        }
                    }
                }
            }
        }
        return triplets;
    }

    public boolean checker(int a, int b, int c, List<List<Integer>> triplets) {
        boolean res = true;
        if (triplets.isEmpty()) return res;
        for (int i = 0; i < triplets.size(); i++) {
            List<Integer> list = triplets.get(i);
            int count = 0;
            for (var num : list) {
                if (num == a || num == b || num == c) count++;
            }
            if (count == 3) res = false;
        }
        return res;
    }
}
