package LLD.MultiThreading.ProducerConsumer_problem;

import java.util.LinkedList;
import java.util.Queue;

class Submission {
    private static int idCounter = 1;
    private final int submissionId;
    private final String userName;

    public Submission(String userName) {
        this.userName = userName;
        this.submissionId = idCounter++;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public String getUserName() {
        return userName;
    }
}

class SubmissionQueue {
    private Queue<Submission> submissionQueue = new LinkedList<>();
    private int MAX_CAPACITY = 5;

    public synchronized void submit(Submission submission) throws InterruptedException {
        while (submissionQueue.size() >= MAX_CAPACITY) {
            System.out.println("Queue is full " + submission.getUserName() + " is Waiting to submit ");
            wait();
        }
        submissionQueue.offer(submission);
        System.out.println(submission.getUserName() + " Submitted to Queue with id " + submission.getSubmissionId());
        notifyAll();

    }

    public synchronized Submission consume(String judgeName) throws InterruptedException {

        while (submissionQueue.isEmpty()) {
            System.out.println("Submission Queue is Empty waiting for submissions ");
            wait();
        }
        Submission sub = submissionQueue.poll();
        System.out.println("Submission id " + sub.getSubmissionId() + " is processed for " + sub.getUserName());
        notifyAll();
        return sub;
    }

}

// handling the fast produce and slow consumer
public class FastProduceAndSlowConsumer {
    public static void main(String[] args) {
        SubmissionQueue submissionQueue = new SubmissionQueue();

        Runnable producerTask = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Submission sub = new Submission(Thread.currentThread().getName());
                    submissionQueue.submit(sub);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable consumetTask = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    submissionQueue.consume(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread producerThread1 = new Thread(producerTask, "Producer t1");
        Thread producerThread2 = new Thread(producerTask, "Producer t2");

        Thread consumerTread1 = new Thread(consumetTask, "Consumer T1");
        Thread consumerTread2 = new Thread(consumetTask, "Consumer T2");

        producerThread1.start();
        producerThread2.start();

        consumerTread1.start();
        consumerTread2.start();

    }

}
