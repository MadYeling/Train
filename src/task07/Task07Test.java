package task07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//任务6-3斗地主小游戏之洗牌发牌
public class Task07Test {
    public static void main(String[] args) {
        ArrayList<String> suit = new ArrayList<>();

        suit.add("♠");
        suit.add("♥");
        suit.add("♦");
        suit.add("♣");

        ArrayList<String> number = new ArrayList<>();
        for (int i = 3; i < 11; i++) {
            number.add(i + "");
        }

        number.add("J");
        number.add("Q");
        number.add("K");
        number.add("A");
        number.add("2");

        HashMap<Integer, String> map = new HashMap<>();
        int index = 0;

        for (String aSuit : suit) {
            for (String aNumber : number) {
                map.put(index++, aSuit + aNumber);
            }
        }

        map.put(index++, "小王");
        map.put(index, "大王");

        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            cards.add(i);
        }
        Collections.shuffle(cards);

        ArrayList<Integer> iPlayer1 = new ArrayList<>(), iPlayer2 = new ArrayList<>(), iPlayer3 = new ArrayList<>(), iSecret = new ArrayList<>();


        for (int i = 0; i < cards.size(); i++) {
            if (i > 50) {
                iSecret.add(cards.get(i));
            } else {
                if (i % 3 == 0) {
                    iPlayer1.add(cards.get(i));
                } else if (i % 3 == 1) {
                    iPlayer2.add(cards.get(i));
                } else {
                    iPlayer3.add(cards.get(i));
                }
            }
        }

        Collections.shuffle(iPlayer1);
        Collections.shuffle(iPlayer2);
        Collections.shuffle(iPlayer3);

        ArrayList<String> sPlayer1 = new ArrayList<>(), sPlayer2 = new ArrayList<>(), sPlayer3 = new ArrayList<>(), sSecret = new ArrayList<>();

        for (Integer key : iPlayer1) {
            sPlayer1.add(map.get(key));
        }

        for (Integer key : iPlayer2) {
            sPlayer2.add(map.get(key));
        }

        for (Integer key : iPlayer3) {
            sPlayer3.add(map.get(key));
        }

        for (Integer key : iSecret) {
            sSecret.add(map.get(key));
        }

        System.out.println("玩家1：" + sPlayer1);
        System.out.println("玩家2：" + sPlayer2);
        System.out.println("玩家3：" + sPlayer3);
        System.out.println("底牌：" + sSecret);

    }
}
