package ruanjiantixi.test9;

public class FireMan implements MyObserver {
    @Override
    public void respond() {
        System.out.println("消防队员灭火");
    }
}
