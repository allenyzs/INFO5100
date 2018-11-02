package assignment7;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArrayTest {

    @org.junit.Test
    public void findMedianSortedArrays() {
        int[] arr1 = new int[]{3,4};
        int[] arr2 = new int[]{7};
        MedianOfTwoSortedArray test = new MedianOfTwoSortedArray();
        assertEquals(test.findMedianSortedArrays(arr1, arr2), (double) 4, 0);

    }
}