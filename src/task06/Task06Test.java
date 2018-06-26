package task06;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

//任务6-2模拟注册新浪微博用户
public class Task06Test {
    private static HashSet<Users> hs = new HashSet<>();

    public static void main(String[] args) {
        init();
//        Users u1 = new Users("张三", "123456", "asdw@email.com", new Date(1995 - 6 - 17), "18236589657");
//        System.out.println(hs.add(u1));//没有users中的重写会返回true，有重写会返回false

        Scanner sc = new Scanner(System.in);

        System.out.println("输入用户名");
        String userName = sc.nextLine();

        System.out.println("输入密码");
        String password = sc.nextLine();

        System.out.println("再次输入密码");
        String rePassword = sc.nextLine();

        System.out.println("输入邮箱");
        String email = sc.nextLine();

        System.out.println("输入生日(格式：YYYY-MM-DD)");
        String birthday = sc.nextLine();

        System.out.println("输入手机号码");
        String phoneNumber = sc.nextLine();

        System.out.println(check(userName, password, rePassword, email, birthday, phoneNumber));
    }

    private static void init() {
        Users u1 = new Users("张三", "123456", "asdw@email.com", new Date(1995 - 6 - 17), "18236589657");
        Users u2 = new Users("李四", "369852", "muyx@qq.com", new Date(1997 - 2 - 10), "18895653545");

        hs.add(u1);
        hs.add(u2);

    }

    private static String check(String name, String password, String rePassword, String email, String birthday, String phoneNumber) {
        StringBuilder result = new StringBuilder();
        boolean state = true;
        boolean biState = true;

        if (!password.equals(rePassword)) {
            result.append("密码不一致！\r\n");
            state = false;
        }

        if (birthday.length() != 10) {
            result.append("生日错误！\r\n");
            state = false;
        } else {
            int year = 0, month = 0, day = 0;

            for (int i = 0; i < birthday.length(); i++) {
                Character bc = birthday.charAt(i);

                if (i == 4 | i == 7) {

                    if (!(bc.equals('-'))) {
                        result.append("生日格式不正确！\r\n");
                        state = false;
                        biState = false;
                    }

                } else {

                    if (!(Character.isDigit(bc))) {
                        result.append("生日格式不正确！\r\n");
                        state = false;
                        biState = false;
                    }

                }

                int ibc = Character.getNumericValue(bc);//将Char转换为int

                if (biState) {
                    switch (i) {
                        case 0:
                            year += ibc * 1000;
                            break;
                        case 1:
                            year += ibc * 100;
                            break;
                        case 2:
                            year += ibc * 10;
                            break;
                        case 3:
                            year += ibc;
                            break;
                        case 5:
                            month += ibc * 10;
                            break;
                        case 6:
                            month += ibc;
                            break;
                        case 8:
                            day += ibc * 10;
                            break;
                        case 9:
                            day += ibc;
                            break;
                    }
                }
            }


            DateFormat df = new SimpleDateFormat("yyyy");
            int thisYear = Integer.parseInt(df.format(new Date()));

            if (year < 1 || year > thisYear) {
                result.append("年份错误！\r\n");
                state = false;
            }

            if (month > 12 || month < 1) {
                result.append("月份错误！\r\n");
                state = false;
            }

            switch (month) {
                case 2:
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        if (day > 29) {
                            result.append("日期错误！\r\n");
                            state = false;
                        }
                    } else {
                        if (day > 28) {
                            result.append("日期错误！\r\n");
                            state = false;
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30) {
                        result.append("日期错误！\r\n");
                        state = false;
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 12:
                    if (day > 31) {
                        result.append("日期错误！\r\n");
                        state = false;
                    }
                    break;
                default:
                    if (day > 31) {
                        result.append("日期错误！\r\n");
                        state = false;
                    }
                    break;
            }
        }

        if (phoneNumber.length() != 11) {
            result.append("手机号码不正确！\r\n");
            state = false;
        } else if (!(phoneNumber.startsWith("13") | phoneNumber.startsWith("15") | phoneNumber.startsWith("18")
                   | phoneNumber.startsWith("17") | phoneNumber.startsWith("14") | phoneNumber.startsWith("19") | phoneNumber.startsWith("16"))) {
            result.append("手机号码不正确！\r\n");
            state = false;
        }

        if (!email.contains("@")) {
            result.append("邮箱不正确！\r\n");
            state = false;
        }
        if (state) {
            DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
            Date dateBirthday = null;

            try {
                dateBirthday = df.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Users users = new Users(name, rePassword, email, dateBirthday, phoneNumber);

            if (!hs.add(users)) {
                result.append("用户名重复！");
            } else {
                return "注册成功！";
            }

        }

        return result.toString();
    }
}
