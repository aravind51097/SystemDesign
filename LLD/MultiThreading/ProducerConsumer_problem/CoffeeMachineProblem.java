package LLD.MultiThreading.ProducerConsumer_problem;

class CoffeeMachine {
    // Flag to indicate buffer status: true → coffee ready, false → cup empty
    private boolean isCoffeeReady = false;

    // Method to be run by the producer thread
    public synchronized void makeCoffee() throws InterruptedException {
        // If coffee is already ready, producer must wait (buffer is full)
        while (isCoffeeReady) {
            // Releases lock and waits until notified by consumer
            wait();
        }

        // Simulate coffee preparation
        System.out.println("Preparing coffee…");
        Thread.sleep(1000); // Simulate time to make coffee

        // Set the buffer to full (coffee is now ready)
        isCoffeeReady = true;
        System.out.println("Coffee ready!");

        // Notify the consumer thread that coffee is available
        notify();
    }

    // Method to be run by the consumer thread
    public synchronized void drinkCoffee() throws InterruptedException {
        // If no coffee is available, consumer must wait (buffer is empty)
        while (!isCoffeeReady) {
            // Releases lock and waits until notified by producer
            wait();
        }

        // Simulate coffee consumption
        System.out.println("Drinking coffee…");
        Thread.sleep(1000); // Simulate time to drink coffee

        // Set the buffer to empty (coffee has been consumed)
        isCoffeeReady = false;
        System.out.println("Cup emptied - prepare next!");

        // Notify the producer thread that it can brew again
        notify();
    }
}

public class CoffeeMachineProblem {
    public static void main(String[] args) {
        // Shared CoffeeMachine object acts as the synchronized monitor
        CoffeeMachine machine = new CoffeeMachine();

        // Producer thread that continuously makes coffee
        Thread producerThread = new Thread(() -> {
            while (true) {
                try {
                    machine.makeCoffee();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Consumer thread that continuously drinks coffee
        Thread consumerThread = new Thread(() -> {
            while (true) {
                try {
                    machine.drinkCoffee();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // start the Threads
        producerThread.start();
        consumerThread.start();     

    }

}
