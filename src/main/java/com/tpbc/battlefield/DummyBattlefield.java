package com.tpbc.battlefield;

import com.tpbc.client.IClient;

import java.util.Random;

public class DummyBattlefield implements IBattleField {
    IClient fighter1, fighter2;
    Random random;

    @Override
    public void init(IClient fighter1, IClient fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        random = new Random();
    }

    @Override
    public IBattleResult fight() {
        IBattleResult result = new DummyBattleResult();
        int whoWins = random.nextInt(3);
        if (whoWins == 0) {
            result.setWinner(fighter1);
            result.setLooser(fighter2);
        }
        else {
            result.setWinner(fighter2);
            result.setLooser(fighter1);
        }
        return result;
    }
}
