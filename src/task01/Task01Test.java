package task01;

public class Task01Test {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.add(new Mouse());
        c.add(new Mic());
        c.add(new KeyBoard());
        System.out.println("启动中");
        c.powerOn();
        System.out.println("正在关机");
        c.powerOff();
    }
}
