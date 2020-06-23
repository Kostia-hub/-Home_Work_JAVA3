package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskOneTwo {
    /**
     * Задание 1
     * Написать метод, который меняет два элемента массива местами.
     * (массив может быть любого ссылочного типа).
     */
    public static void swapArr(Object[] arr, int index1, int index2){
        Object x = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = x;
    }
    /**
     * Задание 2
     * Написать метод, который преобразует массив в ArrayList.
     */
    public static <T> ArrayList<T> transformToArrayList(T[] arr){
        return new ArrayList(Arrays.asList(arr));
    }
}
