package ru.brauer.array;

public class App {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,2,3,3};
        System.out.println(removeDuplicates(arr));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            result += (nums[i - 1] != nums[i]) ? 1 : 0;
        }
        return result;
    }

}
