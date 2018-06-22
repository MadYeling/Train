package task09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("InfiniteLoopStatement")
public class Task09Test {
    private static String msg = "";
    private static String filePath;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===1.新建文件 2.打开文件 3.修改文件 4.保存文件 5.退出===");

        while (true) {
            System.out.println("请输入命令");
            int cmd = sc.nextInt();

            switch (cmd) {
                case 1:
                    newFile();
                    break;
                case 2:
                    openFile();
                    break;
                case 3:
                    altFile();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("输入的数字不正确");
                    break;
            }
        }
    }

    private static void newFile() {//case1
        msg = "";
        StringBuilder sb = new StringBuilder();
        String str = "";
        System.out.println("输入内容，想停止请输入“stop");
        while (!str.equals("stop")) {

            if (sb.length() > 0) {
                sb.append("\r\n");
            }

            sb.append(str);
            str = sc.nextLine();
        }

        msg = sb.toString();
    }

    private static void openFile() {//case2
        msg = "";

        System.out.println("输入文本文件路径");
        filePath = sc.next();

        if (filePath != null && !filePath.endsWith(".txt")) {
            System.out.println("输入文件错误，请输入文本文件路径");
            System.out.println(filePath);
            return;
        }

        StringBuilder sb = new StringBuilder();
        FileReader fr = null;

        try {
            fr = new FileReader(filePath);
            char[] chars = new char[1024];

            int len = 0;

            while ((len = fr.read(chars)) != -1) {
                sb.append(chars);
            }

        } catch (FileNotFoundException e) {
            System.out.println("未找到文件，请检查文件路径是否正确！");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        msg = sb.toString();
        System.out.println("打开的文件内容为：\r\n" + msg);

    }

    private static void altFile() {//case3
        if (msg.equals("") && filePath == null) {
            System.out.println("请先打开一个文件或新建一个文件");
            return;
        }

        System.out.println("请输入想修改的内容，格式为 [原本的内容]:[替换的内容] \r\n结束修改输入“stop” ");
        String str = "";
        while (!str.equals("stop")) {
            str = sc.nextLine();
            if (str.length() > 0) {
                String[] str1 = str.split(":");
                if (str1.length > 1) {
                    msg = msg.replace(str1[0], str1[1]);
                }
            }
        }

        System.out.println("修改后的文件内容为：\r\n" + msg);
    }

    private static void saveFile() {//case4
        FileWriter fw = null;
        try {
            if (filePath != null) {
                fw = new FileWriter(filePath);
            } else {
                System.out.println("输入文件保存路径");
                filePath = sc.nextLine();
                if (filePath.toLowerCase().endsWith(".txt")) {
                    filePath += ".txt";
                }
                fw = new FileWriter(filePath);
            }

            fw.write(msg);
            System.out.println("文件保存完成");
            msg = "";
            filePath = null;

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void exit() {//case5
        System.out.println("=========================================");
        System.out.println("已退出");
        System.exit(0);
    }

}
