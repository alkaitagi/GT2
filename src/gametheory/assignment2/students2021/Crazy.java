package gametheory.assignment2.students2021;

import java.util.Random;
import gametheory.assignment2.Player;

public class Crazy implements Player {
    public Crazy() {
        reset();
    }

    @Override
    public void reset() {
        return;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        return new Random().nextInt(3) + 1;
    }

    @Override
    public String getEmail() {
        return "ma.magomedov@innopolis.ru";
    }
}
