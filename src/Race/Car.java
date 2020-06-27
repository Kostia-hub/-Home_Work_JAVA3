package Race;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean winnerFound;
    private static int loserCarCount = 0;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cb;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    Car(Race race, int speed, CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
    }

    private static synchronized void checkWinner(Car c) {
        if (!winnerFound) {
            System.out.println(c.name + " - WIN");
            winnerFound = true;
        }
    }

    private static void checkLoserCar(Car c) {
        if (winnerFound) {
            loserCarCount++;
        }
        if(loserCarCount == 4) System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        checkWinner(this);
        checkLoserCar(this);
    }
}