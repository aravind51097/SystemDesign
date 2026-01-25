package LLD.MultiThreading.Ways_of_creating_Threads;

import java.util.concurrent.Callable;

class waitAndGetTheValue implements Callable<String> {
    private String str = null;

    @Override
    public String call() throws Exception {
        str = addSomeString(str);
        return str;
    }

    private String addSomeString(String str2) {
        str += ": Adding the str";
        return str;
    }

}

public class ByImplementingCallable {
    public static void main(String[] args) throws Exception {
        Callable<String> calling = new waitAndGetTheValue();
        Callable<String> calling2 = new waitAndGetTheValue();

        System.out.println(calling.call());
        System.out.println(calling.call());
        System.out.println(calling2.call());

    }
}
