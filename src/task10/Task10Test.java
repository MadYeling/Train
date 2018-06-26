package task10;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//任务7-3模拟文件管理器
@SuppressWarnings("InfiniteLoopStatement")
public class Task10Test {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===1.指定关键字检索文件  2.指定后缀检索文件  3.复制文件/目录  4.退出===");

        while (true) {
            System.out.println("请输入指令");
            int cmd = sc.nextInt();
            switch (cmd) {
                case 1:
                    searchByKey();
                    break;
                case 2:
                    searchBySuffix();
                    break;
                case 3:
                    copyFile();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("指令不正确");
                    break;
            }
        }

    }

    private static void searchByKey() {
        System.out.println("输入需要检索的目录");//切勿直接输入某个盘，检索时间太长了
        String path = sc.next();

        File file = new File(path);

        if (!file.exists() || !file.isDirectory()) {
            System.out.println("目录不存在");
            return;
        }

        System.out.println("输入需要检索的关键词");
        String key = sc.next();

        ArrayList<String> arrayList = listFiles(file, key);
        for (Object obj : arrayList) {
            System.out.println(obj);
        }

    }

    private static void searchBySuffix() {
        System.out.println("输入需要检索的目录");
        String path = sc.next();
        File file = new File(path);

        if (!file.exists() || !file.isDirectory()) {
            System.out.println("目录不存在");
            return;
        }

        System.out.println("输入需要检索的后缀名(不需要输入“.”并且多个后缀请用“,”隔开)");
        String[] suffix = sc.next().split(",");

        ArrayList<String> arrayList = listFiles(file, suffix);
        for (Object obj : arrayList) {
            System.out.println(obj);
        }
    }

    private static void copyFile() {
        System.out.println("输入复制源目录");
        String path = sc.next();
        File file = new File(path);

        if (!file.exists() || !file.isDirectory()) {
            System.out.println("目录不存在");
            return;
        }

        System.out.println("输入目标目录");
        String path1 = sc.next();
        File file1 = new File(path1);

        if (!file.exists() || !file.isDirectory()) {
            System.out.println("目标目录错误");
            return;
        }

        copyFileTo(file, file1);

    }

    private static void exit() {
        System.out.println("=================================");
        System.out.println("系统已退出");
        System.exit(0);
    }

    private static ArrayList<String> listFiles(File path, String key) {
        FilenameFilter filenameFilter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {//此方法返回false为抛弃，true为列出
                File file = new File(dir, name);
                if (file.isFile() && name.contains(key)) {
                    return true;
                }
                return false;
            }
        };
        return fileDir(path, filenameFilter);

    }

    private static ArrayList<String> listFiles(File path, String[] suffix) {
        FilenameFilter filenameFilter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {//此方法返回false为抛弃，true为列出
                File file = new File(dir, name);
                if (file.isFile()) {
                    for (String asuffix : suffix) {
                        if (name.endsWith("." + asuffix)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        return fileDir(path, filenameFilter);

    }

    private static void copyFileTo(File srcDir, File destDir) {
        File[] files = srcDir.listFiles();

        assert files != null;
        for (File file : files) {
            File copyFile = new File(destDir, file.getName());
            if (file.isDirectory()) {
                if (!copyFile.mkdirs()) {
                    System.out.println("无法创建文件夹");
                    return;
                }
                copyFileTo(file, copyFile);
            } else {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(copyFile);
                    byte[] buffer = new byte[1024];
                    int n = 0;
                    while ((n = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, n);
                    }

                    fis.close();
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static ArrayList<String> fileDir(File dir, FilenameFilter filter) {
        ArrayList<String> arrayList = new ArrayList<>();
        File[] lists = dir.listFiles(filter);

        assert lists != null;
        for (File file : lists) {
            arrayList.add(file.getAbsolutePath());
        }

        File[] files = dir.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                ArrayList<String> al = fileDir(file, filter);
                arrayList.addAll(al);
            }
        }
        return arrayList;
    }

}
