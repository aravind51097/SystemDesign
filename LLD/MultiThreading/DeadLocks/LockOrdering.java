package LLD.MultiThreading.DeadLocks;

import java.util.Arrays;

public class LockOrdering {

    static class Resource {
        int id;
        int val;

        Resource(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Resource res1 = new Resource(101, 2000);
        Resource res2 = new Resource(201, 400);

        // runnable object calling transfer method on lambda
        Runnable resTask1 = () -> transfer(res1, res2, 50);
        Runnable resTask2 = () -> transfer(res2, res1, 30);

        new Thread(resTask1, "T1").start(); // new thread with runnable
        new Thread(resTask2, "T2").start();

    }

    // Using lock ordering we can avoid dead locks
    private static void transfer(Resource res1, Resource res2, int i) {
        // ordering the lock objects in asce based on id's
        Resource[] lockObjs = new Resource[] { res1, res2 };
        Arrays.sort(lockObjs, (x, y) -> Integer.compare(x.id, y.id));

        // taking 1st monitor lock
        synchronized (lockObjs[0]) {
            System.out.println(Thread.currentThread().getName() + " taken a lock on " + lockObjs[0].id);
            // taking 1st monitor lock
            synchronized (lockObjs[1]) {
                System.out.println(Thread.currentThread().getName() + " taken a lock on inner syc " + lockObjs[1].id);
            }
        }

    }

}
