package task02;

public class ZTransportation extends Transportation implements Maintain {

    public ZTransportation(String number, String model, String admin) {
        super(number, model, admin);
    }

    @Override
    public void upkeep() {
        System.out.println("保养完毕");
    }

    @Override
    public void transport() {
        System.out.println("运输中...");
    }
}
