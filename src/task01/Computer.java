package task01;

public class Computer {
    private USB[] usbArray = new USB[4];

    public void add(USB usb) {
        for (int i = 0; i < usbArray.length; i++) {
            if (usbArray[i] == null) {
                usbArray[i] = usb;
                break;
            }
        }
    }

    public void powerOn() {
        for (USB anUsbArray : usbArray) {
            if (anUsbArray != null) {
                anUsbArray.turnOn();
            }
        }
        System.out.println("计算机开机完成");
    }

    public void powerOff() {
        for (USB anUsbArray : usbArray) {
            if (anUsbArray != null) {
                anUsbArray.turnOff();
            }
        }
        System.out.println("计算机关机完成");
    }

}
