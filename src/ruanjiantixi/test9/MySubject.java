package ruanjiantixi.test9;

import java.util.ArrayList;
import java.util.List;

public abstract class MySubject {
    List<MyObserver> observers = new ArrayList<>();

    public abstract void attach(MyObserver observer);

    public abstract void detach(MyObserver observer);

    public abstract void fire();
}
