package task02;

public class Task02Test {
    public static void main(String[] args) {
        SendTask st = new SendTask("HYX600235", 76.32);
        st.sendBefore();
        System.out.println("==============================");
        ZTransportation zt = new ZTransportation("Z025", "大奔", "李雷");
        Phone p = new Phone();
        st.send(zt, p);
        System.out.println("==============================");
        st.sendAfter(zt);
        zt.upkeep();
    }
}
