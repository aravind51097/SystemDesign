package SingleTon;
//Eager loading single ton class 

class EagerLoadingSingleton {
    private static EagerLoadingSingleton instance = new EagerLoadingSingleton();

    private EagerLoadingSingleton() {
    };

    public static EagerLoadingSingleton getInstance() {
        return instance;
    }
}

// Lazy loading

class LazyLoadingSingleton {
    private static LazyLoadingSingleton instance;

    private LazyLoadingSingleton() {
    };

    public static LazyLoadingSingleton getInstance() {
        if (instance == null) {
            instance = new LazyLoadingSingleton();
        }
        return instance;
    }

}

// single tone double cheked with thread safe
// Thread safe and lazy loading
// ** importatnt pattern
public class DubleCheckedSingletonPattern {
    private static volatile DubleCheckedSingletonPattern instance;

    private DubleCheckedSingletonPattern() {
    };

    public static DubleCheckedSingletonPattern getInstance() {
        if (instance == null) {
            synchronized (DubleCheckedSingletonPattern.class) {
                if (null == instance) {
                    instance = new DubleCheckedSingletonPattern();
                }
            }
        }
        return instance;
    }

    public void welcomeUser() {
        System.out.println("Hello User ! ");
    }
}