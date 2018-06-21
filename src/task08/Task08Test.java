package task08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task08Test {
    private static ArrayList<Books> bookList = new ArrayList<>();

    private static void init() {
        Books books1 = new Books(1001, "Java程序设计", 44.5f, 100);
        Books books2 = new Books(1002, "Java开发实践", 108f, 50);
        Books books3 = new Books(1003, "C++程序设计指南", 99f,100);
        Books books4 = new Books(1004, "EJB3.0入门经典", 59.8f, 128);
        Books books5 = new Books(1005, "Spring3.0 in Action", 95.8f, 118);

        bookList.add(books1);
        bookList.add(books2);
        bookList.add(books3);
        bookList.add(books4);
        bookList.add(books5);
    }

    private static void Enter() throws IOException {//停顿
        System.out.println();
        System.out.println("按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public static void main(String[] args) {
        init();

        for (Books aBookList : bookList)
            FileUtil.saveBooks(aBookList);

        System.out.println();

        FileUtil.loadBooks();

    }
}
