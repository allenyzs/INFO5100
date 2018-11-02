package assignment7;

public class MedianOfTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;

        while (cut1 <= nums1.length){
            cut1 = cutL + (cutR - cutL) / 2;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == 0) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == 0) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2){
                cutR = cut1 - 1;
            } else if (L2 > R1){
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0){
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                } else{
                    R1 = R1 < R2 ? R1 : R2;
                    return R1;
                }
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
