package assignment7;

public class MedianOfTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
        }
        int halfLen = (nums1.length + nums2.length + 1) / 2;
        int min = 0, max = nums1.length;
        // 如果我们知道nums1怎么切 我们就知道nums2该怎么切
        while (min <= max){
            int i = (min + max) / 2;
            int j = halfLen - i;
            
            // L1 L2 R1 R2需要满足以下关系 ：
            // L1 < R2 && L2 < R1
            if (i < max && nums2[j - 1] > nums1[i]){
                min = i + 1;
            } else if (i > min && nums1[i - 1] > nums2[j]){
                max = i - 1;
            } else{
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0){
                    maxLeft = nums1[i - 1];
                } else{
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((nums1.length + nums2.length) % 2 == 1) return maxLeft;
                
                int minRight = 0;
                if (i == nums1.length) {
                    minRight = nums2[j];
                } else if (j == nums2.length) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return (double) -1;
    }

    public static void main(String[] args){
        int[] array1 = new int[] {1,3,5,7};
        int[] array2 = new int[] {2,4,6,8,10};
        System.out.println(findMedianSortedArrays(array1, array2));
    }
}
