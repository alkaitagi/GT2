import java.util.Arrays;
import gametheory.assignment2.Player;
import gametheory.assignment2.students2021.*;

public class App {
    public static void main(String[] args) throws Exception {
        Player[] players = new Player[] { new Alpha(), new Beta(), new Alpha(), new Beta(), new Traveller() };

        double[] scores = runTests(100, players);
        System.out.println(Arrays.toString(scores));
    }

    public static double[] runTests(int rounds, Player[] players) {
        double[] scores = new double[players.length];
        for (int i = 0; i < players.length; i++)
            scores[i] = 0;

        for (int i = 0; i < players.length; i++)
            for (int j = 0; j < players.length; j++)
                if (i != j) {
                    int[] fs = new int[] { 0, 1, 1, 1 };
                    Player p1 = players[i];
                    Player p2 = players[j];
                    int lm1 = 0;
                    int lm2 = 0;

                    for (int r = 0; r < rounds; r++) {
                        int lm1t = p1.move(lm2, fs[0], fs[1], fs[2]);
                        lm2 = p2.move(lm1, fs[0], fs[1], fs[2]);
                        lm1 = lm1t;

                        if (lm1 == lm2)
                            fs[lm1] -= 2;
                        else {
                            scores[i] += getScore(fs[lm1]);
                            scores[j] += getScore(fs[lm2]);
                            fs[lm1] -= 2;
                            fs[lm1] -= 2;
                        }

                        for (int f = 1; f < 4; f++)
                            if (++fs[f] < 0)
                                fs[f] = 0;
                    }
                }
        return scores;
    }

    public static double getScore(int x) {
        if (x < 0)
            x = 0;
        return sigmoid(x) - sigmoid(0);
    }

    public static double sigmoid(int x) {
        return 10 * Math.exp(x) / (1 + Math.exp(x));
    }
}
