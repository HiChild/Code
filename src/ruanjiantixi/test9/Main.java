package ruanjiantixi.test9;

public class Main {
    public static void main(String[] args) {
        SuperMarket superMarket = new SuperMarket();
        FireMan fireMan = new FireMan();
        People people = new People();
        superMarket.attach(fireMan);
        superMarket.attach(people);
        superMarket.fire();
    }
}
