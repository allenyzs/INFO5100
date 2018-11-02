package assignment7;

import java.util.Scanner;

public class Helper {
    public static void helper(int val) throws MyIndexOutOfBoundException{
        int left = 0;
        int right = 7;
        if (left <= val && val <= right){
            System.out.println("Ok");
        } else {
            throw new MyIndexOutOfBoundException(left, right, val);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your index");
        int val = scanner.nextInt();
        try {
            helper(val);
        } catch (MyIndexOutOfBoundException e) {
            System.out.println(e);
        }
    }
}
