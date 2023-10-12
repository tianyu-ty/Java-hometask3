package hometask3;

public class Main {
    public static void main(String[] args) {
        CarWash carWash = new CarWash(2, 3); 
        for (int i = 1; i <= 10; i++) {
            Car car = new Car(carWash, "Car " + i);
            car.start();
        }
    }
}