package LLD.MultiThreading.ProducerConsumer_problem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class SubmissionBlockQue {
    private static int idCounter = 1;
    private final int submissionId;
    private final String userName;

    public SubmissionBlockQue(String userName) {
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

class BlockingQueueSubmission {
    private final BlockingQueue<SubmissionBlockQue> queue = new LinkedBlockingQueue<>(5); // bounded buffer

    // Producer
    public void submit(SubmissionBlockQue submission) throws InterruptedException {
        queue.put(submission); // blocks if full
        System.out.println(submission.getUserName() + " Submitted the work ");

    }

    // Consumer
    public SubmissionBlockQue consume(String judgeName) throws InterruptedException {
        SubmissionBlockQue sub = queue.take(); // blocks if Empty
        System.out.println(sub.getUserName() + " is processed by " + judgeName);
        return sub;
    }

}

public class BlockingQueueFastProduceAndSlowConsumer {

    public static void main(String[] args) {
        BlockingQueueSubmission submissionQue = new BlockingQueueSubmission();

        // Submittis 10 submissions by each thread
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    SubmissionBlockQue sub = new SubmissionBlockQue(Thread.currentThread().getName());

                    submissionQue.submit(sub);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Consumes infinite submissions slowly compare to producer
        Runnable consumer = () -> {
            try {
                while (true) {
                    submissionQue.consume(Thread.currentThread().getName());
                    Thread.sleep(3000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread prodcuceThread1 = new Thread(producer, "Producer Thread 1");
        Thread prodcuceThread2 = new Thread(producer, "Producer Thread 2");

        Thread consumerThread1 = new Thread(consumer, "Consumer Thread 1");
        Thread consumerThread2 = new Thread(consumer, "Consumer Thread 2");

        prodcuceThread1.start();
        prodcuceThread2.start();

        consumerThread1.start();

        consumerThread2.start();
    }
}
