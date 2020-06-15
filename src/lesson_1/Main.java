/**
 * Java3. Homework 1
 * Created by СПБ on 15.06.2020.
 *
 * @author Fedorov Konstantin
 */
package lesson_1;



public class Main {
    public static void main(String[] args) {

        Integer arr1[] = {3, 5, 6, 78, 34};
        // Задание 1
        TaskOneTwo.swapArr(arr1,2,4);
        // Задание 2
        System.out.println(TaskOneTwo.transformToArrayList(arr1));
        // Задание 3
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> box1 = new Box<Apple>();
        box1.putFruit(apple1);
        box1.putFruit(apple2);
        box1.putFruit(apple3);
        Box<Orange> box2 = new Box<Orange>();
        box2.putFruit(orange1);
        box2.putFruit(orange2);

        System.out.println(box1.compare(box2));

        Box<Orange> box3 = new Box<Orange>();
        box2.transfer(box3);
    }


}
