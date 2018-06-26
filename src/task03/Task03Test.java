package task03;

//任务5-1记录一个子串在整串中出现的次数
public class Task03Test {
    public static void main(String[] args) {
        String str = "asdasddoasdasdoijdasdasdadoiujoiasjdasoiuasd";
        String key = "asd";
        int count = getKeyStringCount(str, key);
        System.out.println("Count:" + count);
    }

    public static int getKeyStringCount(String str, String key) {
        int count = 0;
        if (!str.contains(key)) {
            return count;
        }
        int index;
        while ((index = str.indexOf(key)) != -1) {
            str = str.substring(index + key.length());
            count++;

        }
        return count;
    }
}
