package task05;

import java.util.ArrayList;
import java.util.Scanner;

public class Task05Test {
    private static ArrayList<String> musicList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("============欢迎来到点歌系统！============");
        System.out.println("0.添加新歌曲");
        System.out.println("1.将歌曲置顶");
        System.out.println("2.将歌曲前移一位");
        System.out.println("3.退出");
        System.out.println("=========================================");
        Initialization(musicList);

        while (true) {
            System.out.println("=========================================");
            System.out.println("请输入操作编号");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            switch (n) {
                case 0:
                    addMusic(musicList);
                    break;
                case 1:
                    moveToTop();
                    break;
                case 2:
                    moveToFront();
                    break;
                case 3:
                    exit();
                default:
                    System.out.println("输入的数字不正确");
                    break;
            }
        }
    }


    private static void Initialization(ArrayList<String> list) {
        list.add("βίος");
        list.add("aLIEz");
        list.add("Hill Of Sorrow");
        list.add("Perfect Time");
        list.add("MKAliez");
        list.add("Samsara");
        System.out.println("初始化歌单");
        System.out.println("当前曲目：" + musicList);
    }

    private static void addMusic(ArrayList<String> list) {
        System.out.println("输入歌曲名称：");
        Scanner sc = new Scanner(System.in);
        String mName = sc.nextLine();
        list.add(mName);
        System.out.println("添加完成");
        System.out.println("当前曲目：" + musicList);
    }

    private static void moveToTop() {
        System.out.println("输入需要置顶的歌曲：");
        Scanner sc = new Scanner(System.in);
        String mName = sc.nextLine();
        int p = musicList.indexOf(mName);

        if (p < 0) {
            System.out.println("输入的名称不正确或当前列表没有该曲目");
        } else {
            musicList.remove(mName);
            musicList.add(0, mName);
            System.out.println("歌曲：" + mName + " 已置顶");
        }
        System.out.println("当前曲目：" + musicList);
    }

    private static void moveToFront() {
        System.out.println("输入需要前移的歌曲：");
        Scanner sc = new Scanner(System.in);
        String mName = sc.nextLine();
        int p = musicList.indexOf(mName);

        if (p < 0) {
            System.out.println("输入的名称不正确或当前列表没有该曲目");
        } else {
            musicList.remove(mName);
            musicList.add(p - 1, mName);
            System.out.println("歌曲：" + mName + " 已前移");
        }
        System.out.println("当前曲目：" + musicList);
    }


    private static void exit() {
        System.out.println("=========================================");
        System.out.println("已退出");
        System.exit(0);
    }
}