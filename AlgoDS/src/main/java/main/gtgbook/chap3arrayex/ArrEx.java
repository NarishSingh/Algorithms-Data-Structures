package main.gtgbook.chap3arrayex;

public class ArrEx {

    public static void main(String[] args) {
        ScoreBoard sc1 = new ScoreBoard(10);

        sc1.add(new GameEntry("Singh", 100));
        sc1.add(new GameEntry("Singh2", 52));
        sc1.add(new GameEntry("Singh3", 97));
        sc1.add(new GameEntry("Singh4", 86));
        sc1.add(new GameEntry("Singh5", 20));
        sc1.add(new GameEntry("Singh6", 99));
        sc1.add(new GameEntry("Singh7", 82));
        sc1.add(new GameEntry("Singh8", 69));
        sc1.add(new GameEntry("Singh9", 31));
        sc1.add(new GameEntry("Singh10", 94));
        sc1.add(new GameEntry("Singh11", 88));
        sc1.add(new GameEntry("Singh12", 64));
        sc1.add(new GameEntry("Singh13", 19));

//        sc1.remove(0);

        System.out.println(sc1.toString());
    }
}
