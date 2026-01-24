package LLD.MultiThreading.Semaphore;

import java.util.concurrent.Semaphore;

class SharedResources {
    private final Semaphore sema = new Semaphore(2);

    public void accessResource(String name) {
        try {
            sema.acquire();
            System.out.println("access granted to " + name);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("exception in " + name);
        } finally {
            System.out.println("releasing resource for " + name);
            sema.release();
        }
    }
}

public class SemaphoreEx {
    public static void main(String[] args) {
        SharedResources resource = new SharedResources();

        for (int i = 0; i <= 5; i++) {
            String name = "Thread - " + i;

            new Thread(() -> resource.accessResource(name)).start();
        }
    }

}
