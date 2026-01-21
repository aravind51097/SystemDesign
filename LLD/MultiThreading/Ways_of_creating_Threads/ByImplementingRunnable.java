package LLD.MultiThreading.Ways_of_creating_Threads;

class RunMeOnThread implements Runnable {
    int counter = 0;

    public void run() {

        counter = incrementMe(counter);
        System.out.println("incremented val =" + counter);
    }

    private int incrementMe(int counter) {
        System.out.println("Incremented counter");
        return ++counter;
    }
}

public class ByImplementingRunnable {
    public static void main(String[] args) throws InterruptedException {
        // its a runnable object which has to pass to thread class
        Runnable runnableObj = new RunMeOnThread();

        // Creating the Thread class which take runnable , Thread class only has start()
        // method
        Thread tt1 = new Thread(runnableObj);
        Thread tt2 = new Thread(runnableObj);
        Thread t3 = new Thread(runnableObj);

        tt1.start();
        tt2.start();
        Thread.sleep(2000);
        t3.start();
    }

}
