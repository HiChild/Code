package ruanjiantixi.test9;

public class People implements MyObserver {
    @Override
    public void respond() {
        System.out.println("普通民众发现着火了，迅速撤离");
    }
}
