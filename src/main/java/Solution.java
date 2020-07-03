package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution extends Throwable {
    public static void main(String[] args) {
        int [] mass = new int[] {1, 4, 5, 6, 3, 6, 4, 6, 7, 3};
        int [] mass2 = new int[] {1, 8, 5, 6, 3, 6, 6, 6, 7, 3};

        System.out.println(Arrays.toString(buildAfterFour(mass)));
        System.out.println(Arrays.toString(buildAfterFour(mass2)));

    }

    public static int[] buildAfterFour(int[] arr){
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]==4) {
                break;
            }else {
                newArray.add(arr[i]);
            }
        }
        if(arr.length == newArray.size()){
            throw new RuntimeException("В массиве нет четверок");
        }
        int[] newArr = new int[newArray.size()];
        for (int i = 0, j = newArr.length - 1; i < newArr.length; i++) {
            newArr[i] = newArray.get(j);
            j--;
        }
        return newArr;
    }

    public static boolean checkNumbers(int[] arr){
        boolean one = false;
        boolean four = false;
        for (int i: arr) {
            if(i != 1 && i!=4) throw new RuntimeException("В массиве постороннее число");
            if(i == 1) one = true;
            if(i == 4) four = true;
        }
        return one && four;
    }

}
