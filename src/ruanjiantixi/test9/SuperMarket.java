package ruanjiantixi.test9;

public class SuperMarket extends MySubject {
    @Override
    public void attach(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(MyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void fire() {
        System.out.println("火灾发生了");
        for (MyObserver observer : observers) {
            observer.respond();
        }
    }
}
