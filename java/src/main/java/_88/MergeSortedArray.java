package _88;

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[last--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[last--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[last--] = nums2[j--];
        }
    }
}

