package gametheory.assignment2.students2021;

import gametheory.assignment2.Player;

public class Alpha implements Player {
    public Alpha() {
        reset();
    }

    @Override
    public void reset() {
        return;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        if (xA >= xB && xA >= xC)
            return 1;
        if (xB >= xA && xB >= xC)
            return 2;
        return 3;
    }

    @Override
    public String getEmail() {
        return "ma.magomedov@innopolis.ru";
    }
}
