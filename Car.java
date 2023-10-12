package hometask3;

class Car extends Thread {
    private final CarWash carWash;
    private final String name;
    final long maxWaitTime = 5 * 1000; // 

    public Car(CarWash carWash, String name) {
        this.carWash = carWash;
        this.name = name;
    }

    @Override
    public void run() {
        if (carWash.enterQueue(this)) {
            System.out.println(name + " is in the queue.");
            carWash.washCar(this);
            System.out.println(name + " is washed.");
        } else {
            System.out.println(name + " waited too long and left.");
        }
    }
}