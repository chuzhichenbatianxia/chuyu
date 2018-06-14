package chuyu;


/**
 * Created by Administrator on 2018/4/13.
 */
public class TestList {
    public static void main(String[] args) {
        StringBuilder h = new StringBuilder("abc");
        h.setCharAt(0,'g');
        System.out.println(h.toString());
        System.out.println(h.deleteCharAt(0));
    }


}
