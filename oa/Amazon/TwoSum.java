public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    // public int twoSumClosest(int[] nums, int target) {
    //     // Write your code here
        
    //     Arrays.sort(nums);
        
    //     int min = Integer.MAX_VALUE;
        
    //     int left = 0;
    //     int right = nums.length - 1;
        
    //     while (left < right) {
    //         if (nums[left] + nums[right] < target) {
    //             min = Math.min(min, target - nums[left] - nums[right]);
    //             left++;
    //         }
    //         else {
    //             min = Math.min(min, nums[left] + nums[right] - target);
    //             right--;
    //         }
    //     }
        
    //     return min;
    // }
    public static void findOptimalWeights(double capacity, double[] weights, int numOfContainers){
        double min = 0.0;
        int minPos = 0;
        int maxPos = weights.length - 1;
        int i =0 , j =weights.length-1;

        Arrays.sort(weights);

        while(i < j){
            double sum = weights[i] + weights[j];

            if(sum > min && sum <= capacity){
                min = sum;
                minPos = i;
                maxPos = j;
            }

            if(sum > capacity){
                j--;
            }else {
                i++;
            }
        }

        System.out.println("The two numbers for which sum is closest to target are "
                + weights[minPos] + " and " + weights[maxPos]);
    }
}