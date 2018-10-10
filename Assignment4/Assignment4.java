import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Assignment4 {

    /**
     * The deadline of assignment4 is 10/12/2018 23:59 PST.
     * Please feel free to contact Zane and Amanda for any questions.
     */

    /*
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * s = "leetcode" return 0.
     * s = "loveleetcode" return 2.
     */
    public static int[] array = new int[]{0, 1, 0, 3, 12};

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int j = 0; j < s.length(); j++){
            if (map.get(s.charAt(j)) == 1){
                res = j;
                return res;
            }
        }
        return res;
    }

    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public static int addDigits(int n) {
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n = n / 10;

            if (n == 0 && sum > 9){
                n = sum;
                sum = 0;
            }
        }
        return sum;
    }



    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != 0){
                swap(nums, i, j);
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int start  = 0, end = 0, maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++){
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i + 1);
            maxLen = Math.max(len1, len2);
            if (maxLen > 0){
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int helper(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
  			      [4,5,6],
  			      [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
  								 [8,5,2],
  								  [9,6,3] ],
     */

    public static int[][] rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m / 2; i++){
            for (int j = i; j < m - i - 1; j++){
                int temp = matrix[i][j];

                matrix[i][j] = matrix[m - j - 1][i];
                matrix[m - j - 1][i] = matrix[m - i - 1][m - j - 1];
                matrix[m - i - 1][m - j - 1] = matrix[j][m - i - 1];
                matrix[j][m - i - 1] = temp;
            }
        }
        return matrix;
    }


    public static void main(String[] args){
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));

        System.out.println();

        System.out.println(addDigits(9999));

        System.out.println();
        System.out.println(Arrays.toString(array));
        moveZeroes(array);
        System.out.println(Arrays.toString(array));

        System.out.println();

        int[][] matrix = new int[][]{
                new int[] {1,2,3,4},
                new int[] {5,6,7,8},
                new int[] {9,10,11,12},
                new int[] {13,14,15,16}
        };
        for (int[] hey : matrix){
            System.out.println(Arrays.toString(hey));
        }

        System.out.println();

        rotate(matrix);
        for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}