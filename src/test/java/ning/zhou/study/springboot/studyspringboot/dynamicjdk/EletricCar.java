package ning.zhou.study.springboot.studyspringboot.dynamicjdk;

public class EletricCar implements Rechargable,Vechile {
    @Override
    public void recharge() {
        System.out.println("recharge");
    }

    @Override
    public void drive() {
        System.out.println("drive");
    }
}
