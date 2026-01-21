package LLD.MultiThreading.Ways_of_creating_Threads;

class TicketBooker extends Thread {
    public void run() {
        System.out.println("tickets booked ");
    }
}

public class ByExtendingThreadClass {
    public static void main(String[] args) {
        // extending thead class has to implement the void run()
        Thread t1 = new TicketBooker();
        t1.start();
        Thread t2 = new TicketBooker();
        try {
            Thread.sleep(2000);
            t2.start();
        } catch (Exception e) {
            System.err.println("inturrepeted");
        }

        //implementing Run

    }
}
