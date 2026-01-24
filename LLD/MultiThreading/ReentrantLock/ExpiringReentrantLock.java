package LLD.MultiThreading.ReentrantLock;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import Structural_Pattern.Facade.MovieTicketBookingfacade;

class BookMovieTicket {
    private final ReentrantLock lock = new ReentrantLock();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private volatile boolean isSeatBooked = false;

    public boolean bookSeat(String MovieName) {
        boolean isLockTaken = lock.tryLock();
        if (isLockTaken) {
            isSeatBooked = true;

            // this will executes after a delay of 1000 and release the thread lock
            executor.schedule(() -> {
                if (lock.isHeldByCurrentThread()) {
                    System.out.println("Auto Releasing seat");
                    isSeatBooked = false;
                    lock.unlock();
                }
            }, 1000, TimeUnit.MILLISECONDS);
            // Can have long running logic or user can go idle here
            return isSeatBooked;

        } else {
            System.out.println("Seat not available try another seat");
            return isSeatBooked;
        }

    }

}

public class ExpiringReentrantLock {
    public static void main(String[] args) {

        BookMovieTicket book = new BookMovieTicket();
        System.out.println();

        System.out.println(book.bookSeat("r1"));
    }

}
