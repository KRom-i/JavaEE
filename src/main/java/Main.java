import java.util.Random;

public class Main {

    private final static int HEIGHT = 6;
    private final static int NUMBER_TREES = 100_000;
    private static int balance;

    public static void main(String[] args) {

        Random random = new Random ();

        for (int i = 0; i < NUMBER_TREES; i++) {

            MyTreeMap<Integer, Integer> map = new MyTreeMap<> ();

            while (map.height () < (HEIGHT + 1)){
                map.put (random.nextInt (100), random.nextInt ());
            }

            if (map.isBalance ()){
                balance++;
            }

        }

        System.out.println ("NUMBER_TREES=" + NUMBER_TREES);
        System.out.println ("balance=" + balance);
        System.out.println ("balance=" + (double) ((balance / NUMBER_TREES) * 100) + "%");

    }
}
