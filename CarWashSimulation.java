package hometask3;
	
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CarWashSimulation {
    public static void main(String[] args) {
        int numWashLocations = 3;  
        int maxWaitTime = 5;       

        ExecutorService carWashService = Executors.newFixedThreadPool(numWashLocations);

        for (int carNumber = 1; carNumber <= 10; carNumber++) {
            Car car = new Car(carNumber, carWashService, maxWaitTime);
            carWashService.execute(car);
        }

        carWashService.shutdown();
    }
}

class Car implements Runnable {
    private int carNumber;
    private ExecutorService carWashService;
    private int maxWaitTime;

    public Car(int carNumber, ExecutorService carWashService, int maxWaitTime) {
        this.carNumber = carNumber;
        this.carWashService = carWashService;
        this.maxWaitTime = maxWaitTime;
    }

    @Override
    public void run() {
        try {
            System.out.println("Car #" + carNumber + " arrives at the car wash station.");

            if (!carWashService.awaitTermination(maxWaitTime, TimeUnit.SECONDS)) {
                System.out.println("Car #" + carNumber + " waited too long and left.");
            } else {
                System.out.println("Car #" + carNumber + " has finished washing and leaves.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
