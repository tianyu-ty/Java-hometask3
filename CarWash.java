package hometask3;

import java.util.ArrayList;
import java.util.List;

class CarWash {
    private final int stationTime; 
    private final int stationCount;
    private final List<Car> queue = new ArrayList<>();
    public CarWash(int stationTime, int stationCount) {
        this.stationTime = stationTime;
        this.stationCount = stationCount;
    }

    public synchronized boolean enterQueue(Car car) {
        long startTime = System.currentTimeMillis();
        long waitTime = 5000; 

        while (queue.size() >= stationCount) {
            if (System.currentTimeMillis() - startTime >= car.maxWaitTime) {
                return false;
            }
            try {
                wait(waitTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        queue.add(car);
        return true;
    }

    public synchronized void washCar(Car car) {
        try {
            Thread.sleep(stationTime * 1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        queue.remove(car);
        notifyAll(); 
    }
}