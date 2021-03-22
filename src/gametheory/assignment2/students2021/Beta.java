package gametheory.assignment2.students2021;

import gametheory.assignment2.Player;

public class Beta implements Player {
    public Beta() {
        reset();
    }

    @Override
    public void reset() {
        return;
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        if (xB >= xA && xA >= xC)
            return 1;
        if (xA >= xB && xB >= xC)
            return 2;
        return 3;
    }

    @Override
    public String getEmail() {
        return "ma.magomedov@innopolis.ru";
    }
}
