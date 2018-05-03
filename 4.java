class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int ilow = 0, ihigh = m, half = (m + n) / 2;
        while (ilow <= ihigh) {
            int i = (ilow + ihigh) / 2;
            int j = half - i;
            if (i < ihigh && nums1[i] < nums2[j - 1]) {
                ilow = ilow + 1;
            } else if (i > ilow && nums2[j] < nums1[i - 1]) {
                ihigh = ihigh - 1;
            } else {
                int maxleft = 0;
                if (i == 0) maxleft = nums2[j - 1];
                else if (j == 0) maxleft = nums1[i - 1];
                else maxleft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1) return maxleft;

                int minright = 0;
                if (i == m) minright = nums2[j];
                else if (j == n) minright = nums1[i];
                else minright = Math.min(nums1[i], nums2[j]);
                return (minright + maxleft) / 2;
            }
        }
    }
}