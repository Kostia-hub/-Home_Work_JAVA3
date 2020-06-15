package lesson_1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private  ArrayList<T> boxFruit;

    public Box() {
        boxFruit = new ArrayList<T>();
    }

    public void putFruit(T fruits){
        boxFruit.add(fruits);
    }

    public float getWeight(){
        if(boxFruit.size()==0) return 0;
        float x = 0;
        for (T y: boxFruit) {
            x += y.getWeight();
        }
        return x;
    }

    public Boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<T> box) {
        box.boxFruit.addAll(this.boxFruit);
        this.boxFruit.clear();
    }

}
