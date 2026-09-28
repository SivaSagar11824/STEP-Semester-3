package session_4.AP;

import java.util.Arrays;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        int numberOfTriplets = countTriplets(nums);
        int[][] answer = new int[numberOfTriplets][3];
        int position = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    answer[position][0] = nums[i];
                    answer[position][1] = nums[left];
                    answer[position][2] = nums[right];
                    position++;

                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }

    public static int countTriplets(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    count++;
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] answer = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(Arrays.deepToString(answer));
    }
}