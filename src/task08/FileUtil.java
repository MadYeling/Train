package task08;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileUtil {
    private static final String FILENAME = "book" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".txt";
    private static final String HEAD = "图书编号,图书名称,图书价格,购买数量,总价,";

    static void loadBooks() {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(FILENAME));
            String str;
            Books[] books = new Books[5];
            int i = 0;

            while ((str = bufferedReader.readLine()) != null) {//逐行读取

                if (str.equals(HEAD)) {
                    continue;//屏蔽表头
                }

                String[] str1 = str.split(",");//正则截取
                books[i] = new Books(Integer.parseInt(str1[0]), str1[1], Float.parseFloat(str1[3]),Integer.parseInt(str1[3]));//强制转换类型并存入books
                i++;
            }

            for (Books book : books) {
                System.out.println(book.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    static void saveBooks(Books books) {
        InputStream is;

        try {
            is = new FileInputStream(FILENAME);//尝试读一下文件，没有读到抛出FileNotFoundException
            is.close();
            createFile(books, true);

        } catch (FileNotFoundException e) {
            //没有读到文件，需要添加表头
            createFile(books, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile(Books books, Boolean isLabel) {
        BufferedOutputStream out = null;
        StringBuilder sb = new StringBuilder();

        try {
            if (isLabel & !(isWrittenLast() | !isWrittenHead())) {
                //这里对文件开头与末尾进行判断，已存在信息则进行覆写，防止无限追加信息，开头无表头则追加表头。

                out = new BufferedOutputStream(new FileOutputStream(FILENAME, true));//参数true代表每次输入属于追加信息

            } else {

                out = new BufferedOutputStream(new FileOutputStream(FILENAME));
                String[] filedSort = new String[]{"图书编号", "图书名称", "图书价格", "购买数量", "总价"};

                for (String filedKey : filedSort) {//每个字段后面加","
                    sb.append(filedKey).append(",");
                }

                System.out.println("加入了一个表头");

            }

            sb.append("\r\n");//换行
            sb.append(books.getId()).append(",");
            sb.append(books.getName()).append(",");//图书名称
            sb.append(books.getPrice()).append(",");//图书价格
            sb.append(books.getNumber()).append(",");//图书数量
            sb.append(books.getSales()).append(",");//总价
            System.out.println("追加了一些信息");

            String str1 = sb.toString();
            byte[] b = str1.getBytes();

            for (byte aB : b) {//遍历字节
                out.write(aB);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {//无论是否出错都关闭out流

            try {
                if (out != null)
                    out.close();

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

    private static boolean isWrittenLast() {//查找是否写了最后一本书的内容
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(FILENAME));
            String str;

            while ((str = bufferedReader.readLine()) != null) {

                if (!str.isEmpty()) {//防止读取到空行出现错误
                    if (str.substring(0, 4).equals("1005")) {//防止修改价格后读取不到对应字符串
                        System.out.println("文件似乎被写过了");
                        bufferedReader.close();
                        return true;
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("未读取到文件");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

        return false;
    }

    private static boolean isWrittenHead() {//查找是否写了表头
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(FILENAME));
            String str;

            while ((str = bufferedReader.readLine()) != null) {
                if (str.equals(HEAD)) {
                    bufferedReader.close();
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("未读取到文件");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

        System.out.println("未读取到表头");
        return false;
    }
}
